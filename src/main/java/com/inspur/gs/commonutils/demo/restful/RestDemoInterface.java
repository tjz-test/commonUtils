package com.inspur.gs.commonutils.demo.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RestDemoInterface {

    @POST
    @Path("/")
    String createNewOrder(String order);

    @PUT
    @Path("/state")
    String updateOrderSate(@FormParam("state") String state);

    @GET
    @Path("/{id}")
    String findOrderById(@PathParam("id") String id);

    @GET
    @Path("/")
    List<String> findOrderByCreationDate(
            @QueryParam("begin") Date begin,
            @QueryParam("end") Date end,
            @QueryParam("page") Integer page,
            @QueryParam("limit") Integer limit);

    @DELETE
    @Path("/{id}")
    void removeById(@PathParam("id") String id);

}
