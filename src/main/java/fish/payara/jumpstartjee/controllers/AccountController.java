package fish.payara.jumpstartjee.controllers;

import fish.payara.jumpstartjee.entities.AccountEntity;
import fish.payara.jumpstartjee.services.AccountService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/account")
public class AccountController {

    @Inject
    private AccountService accountService;

    // Get account by accountId
    @GET
    @Path("/{account_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AccountEntity getAccountById(@PathParam("account_id") Long accountId) {
      var account = accountService.getAccountById(accountId);
      return account;
    }

    // Open account
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AccountEntity openAccount(AccountEntity accountEntity) {
      return accountService.openAccount(accountEntity);
    }

    // Close account
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void closeAccount(Long accountId) {
      accountService.closeAccountById(accountId);
    }

    // Get accounts by clientId
    @GET
    @Path("/{client_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountEntity> get(@PathParam("client_id") Long clientId) {
      return accountService.getAccountsByClientId(clientId);
    }
  
}
