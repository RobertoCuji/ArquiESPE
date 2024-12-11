package com.biblioteca.loan_service.controller;

import com.biblioteca.loan_service.dto.LoanDTO;
import com.biblioteca.loan_service.entity.Loan;
import com.biblioteca.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Registrar un préstamo
    @PostMapping
    public ResponseEntity<LoanDTO> registerLoan(@RequestBody LoanDTO loanDTO) {
        return ResponseEntity.ok(loanService.registerLoan(loanDTO));
    }

    // Registrar devolución
    @PutMapping("/{loanId}/return")
    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long loanId) {
        return ResponseEntity.ok(loanService.returnBook(loanId));
    }

    // Renovar un préstamo
    @PutMapping("/{loanId}/renew")
    public ResponseEntity<LoanDTO> renewLoan(@PathVariable Long loanId, @RequestParam LocalDate newDueDate) {
        return ResponseEntity.ok(loanService.renewLoan(loanId, newDueDate));
    }

    // Listar todos los préstamos
    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    // Listar préstamos activos
    @GetMapping("/active")
    public ResponseEntity<List<LoanDTO>> getActiveLoans() {
        return ResponseEntity.ok(loanService.getActiveLoans());
    }

    // Historial de préstamos por usuario
    @GetMapping("/history/user/{userId}")
    public ResponseEntity<List<LoanDTO>> getLoanHistoryByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loanService.getLoanHistoryByUser(userId));
    }

    // Historial de préstamos por libro
    @GetMapping("/history/book/{bookId}")
    public ResponseEntity<List<LoanDTO>> getLoanHistoryByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(loanService.getLoanHistoryByBook(bookId));
    }
}
