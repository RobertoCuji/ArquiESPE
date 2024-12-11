package com.biblioteca.report_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportResponse", propOrder = {
    "reportContent"
})
public class ReportResponse {

    protected String reportContent;

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String value) {
        this.reportContent = value;
    }
}
