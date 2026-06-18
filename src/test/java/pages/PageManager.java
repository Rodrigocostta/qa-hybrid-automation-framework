package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {

    private final WebDriver driver;

    public PageManager(
            WebDriver driver) {

        this.driver = driver;
    }

    public HomePage homePage() {

        return new HomePage(driver);
    }

    public ProductPage productPage() {

        return new ProductPage(driver);
    }

    public CartPage cartPage() {

        return new CartPage(driver);
    }

    public CheckoutPage checkoutPage() {

        return new CheckoutPage(driver);
    }

    public LoginPage loginPage() {

        return new LoginPage(driver);
    }
}