package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    WebDriver driver;
    @BeforeSuite
    public void openBrowser() {

       driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeBrowser (){

        driver.quit();
    }

}
