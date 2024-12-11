package com.biblioteca.report_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRequest", propOrder = {
    "reportType"
})
public class ReportRequest {

    protected String reportType;

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String value) {
        this.reportType = value;
    }
}
