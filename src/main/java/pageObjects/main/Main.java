package pageObjects.main;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(css = ".hero-descriptor_btn")
    WebElement buttonSignUp;

    @FindBy(css = "#signupName")
    WebElement fieldName;

    @FindBy(css = "#signupLastName")
    WebElement fieldLastName;

    @FindBy(css = "#signupEmail")
    WebElement fieldEmail;

    @FindBy(css = "#signupPassword")
    WebElement fieldPassword;

    @FindBy(css = "#signupRepeatPassword")
    WebElement fieldReenterPassword;

    @FindBy(css = ".modal-footer .btn")
    WebElement buttonRegister;

    public Main(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on button sign up")
    public void clickOnButtonSignUp() {
        buttonSignUp.click();
    }

    @Step("Set data {name} to field name")
    public void setFieldName(String name) {
        fieldName.sendKeys(name);
    }

    public void setFieldLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
    }

    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void setFieldReenterPassword(String reenterPassword) {
        fieldReenterPassword.sendKeys(reenterPassword);
    }

    public void clickRegisterButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonRegister)).click();
    }

    @Step("Open page: {url}")
    public void openUrl(String url) {
        driver.get(url);
    }


}
