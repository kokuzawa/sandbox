package org.katsumi;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
@PermitAll
public class HelloResource
{
    @GET
    @Path("/admin")
    @RolesAllowed("ADMIN")
    public String admin()
    {
        return "Hello Admin!";
    }

    @GET
    @Path("/member")
    @RolesAllowed("MEMBER")
    public String member()
    {
        return "Hello Member!";
    }
}
