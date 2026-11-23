package si.unilj.fri.prpo.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import si.unilj.fri.prpo.cdi.izjeme.DogodekNiNajdenException;

@Provider
public class DogodekNiNajdenMapper implements ExceptionMapper<DogodekNiNajdenException> {

    @Override
    public Response toResponse(DogodekNiNajdenException izjema) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
