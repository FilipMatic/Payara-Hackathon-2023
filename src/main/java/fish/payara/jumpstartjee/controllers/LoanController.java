package fish.payara.jumpstartjee.controllers;

import fish.payara.jumpstartjee.entities.LoanEntity;
import fish.payara.jumpstartjee.services.LoanService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.List;

// Need to change return types to responses
@Path("/loan")
public class LoanController {

    @Inject
    private LoanService loanService;

    // Get loan by loanId
    @GET
    @Path("/{loan_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoanEntity getLoanById(@PathParam("loan_id") Long loanId) {
      return loanService.getLoanById(loanId);
    }

    // Post loan
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoanEntity postLoan(LoanEntity loanEntity) {
      return loanService.postLoan(loanEntity);
    }

    // Update loan amount
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoanEntity updateLoanAmount(Long loanId, BigDecimal amount) {
      return loanService.updateLoanAmount(loanId, amount);
    }

    // Close loan
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void closeLoan(Long loanId) {
      loanService.closeLoan(loanId);
    }

    // Get loans by clientId
    @GET
    @Path("/{client_id}/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LoanEntity> getLoansByClientId(@PathParam("client_id") Long clientId) {
      return loanService.getLoansByClientId(clientId);
    }
  
}
