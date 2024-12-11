package com.biblioteca.report_service.dto;

import lombok.Data;

@Data
public class CreateReportDTO {

    private String reportType;
    private String generatedBy;
    private byte[] content;

}