package pageObjects.profile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserGarage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(css = ".sidebar>.sidebar_btn:nth-child(1)")
    public WebElement garageTab;

    @FindBy(css = ".btn-primary")
    public WebElement addCarButton;

    @FindBy(css = "#addCarMileage")
    public WebElement fieldMileage;

    @FindBy(css = ".modal-footer>.btn-primary")
    public WebElement buttonAdd;

    public UserGarage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click on tab garage")
    public void clickOnTabGarage(){
        garageTab.click();
    }

    @Step("Click add car button")
    public void clickAddCarButton(){
        addCarButton.click();
    }

    @Step("Set mileage")
    public void setMileage(String mileage){
        fieldMileage.sendKeys(mileage);
    }

    @Step("Click button add")
    public void clickButtonAdd(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd)).click();
    }



}
