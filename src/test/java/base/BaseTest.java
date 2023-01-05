package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void loginWeb() {
        driver.get("https://www.ikea.com/us/en");
    } //enter url

    @BeforeClass
    protected void before() {
        WebDriverManager.chromedriver().setup();//get driver, path to driver
    }

    @BeforeMethod
    protected void beforeTest() {
        driver = new ChromeDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginWeb();
        getDriver().manage().window().maximize();
    }

//    @AfterMethod
//    protected void afterTest() {
//        getDriver().quit(); //why not close()?
//    }
}
