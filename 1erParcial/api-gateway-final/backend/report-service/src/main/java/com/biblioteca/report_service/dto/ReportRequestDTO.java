package com.biblioteca.report_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportRequestDTO {
    private String type;         // Tipo de reporte: "inventory", "loans", "returns"
    private LocalDate startDate; // Fecha inicial (opcional)
    private LocalDate endDate;   // Fecha final (opcional)
}
