package ch.zli.m223.controller;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthentifctaionService;
import ch.zli.m223.service.UserService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * ZLI - M 223
 * @author Al-Kubaisi Abdullah
 * @version 23.11.2022
 * Controller to implement the endpoints
 */


@Path("/auth")
@Tag(name = "Authentifizierung", description = "Authentifizierung")
public class AuthentifctaionController {
    
        @Inject
        AuthentifctaionService authentifctaionService;
    
        @Inject
        UserService userService;

        @Inject
        JsonWebToken jwt; 
    
        @POST
        @Path("/login")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "prueft the data.")
        public String login(@QueryParam("email")String email, @QueryParam("password") String password) {
            return authentifctaionService.login(email, password);
        }
    
        @POST
        @Path("/register")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "create", description = "registriert eine neue User")
        public User register(User user) {
            return userService.create(user);
        }
    
        @POST
        @Path("/logout")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "log user out")
        public Response logout(String token) {
            return Response.ok(authentifctaionService.logout(token)).build();
        }

}
