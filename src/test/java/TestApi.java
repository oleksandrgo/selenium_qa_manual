import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://qauto.forstudy.space/api/";
    }

    @Test(description = "Create user")
    public void createUserWithValidData() {
        createUser();
    }

    @Test(description = "login to user profile")
    public void loginToAccount() {
        String email = createUser();
        logIn(email);
    }


    private String createUser() {
        String randomEmail = randomEmail();
        given().log().all().header("content-type", "application/json")
                .body("{\n" +
                        "  \"name\": \"John\",\n" +
                        "  \"lastName\": \"Dou\",\n" +
                        "  \"email\": \" " + randomEmail + "\",\n" +
                        "  \"password\": \"Qwerty12345\",\n" +
                        "  \"repeatPassword\": \"Qwerty12345\"\n" +
                        "}").
                when().post("auth/signup").
                then().log().all().assertThat().statusCode(201);
        return randomEmail;
    }


    private void logIn(String email) {
        given().log().all().header("content-type", "application/json")
                .body("{\n" +
                        "  \"email\": \" " + email + "\",\n" +
                        "  \"password\": \"Qwerty12345\",\n" +
                        "  \"remember\": false\n" +
                        "}").
                when().post("auth/signin").
                then().log().all().assertThat().statusCode(200);
    }

    private static String randomEmail() {
        return "test" + (int) ((Math.random() * 10000)) + "@gmail.com";
    }
}
