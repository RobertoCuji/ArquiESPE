package com.biblioteca.report_service.dto;

import lombok.Data;

@Data
public class GenerateReportResponse {
    private Long reportId;       // ID del reporte generado
    private String content;      // Contenido del reporte (puede ser JSON o texto plano)
}
