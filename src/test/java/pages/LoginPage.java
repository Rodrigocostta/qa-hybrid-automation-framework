package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    /* mapa de elementos */
    private final By usernameField = By.id("loginusername");

    private final By passwordField = By.id("loginpassword");

    private final By loginButton = By.xpath("//button[text()='Log in']");

    private final By welcomeUser = By.id("nameofuser");

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

    public String obterUsuarioLogado() {

    WaitUtils.esperarTexto(
            driver,
            welcomeUser,
            "Welcome");

    return driver.findElement(welcomeUser)
                 .getText();
}
}