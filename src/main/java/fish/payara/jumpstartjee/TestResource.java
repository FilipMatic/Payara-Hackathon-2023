package fish.payara.jumpstartjee;

import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/filip-test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @Inject
    private GreetingService greetingService;

    @GET
    @Path("{test_person}")
    public JsonObject hello(@PathParam("test_person") final String visitor) {
      return greetingService.greet(visitor);
    }
  
}
