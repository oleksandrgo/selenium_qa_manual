package setup;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.User;
import pageObjects.main.Main;
import pageObjects.profile.FuelExpenses;
import pageObjects.profile.Profile;
import pageObjects.profile.UserGarage;

import java.util.concurrent.TimeUnit;

public class Setup {
    protected WebDriver driver;
    protected Main main;    
    protected FuelExpenses fuelExpenses;
    protected UserGarage userGarage;
    protected Profile profile;
    protected User user;

    @BeforeClass
    public static void setupDriver(){
        final String path = String.format("%s/bin/chromedriver.exe", System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", path);
    }

    @Before
    public void setupTests(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        main = new Main(driver);
        profile = new Profile(driver);
        user = new User();
        fuelExpenses = new FuelExpenses(driver);
        userGarage = new UserGarage(driver);
    }

    @After
    public void after(){
        driver.quit();
    }
}
