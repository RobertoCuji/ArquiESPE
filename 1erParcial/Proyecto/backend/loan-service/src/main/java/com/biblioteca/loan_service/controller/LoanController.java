package com.biblioteca.loan_service.controller;

import com.biblioteca.loan_service.dto.LoanDto;
import com.biblioteca.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Obtener todos los préstamos
    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    // Obtener préstamos activos de un usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanDto>> getActiveLoans(@PathVariable Long userId) {
        return ResponseEntity.ok(loanService.getActiveLoans(userId));
    }

    // Registrar un nuevo préstamo
    @PostMapping
    public ResponseEntity<LoanDto> registerLoan(@RequestBody LoanDto loanDto) {
        return ResponseEntity.ok(loanService.registerLoan(loanDto));
    }

    // Registrar la devolución de un préstamo
    @PutMapping("/{loanId}/return")
    public ResponseEntity<LoanDto> registerReturn(@PathVariable Long loanId) {
        return ResponseEntity.ok(loanService.registerReturn(loanId));
    }
}
