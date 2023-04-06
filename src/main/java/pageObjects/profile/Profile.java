package pageObjects.profile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
    WebDriver driver;
    @FindBy(css = ".sidebar_btn-group .sidebar_btn")
    WebElement profileButton;

    @FindBy(css = ".profile_name")
    WebElement profileName;

    public Profile(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click on profile button")
    public void clickOnProfileButton(){
        profileButton.click();
    }

    @Step("Get user data")
    public String getFirstLastName(){
        return profileName.getText();
    }
}
