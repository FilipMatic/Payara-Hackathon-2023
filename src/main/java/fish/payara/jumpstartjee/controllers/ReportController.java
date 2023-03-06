package fish.payara.jumpstartjee.controllers;

import fish.payara.jumpstartjee.entities.ReportEntity;
import fish.payara.jumpstartjee.services.ReportService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.List;

@Path("/report")

public class ReportController {

    @Inject
    private ReportService reportService;

    // Get loan by loanId
    @GET
    @Path("/{report_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ReportEntity getReportById(@PathParam("report_id") Long reportId) {
      return reportService.geReportById(reportId);
    }

    // Get report by date (month)
    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ReportEntity geReportByAccountIdDate(@PathParam("account_id") Long accountId, @PathParam("date") LocalDate date) {
      return reportService.geReportByAccountIdDate(accountId, date);
    }

    // Generate report
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ReportEntity postReport(ReportEntity reportEntity) {
      return reportService.postReport(reportEntity);
    }

    // Delete report
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteReport(Long reportId) {
      reportService.deleteReport(reportId);
    }

    // Get reports by clientId
    @GET
    @Path("/{client_id}/{account_id}/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReportEntity> getReportsByClientAccountIds(@PathParam("client_id") Long clientId, @PathParam("account_id") Long accountId) {
      return reportService.getReportsByClientAccountIds(clientId, accountId);
    }
  
}
