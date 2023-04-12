package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.User;
import pageObjects.main.Main;
import pageObjects.profile.FuelExpenses;
import pageObjects.profile.Profile;
import pageObjects.profile.Settings;
import pageObjects.profile.UserGarage;

import java.util.concurrent.TimeUnit;

public class Setup {
    protected WebDriver driver;
    protected Main main;
    protected FuelExpenses fuelExpenses;
    protected UserGarage userGarage;
    protected Profile profile;
    protected User user;
    protected AllureListener allureListener;
    protected Settings settings;

    @BeforeMethod
    public void setupTests() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        main = new Main(driver);
        profile = new Profile(driver);
        allureListener = new AllureListener(driver);
        user = new User();
        fuelExpenses = new FuelExpenses(driver);
        userGarage = new UserGarage(driver);
        settings = new Settings(driver);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
