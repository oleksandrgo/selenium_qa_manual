
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;


public class TestsUi extends Setup {


    @Test(priority = 1, description = "End2end test")
    @Severity(SeverityLevel.BLOCKER)
    public void end2end() throws InterruptedException {
        main.openUrl("https://guest:welcome2qauto@qauto.forstudy.space/");
        main.clickOnButtonSignUp();
        main.setFieldName(user.getFirstName());
        main.setFieldLastName(user.getLastName());
        main.setFieldEmail(user.getRandomEmail());
        main.setFieldPassword(user.getPassword());
        main.setFieldReenterPassword(user.getPassword());
        main.clickRegisterButton();
        profile.clickOnProfileButton();
        Assert.assertEquals(profile.getFirstLastName(),user.getFirstName()+ " " + user.getLastName(), "User data are not equals");
        userGarage.clickOnTabGarage();
        userGarage.clickAddCarButton();
        userGarage.setMileage(user.getMileage());
        userGarage.clickButtonAdd();
        fuelExpenses.clickFuelExpensesTab();
        fuelExpenses.clickButtonAdd();
        fuelExpenses.setFieldMileage(user.getMileage()+1);
        fuelExpenses.setFieldNumberOfLiters("5");
        fuelExpenses.setFieldTotalCoast("100");
        fuelExpenses.clickAdAnExpenseButton();
    }

    @Test (priority = 2,description = "Check create user functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void createUser() throws InterruptedException {
        main.openUrl("https://guest:welcome2qauto@qauto.forstudy.space/");
        main.clickOnButtonSignUp();
        main.setFieldName(user.getFirstName());
        main.setFieldLastName(user.getLastName());
        main.setFieldEmail(user.getRandomEmail());
        main.setFieldPassword(user.getPassword());
        main.setFieldReenterPassword(user.getPassword());
        main.clickRegisterButton();
        Thread.sleep(2000);
        Assert.assertEquals(userGarage.addCarButton.getText(),"Add car", "Button is absent");
    }

}
