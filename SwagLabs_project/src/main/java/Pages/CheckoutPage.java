package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }


    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.xpath("//input[@class=\"btn_primary cart_button\"]");
    private By finishButton = By.xpath("//a[@class=\"btn_action cart_button\"]");
    private By confirmationSMS = By.xpath("//h2[@class=\"complete-header\"]");


    public void fullYourInformation(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
        driver.findElement(finishButton).click();

    }

    public By expectedResult(){
        return confirmationSMS;
    }

}
