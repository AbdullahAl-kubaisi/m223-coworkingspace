package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class CanteenRessourceTest {
    
    @Test
    public void testfindById() {
        given()
          .when().get("/products/1")
          .then()
             .statusCode(204);
    }

    @Test
    public void testFindByIdInvalid() {
        given()
          .when().get("/products/999")
          .then()
             .statusCode(204);
    }
}
