package pageObjects.profile;

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
    WebElement garageTab;

    @FindBy(css = ".btn-primary")
    WebElement addCarButton;

    @FindBy(css = "#addCarMileage")
    WebElement fieldMileage;

    @FindBy(css = ".modal-footer>.btn-primary")
    WebElement buttonAdd;

    public UserGarage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnTabGarage(){
        garageTab.click();
    }

    public void clickAddCarButton(){
        addCarButton.click();
    }

    public void setMileage(String mileage){
        fieldMileage.sendKeys(mileage);
    }

    public void clickButtonAdd(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd)).click();
    }



}
