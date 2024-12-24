package com.biblioteca.loan_service.service;

import com.biblioteca.loan_service.dto.LoanDto;
import com.biblioteca.loan_service.entity.Loan;
import com.biblioteca.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(loan -> new LoanDto(loan.getId(), loan.getUserId(), loan.getBookId(),
                        loan.getLoanDate(), loan.getDueDate(), loan.isReturned()))
                .collect(Collectors.toList());
    }
    



    public List<LoanDto> getActiveLoans(Long userId) {
        return loanRepository.findByUserIdAndReturnedFalse(userId).stream()
                .map(loan -> new LoanDto(loan.getId(), loan.getUserId(), loan.getBookId(),
                        loan.getLoanDate(), loan.getDueDate(), loan.isReturned()))
                .collect(Collectors.toList());
    }

    public LoanDto registerLoan(LoanDto loanDto) {
        Loan loan = Loan.builder()
                .userId(loanDto.getUserId())
                .bookId(loanDto.getBookId())
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .returned(false)
                .build();
        Loan savedLoan = loanRepository.save(loan);
        return new LoanDto(savedLoan.getId(), savedLoan.getUserId(), savedLoan.getBookId(),
                savedLoan.getLoanDate(), savedLoan.getDueDate(), savedLoan.isReturned());
    }

    public LoanDto registerReturn(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setReturned(true);
        Loan updatedLoan = loanRepository.save(loan);
        return new LoanDto(updatedLoan.getId(), updatedLoan.getUserId(), updatedLoan.getBookId(),
                updatedLoan.getLoanDate(), updatedLoan.getDueDate(), updatedLoan.isReturned());
    }
}
