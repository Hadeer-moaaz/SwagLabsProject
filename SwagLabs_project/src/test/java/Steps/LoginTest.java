package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By login_button = By.id("login-button");
    By headerArea = By.className("header_secondary_container");
    By error_button = By.className("error-button");

    //data
    String Valid_username = "standard_user";
    String Valid_password = "secret_sauce";
    String inValid_username = "Sara";
    String inValid_password = "12345";


    @Test(priority = 1)
    public void Valid_login (){

        driver.findElement(usernameField).sendKeys(Valid_username);
        driver.findElement(passwordField).sendKeys(Valid_password);
        driver.findElement(login_button).click();

        boolean isHeaderDisplayed = driver.findElement(headerArea).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed);


    }
    @Test(priority = 2)
    public void inValid_login ()  {
        driver.findElement(usernameField).sendKeys(inValid_username);
        driver.findElement(passwordField).sendKeys(inValid_password);
        driver.findElement(login_button).click();
        boolean isHeaderDisplayed = driver.findElement(error_button).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed);
    }


}
