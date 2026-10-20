package si.unilj.fri.prpo;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/katalog")
public class KatalogResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public KatalogItem get() {
        return new KatalogItem("Katalog REST API");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KatalogItem post(final KatalogItem item) {
        return item;
    }

    public record KatalogItem(String name) {
    }
}
