package com.inspur.gs.commonutils.demo.data.ddd.api.webservices;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.UserPageQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserWebService {
    /**
     * Add
     */
    @POST
    @Path("/")
    public void addUser(User user);

    /**
     * Update
     */
    @PUT
    @Path("/")
    public void updateUser(User user);

    /**
     * Delete
     */
    @DELETE
    @Path("/{id}")
    public void delUser(@PathParam("id") String id);

    /**
     * GetById
     */
    @Path("/id")
    @GET
    public User getUserById(@QueryParam("id") String id);

    /**
     * GetAll
     */
    @GET
    @Path("/all")
    public List<User> getAllUsers();


    /**
     * GetByPage
     */
    @GET
    @Path("/pagequery")
    public UserPageQuery getUsersByPage(@QueryParam("pageNumber") int pageNumber, @QueryParam("pageSize") int pageSize);

}
