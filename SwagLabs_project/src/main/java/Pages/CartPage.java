package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By productName = By.xpath("//div[@class=\"inventory_item_name\"]");

    private By checkOutButton = By.xpath("//a[text()='CHECKOUT']");


    public By getProductName(){
        return productName;
    }

    public void checkOut(){
        driver.findElement(checkOutButton).click();
    }
}