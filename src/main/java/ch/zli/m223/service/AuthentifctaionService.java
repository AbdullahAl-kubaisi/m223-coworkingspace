package ch.zli.m223.service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;


import ch.zli.m223.model.User;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;



@ApplicationScoped
public class AuthentifctaionService {

    @Inject
    UserService userService;


    @Transactional
    public Response login(String email, String password) {
        List<User> users = userService.listAll();
        for (User user : users) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            String token = createToken(user);
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
        throw new IllegalArgumentException("UNAUTHORIZED");

}

    private String createToken(User user) {
        JwtClaimsBuilder claims = Jwt.claims();
        claims.groups(new HashSet<>(Arrays.asList(user.getRole().getRole())));
        claims.claim("id", user.getId());
        claims.claim("email", user.getEmail());
        claims.claim("firstname", user.getFirstname());
        claims.claim("lastname", user.getLastname());
        claims.claim("role", user.getRole().getRole());
        return claims.sign();
    }


    public Response logout(String token) {
        return Response.ok(token).build();
    }
}
