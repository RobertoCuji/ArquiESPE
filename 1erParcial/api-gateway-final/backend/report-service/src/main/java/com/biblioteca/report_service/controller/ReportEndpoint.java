package com.biblioteca.report_service.controller;

import com.biblioteca.report_service.dto.GenerateReportRequest;
import com.biblioteca.report_service.dto.GenerateReportResponse;
import com.biblioteca.report_service.dto.ReportResponseDTO;
import com.biblioteca.report_service.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReportEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/reports";

    @Autowired
    private ReportService reportService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GenerateReportRequest")
    @ResponsePayload
    public GenerateReportResponse generateReport(@RequestPayload GenerateReportRequest request) {
        ReportResponseDTO report = reportService.generateReport(request.getType(), request.getStartDate(), request.getEndDate());

        GenerateReportResponse response = new GenerateReportResponse();
        response.setReportId(report.getId());
        response.setContent(report.getContent());
        return response;
    }
}
