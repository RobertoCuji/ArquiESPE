package com.biblioteca.loan_service.service;

import com.biblioteca.loan_service.dto.LoanDTO;
import com.biblioteca.loan_service.entity.Loan;
import com.biblioteca.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    // Registrar un préstamo
    public LoanDTO registerLoan(LoanDTO loanDTO) {
        Optional<Loan> activeLoan = loanRepository.findByBookIdAndReturnDateIsNull(loanDTO.getBookId());
        if (activeLoan.isPresent()) {
            throw new IllegalStateException("El libro ya está prestado.");
        }

        Loan loan = Loan.builder()
                .bookId(loanDTO.getBookId())
                .userId(loanDTO.getUserId())
                .loanDate(LocalDate.now()) // Fecha del préstamo generada automáticamente
                .dueDate(loanDTO.getDueDate())
                .build();

        Loan savedLoan = loanRepository.save(loan);
        return mapToDTO(savedLoan);
    }

    // Registrar devolución de un libro
    public LoanDTO returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado."));
        loan.setReturnDate(LocalDate.now());

        // Calcular multa si la devolución es tardía
        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            loan.setFine(calculateFine(loan.getReturnDate(), loan.getDueDate()));
        }

        Loan updatedLoan = loanRepository.save(loan);
        return mapToDTO(updatedLoan);
    }

    // Renovar un préstamo
    public LoanDTO renewLoan(Long loanId, LocalDate newDueDate) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado."));
        loan.setDueDate(newDueDate);

        Loan updatedLoan = loanRepository.save(loan);
        return mapToDTO(updatedLoan);
    }

    // Listar todos los préstamos
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Mapeo de entidad a DTO
    private LoanDTO mapToDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setBookId(loan.getBookId());
        dto.setUserId(loan.getUserId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setDueDate(loan.getDueDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setFine(loan.getFine());
        return dto;
    }

    // Calcular multa
    private Double calculateFine(LocalDate returnDate, LocalDate dueDate) {
        long daysLate = returnDate.toEpochDay() - dueDate.toEpochDay();
        return daysLate * 1.0; // Multa de 1 unidad por día de retraso
    }
}
