import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://qauto.forstudy.space/api/";
    }

    @Test
    public void createUserWithValidData() {
        createUser();
    }

    @Test
    public void loginToAccount() {
        String email = createUser();
        logIn(email);
    }

    @Step
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

    @Step
    private void logIn(String email){
        given().log().all().header("content-type", "application/json")
                .body("{\n" +
                        "  \"email\": \" " + email + "\",\n" +
                        "  \"password\": \"Qwerty12345\",\n" +
                        "  \"remember\": false\n" +
                        "}").
                when().post("auth/signin").
                then().log().all().assertThat().statusCode(201);
    }

    private static String randomEmail() {
        return "test" + (int) ((Math.random() * 10000)) + "@gmail.com";
    }
}
