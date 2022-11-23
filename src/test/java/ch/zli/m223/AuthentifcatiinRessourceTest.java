package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class AuthentifcatiinRessourceTest {
    


    @Test
    public void testPostLogin() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("http://localhost:8080/login?email=and%40bat.com&password=and")
            .then()
            .statusCode(404);
    }


    @Test
    public void testPostRegisterInvalid() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("http://localhost:8080/register?email=and%40bat.com&password=and")
            .then()
            .statusCode(404);
    }

    @Test
    public void testPostRegisterValid() {
        given()
        .body("{\"firstname\":\"abdu\",\"lastname\":\"ahmed\", \"age\":\"11\",\"description\":\"ahmed\", \"email\":\"abdullahde197@gmail.com\", \"password\":\"AK19997\"}")

        .contentType(ContentType.JSON)
        .when()
            .post("http://localhost:8080/auth/register")
            .then()
            .statusCode(200);
    }
    @Test
    public void testGetLogout() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .get("http://localhost:8080/logout")
            .then()
            .statusCode(404);
    }



}