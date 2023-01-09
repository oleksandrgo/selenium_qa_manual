import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

public class Tests extends Setup {


    @Test
    public void homeWork() throws InterruptedException {
        main.openUrl("https://guest:welcome2qauto@qauto.forstudy.space/");
        main.clickOnButtonSignUp();
        main.setFieldName(user.getFirstName());
        main.setFieldLastName(user.getLastName());
        main.setFieldEmail(user.getRandomEmail());
        main.setFieldPassword(user.getPassword());
        main.setFieldReenterPassword(user.getPassword());
        main.clickRegisterButton();
        profile.clickOnProfileButton();
        Assert.assertEquals ("Wrong first and last name",
                profile.getFirstLastName(),
                user.getFirstName()+ " " + user.getLastName());
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
}
