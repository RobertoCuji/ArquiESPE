package com.biblioteca.report_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportDTO {

    private Long id;
    private String reportType;
    private LocalDateTime generatedAt;
    private String generatedBy;
    private byte[] content;
}