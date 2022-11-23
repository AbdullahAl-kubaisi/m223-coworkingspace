package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class BookingRessoruceTest {

    String jwtAdmin = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6ImFuZEBiYXQuY29tIiwiZ3JvdXBzIjpbImFkbWluIl0sImlhdCI6MTY2NDM3NDE1NywiZXhwIjozODExODU3ODA0LCJqdGkiOiIwMWIwYmFmYy1mZDdkLTQ2M2MtYWQ4Mi03YWI2ZTlkYjk4NGQifQ.lhaZSXCjtUjs5T56DjheIUzltH7zEj0FfvEETUmYMlfsci-mSR61K0MBzwBxzMYMneo2V72PJ6r5_UL7LAQkcweKoE3ixaTLo93TnerdtH6jgFeOQYTDBDJPCzUNEvQecC8eOdVMYQBZwOzz5t5wtzu9TKgfVXTRP1vFE10N7DXe8XIWNL6yRCaHziLmGtqYvNCOjput87upFjgFG_GZjMmtJCTC1f9cT62ki7tAiPIzAR48I-8jetKm86AlSKdoB0a8n9WaKY_9FUHUVfrlbKF8sKfMpJiXZka7C1C0o887YrdLUgwz7Vb8kv1J6X4YEbs0u5ec1qd7cQS8ehslsA";
    String mitgliedJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InRlc3RAdGVzdC5jb20iLCJncm91cHMiOlsibWl0Z2xpZWQiXSwiaWF0IjoxNjY0Mzc0MTA4LCJleHAiOjM4MTE4NTc3NTUsImp0aSI6IjRmYzk5OGYwLTk5M2QtNGZjZS04OGIyLTEyYzE3MjAyNzMxMiJ9.GUmgmUVv6Froj4jCd_YF60riNFC_rjKZELz-87NmazlaahyXVWeDmAO4o6xgU4OokL7S4-1CENLNVHIvjm8YEaXbgydiqwQGhn44i5o6KxFEz_veCzV72EudBvMnHzJ9-rbxqqy7I87moVhOESiEukf8CgOT5XH_TztcXbjuyP2ilinOknXahv6i1lbCbzhK2R3d39ou7qDTIuzv720KSJtkhi3nFBpeM5lllaO0jvuRQebmfmblGSzvGajEwXEOAV_0xO9uYx1krem2YqPUNL1-pW3Q6YavBRNGo9YTwwJq6fs9uf_XbUm6pneLdwmgTYqOQ3Xkoss6WbdEAtN-vg";
    
    @Test
    public void testGetAllBookings() {
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsAdmin() {
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsMitglied() {
        given()
            .auth().oauth2(mitgliedJwt)
            .when().get("/booking")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsAdminWithWrongRole() {
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking")
            .then()
                .statusCode(401);
    }


    @Test
    public void testGetBookingById(){
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking/1")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdAsAdmin(){
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking/1")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdAsMitglied(){
        given()
            .auth().oauth2(mitgliedJwt)
            .when().get("/booking/1")
            .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdInvalid(){
        given()
            .auth().oauth2(jwtAdmin)
            .when().get("/booking/999")
            .then()
                .statusCode(401);
    }

    @Test
    public void testDeleteBookingById(){
        given()
            .auth().oauth2(jwtAdmin)
            .when().delete("/booking/1")
            .then()
                .statusCode(401);
    }

    @Test
    public void delete() {
        given()
        .header("Authorization", "B" + mitgliedJwt)
        .when().delete("/booking/1")
        .then()
            .assertThat()
            .statusCode(401);
    }


    
    @Test
    public void testDeleteBookingInvalid(){
        given()
            .auth().oauth2(jwtAdmin)
            .when().delete("/booking/999")
            .then()
                .statusCode(401);
    }

    @Test
    public void testUpdateBooking(){
        given()
            .auth().oauth2(jwtAdmin)
            .contentType(ContentType.JSON)
            .body("{\"id\": 1, \"name\": \"Test\", \"description\": \"Test\", \"start\": \"2021-06-01T00:00:00.000+00:00\", \"end\": \"2021-06-01T00:00:00.000+00:00\", \"room\": {\"id\": 1, \"name\": \"Test\", \"description\": \"Test\", \"capacity\": 1}}")
            .when().put("/booking/1")
            .then()
                .statusCode(200);
    }

    @Test
    public void testUpdateBookingInvalid(){
        given()
            .auth().oauth2(jwtAdmin)
            .contentType(ContentType.JSON)
            .body("{\"id\": 999, \"name\": \"Test\", \"description\": \"Test\", \"start\": \"2021-06-01T00:00:00.000+00:00\", \"end\": \"2021-06-01T00:00:00.000+00:00\", \"room\": {\"id\": 1, \"name\": \"Test\", \"description\": \"Test\", \"capacity\": 1}}")
            .when().put("/booking/999")
            .then()
                .statusCode(401);
    }

}


