package rain.task.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/get")
public class RestController {
    @Produces({ MediaType.TEXT_PLAIN })
    @GET
    public Response getHeartBeat() {
        return Response.ok("OK").build();
    }
}
