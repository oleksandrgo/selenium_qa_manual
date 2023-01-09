package pageObjects.profile;

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

    public void clickOnProfileButton(){
        profileButton.click();
    }

    public String getFirstLastName(){
        return profileName.getText();
    }
}
