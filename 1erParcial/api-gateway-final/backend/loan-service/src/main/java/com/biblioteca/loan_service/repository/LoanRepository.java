package com.biblioteca.loan_service.repository;

import com.biblioteca.loan_service.entity.Loan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByBookIdAndReturnDateIsNull(Long bookId); // Buscar préstamo activo de un libro
}