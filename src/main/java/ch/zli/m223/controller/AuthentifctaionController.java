
package ch.zli.m223.controller;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthentifctaionService;
import ch.zli.m223.service.UserService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        public String login(@QueryParam("email")String email, @QueryParam("password") String password) {
            return authentifctaionService.login(email, password);
        }
    
        @POST
        @Path("/register")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public User register(User user) {
            return userService.create(user);
        }
    
        @POST
        @Path("/logout")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response logout(String token) {
            return Response.ok(authentifctaionService.logout(token)).build();
        }

}
