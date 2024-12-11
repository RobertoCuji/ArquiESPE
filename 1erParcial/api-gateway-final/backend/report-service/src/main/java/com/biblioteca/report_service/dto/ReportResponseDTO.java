package com.biblioteca.report_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportResponseDTO {
    private Long id;             // ID del reporte
    private String type;         // Tipo de reporte
    private String content;      // Contenido del reporte (JSON o texto)
    private LocalDateTime generatedAt; // Fecha de generación
}
