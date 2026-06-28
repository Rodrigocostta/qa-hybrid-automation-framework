package pages;

import org.openqa.selenium.WebDriver;

/**
 * Responsável por fornecer instâncias
 * dos Page Objects.
 */
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