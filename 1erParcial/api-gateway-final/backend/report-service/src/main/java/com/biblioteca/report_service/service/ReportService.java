package com.biblioteca.report_service.service;

import com.biblioteca.report_service.dto.ReportResponseDTO;
import com.biblioteca.report_service.entity.Report;
import com.biblioteca.report_service.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Generar un reporte
    public ReportResponseDTO generateReport(String type, LocalDate startDate, LocalDate endDate) {
        // Simulación: Obtener datos de otros servicios y construir el contenido del reporte
        String content = fetchDataForReport(type, startDate, endDate);

        // Guardar el reporte en la base de datos
        Report report = new Report();
        report.setType(type);
        report.setContent(content);
        report.setGeneratedAt(LocalDateTime.now());
        Report savedReport = reportRepository.save(report);

        return mapToResponseDTO(savedReport);
    }

    private String fetchDataForReport(String type, LocalDate startDate, LocalDate endDate) {
        // Implementar lógica para consumir APIs de otros servicios (user-service, loan-service, book-service)
        return "{ \"example\": \"data\" }"; // Simulación
    }

    private ReportResponseDTO mapToResponseDTO(Report report) {
        ReportResponseDTO dto = new ReportResponseDTO();
        dto.setId(report.getId());
        dto.setType(report.getType());
        dto.setContent(report.getContent());
        dto.setGeneratedAt(report.getGeneratedAt());
        return dto;
    }
}
