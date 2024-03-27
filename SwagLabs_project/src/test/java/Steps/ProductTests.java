package Steps;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartpage;
    CheckoutPage checkoutPage;

    String expectedPrice = "$15.99";
    String expectedResult = "THANK YOU FOR YOUR ORDER";


    @Test(priority = 1)
    public void validateProductPrice() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartpage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        homePage.openProduct();
        String actualValue = driver.findElement(productPage.getProdcutPrice()).getText();
        Assert.assertEquals(actualValue, expectedPrice);
    }

    @Test(priority = 2, dependsOnMethods = "validateProductPrice")
    public void addProductToCart() {


        productPage.addToCart();
        productPage.moveToCartPage();
        boolean isElementDisplayed = driver.findElement(cartpage.getProductName()).isDisplayed();
        Assert.assertTrue(isElementDisplayed);
        cartpage.checkOut();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fullYourInformation("Hadeer", "Ahmed", "12546");

        String actualValue2 = driver.findElement(checkoutPage.expectedResult()).getText();
        Assert.assertEquals(actualValue2, expectedResult);


    }
}