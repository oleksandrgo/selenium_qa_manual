package stepDefinitionBDD;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.User;
import pageObjects.main.Main;
import pageObjects.profile.UserGarage;

public class LoginPageStepDef {
    private WebDriver driver;
    private Main main;
    private UserGarage userGarage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        main = new Main(driver);
        userGarage = new UserGarage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("open main page")
    public void openMainPage() {
        main.openUrl("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @When("click button Sign up")
    public void clickButtonSighUp() {
        main.clickOnButtonSignUp();
    }


    @And("fill field name with {string}")
    public void fillFieldNameWith(String name) throws InterruptedException {
        main.setFieldName(name);
        Thread.sleep(3000);
    }

    @When("fill field last name with {string}")
    public void fillFieldLastName(String lastName) {
        main.setFieldLastName(lastName);
    }

    @When("set unique email")
    public void fillFieldEmail() {
        main.setFieldEmail(new User().getRandomEmail());
    }

    @When("fill field password with {string}")
    public void fillFieldPassword(String password) {
        main.setFieldPassword(password);
    }

    @When("fill field re enter password with {string}")
    public void fillFieldReEnterPassword(String reEnterPassword) {
        main.setFieldReenterPassword(reEnterPassword);
    }

    @When("click register button")
    public void clickRegisterButton() {
        main.clickRegisterButton();
    }


    @Then("redirect to profile page")
    public void redirectToProfilePage() throws InterruptedException {
        Assert.assertTrue(userGarage.addCarButton.isDisplayed(), "Button is not present");
    }

    @Then("error message {string} displayed")
    public void errorMessageDisplayed(String error) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(main.getFirstNameError(),error);
    }

    @And("change focus to last name field")
    public void changeFocusToLastNameField() {
        main.fieldLastName.click();
    }
}
