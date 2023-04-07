package pageObjects.profile;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuelExpenses {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".sidebar>.sidebar_btn:nth-child(2)")
    WebElement fuelExpensesTab;

    @FindBy(css = ".modal-footer>.btn-primary")
    WebElement addAnExpenseButton;

    @FindBy(css = "#addExpenseMileage")
    WebElement fieldMileage;

    @FindBy(css = "#addExpenseLiters")
    WebElement fieldNumberOfLiters;

    @FindBy(css = "#addExpenseTotalCost")
    WebElement fieldTotalCoast;

    @FindBy(css = ".item-group>.btn-primary")
    WebElement buttonAddExpense;

    public FuelExpenses(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click add expense button")
    public void clickAdAnExpenseButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                elementToBeClickable(addAnExpenseButton)).click();
    }

    @Step("Click fuel expenses tab")
    public void clickFuelExpensesTab(){
        fuelExpensesTab.click();
    }

    @Step("Set field mileage")
    public void setFieldMileage(String mileage){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.
                visibilityOf(fieldMileage)).sendKeys(mileage);
    }

    @Step("Set number liters")
    public void setFieldNumberOfLiters(String liters){
        fieldNumberOfLiters.sendKeys(liters);
    }

    public void setFieldTotalCoast(String coast){
        fieldTotalCoast.sendKeys(coast);
    }

    @Step("Click button add")
    public void clickButtonAdd(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(buttonAddExpense)).click();

    }


}
