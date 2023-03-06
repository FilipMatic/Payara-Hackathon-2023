package fish.payara.jumpstartjee.controllers;

import java.math.BigDecimal;

import fish.payara.jumpstartjee.entities.ClientEntity;
import fish.payara.jumpstartjee.services.AccountService;
import fish.payara.jumpstartjee.services.ClientService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// Need to change return types to responses
@Path("/client")
public class ClientController {

    @Inject
    private ClientService clientService;

    @Inject
    private AccountService accountService;

    // Get client by clientId
    @GET
    @Path("/{client_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientEntity getClientById(@PathParam("client_id") Long clientId) {
        return clientService.getClientById(clientId);
    }

    // Post client
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientEntity persistClient(ClientEntity clientEntity) {
        return clientService.persistClient(clientEntity);
    }

    // Delete client
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeClient(Long clientId) {
        clientService.removeClient(clientId);
    }

    // Get total by clientId
    @GET
    @Path("/{client_id}/total")
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal getClientAssets(@PathParam("client_id") Long clientId) {
        var totals = accountService.getTotalsByClientId(clientId);
        return totals;
    }
  
}
