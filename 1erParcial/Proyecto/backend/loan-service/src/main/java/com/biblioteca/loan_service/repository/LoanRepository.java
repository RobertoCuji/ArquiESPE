package com.biblioteca.loan_service.repository;

import com.biblioteca.loan_service.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserIdAndReturnedFalse(Long userId);
}
