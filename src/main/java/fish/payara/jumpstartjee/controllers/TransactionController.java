package fish.payara.jumpstartjee.controllers;

import fish.payara.jumpstartjee.entities.TransactionEntity;
import fish.payara.jumpstartjee.services.TransactionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/transaction")
public class TransactionController {

    @Inject
    private TransactionService transactionService;

    // Get transaction by transactionId
    @GET
    @Path("/{transaction_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TransactionEntity getTransactionById(@PathParam("transaction_id") Long transactionId) {
      var transaction = transactionService.getTransactionById(transactionId);
      return transaction;
    }

    // Post transaction
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TransactionEntity postTransaction(TransactionEntity transaction) {
      return transactionService.postTransaction(transaction);
    }

    // Flag (currently delete) transaction
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void flagTransaction(Long transactionId) {
      transactionService.flagTransaction(transactionId);
    }

    // Get transactions by accountId
    @GET
    @Path("/{client_id}/{account_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransactionEntity> getTransactionsByClientAccountIds(@PathParam("client_id") Long clientId, @PathParam("account_id") Long accountId) {
      return transactionService.getTransactionsByClientAccountIds(clientId, accountId);
    }
  
}
