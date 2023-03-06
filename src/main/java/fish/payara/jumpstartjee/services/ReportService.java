package fish.payara.jumpstartjee.services;

import fish.payara.jumpstartjee.entities.ReportEntity;
import fish.payara.jumpstartjee.repositories.ReportRepository;

import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

public class ReportService {

    @Inject ReportRepository reportRepository;

    public ReportEntity geReportById(Long reportId) {
        return reportRepository.geReportById(reportId);
    }

    public ReportEntity geReportByAccountIdDate(Long accountId, LocalDate date) {
        return reportRepository.geReportByAccountIdDate(accountId, date);
    }

    public ReportEntity postReport(ReportEntity reportEntity) {
        // NEED TO UPDATE LOGIC
        return reportRepository.postReport(reportEntity);
    }

    public void deleteReport(Long reportId) {
        var report = geReportById(reportId);
        reportRepository.deleteReport(report);
    }		

    public List<ReportEntity> getReportsByClientAccountIds(Long clientId, Long accountId) {
        return reportRepository.getReportsByClientAccountIds(clientId, accountId);
    }
  
}
