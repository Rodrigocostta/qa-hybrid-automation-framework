package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    /* mapa de elementos */
    private final By usernameField = By.id("loginusername");

    private final By passwordField = By.id("loginpassword");

    private final By loginButton = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton)
                .click();
    }

}