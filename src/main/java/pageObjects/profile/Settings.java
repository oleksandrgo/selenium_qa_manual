package pageObjects.profile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".sidebar_btn-group .sidebar_btn:nth-child(2)")
    public WebElement settingTab;

    @FindBy(css = ".btn-danger-bg")
    public WebElement removeMyAccountButton;

    @FindBy(css = ".justify-content-end .btn-danger")
    public WebElement removeButton;

    public Settings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click setting tab")
    public void clickSettingTab() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(settingTab)).click();
    }

    @Step("Click remove account tab")
    public void clickRemoveAccountButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(removeMyAccountButton)).click();
    }

    @Step("Click remove button")
    public void clickRemoveButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }


}
