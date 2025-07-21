package ebay.sniper.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EbaySniperControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/ebay-sniper/hello")
          .then()
             .statusCode(200)
             .body(is("Hello World, ebay sniper"));
    }

}