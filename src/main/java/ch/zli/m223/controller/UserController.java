package ch.zli.m223.controller;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

/**
 * ZLI - M 223
 * @author Al-Kubaisi Abdullah
 * @version 23.11.2022
 * Controller to implement the endpoints
 */


@Path("/user")
@Tag(name = "User", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public List<User> getAllUsers() {
        return userService.listAll();
    }

    @GET
    @Path("/others")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("member")
    public List<User> seeAllMembers() {
        return userService.listAll();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public User getUser(@PathParam("id") long id) {
        return userService.findById(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public User createUser(User user) {
        return userService.create(user);
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public User updateUser(@PathParam("id") Long id, User user) {
        return userService.update(id, user);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") long id) {
        userService.delete(id);
    }


}
