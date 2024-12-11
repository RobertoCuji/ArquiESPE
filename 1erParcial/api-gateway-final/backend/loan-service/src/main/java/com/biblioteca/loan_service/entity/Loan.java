package com.biblioteca.loan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookId; // ID del libro (referencia externa)

    @Column(nullable = false)
    private Long userId; // ID del usuario (referencia externa)

    @Column(nullable = false)
    private LocalDate loanDate; // Fecha del préstamo

    @Column(nullable = false)
    private LocalDate dueDate; // Fecha límite para la devolución

    @Column
    private LocalDate returnDate; // Fecha de devolución (nulo si no ha sido devuelto)

    @Column
    private Double fine; // Multa calculada al devolver tarde
}