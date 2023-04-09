import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {
    @Test
    public void createUser() {
        RestAssured.baseURI = "https://qauto.forstudy.space/api/";

        given().log().all().header("content-type", "application/json")
                .body("{\n" +
                        "  \"name\": \"John\",\n" +
                        "  \"lastName\": \"Dou\",\n" +
                        "  \"email\": \" " + randomEmail() + "\",\n" +
                        "  \"password\": \"Qwerty12345\",\n" +
                        "  \"repeatPassword\": \"Qwerty12345\"\n" +
                        "}").
                when().post("auth/signup").
                then().log().all().assertThat().statusCode(201);
    }

    private static String randomEmail() {
        return "test" + (int) ((Math.random() * 10000)) + "@gmail.com";
    }
}
