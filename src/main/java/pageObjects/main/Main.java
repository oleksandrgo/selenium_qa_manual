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
    public WebElement buttonSignUp;

    @FindBy(css = "#signupName")
    public WebElement fieldName;

    @FindBy(css = "#signupLastName")
    public WebElement fieldLastName;

    @FindBy(css = "#signupEmail")
    public WebElement fieldEmail;

    @FindBy(css = "#signupPassword")
    public WebElement fieldPassword;

    @FindBy(css = "#signupRepeatPassword")
    public WebElement fieldReenterPassword;

    @FindBy(css = ".modal-footer .btn")
    public WebElement buttonRegister;

    @FindBy(css = ".invalid-feedback p")
    public WebElement firstNameError;

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

    @Step("Set data {lastName} to the field last name")
    public void setFieldLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
    }

    @Step("Set data {email} to the field email")
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    @Step("Set data {password} to the field password")
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    @Step("Set data {reenterPassword} to the field reenterPassword")
    public void setFieldReenterPassword(String reenterPassword) {
        fieldReenterPassword.sendKeys(reenterPassword);
    }

    @Step("Click button register")
    public void clickRegisterButton() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonRegister)).click();
    }

    @Step("Open page: {url}")
    public void openUrl(String url) {
        driver.get(url);
    }

    @Step("Get firstName error message")
    public String getFirstNameError(){
        return  firstNameError.getText();
    }


}
