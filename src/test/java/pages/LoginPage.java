package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage extends BasePage {

    /* mapa de elementos */
    private final By usernameField = By.id("loginusername");

    private final By passwordField = By.id("loginpassword");

    private final By loginButton = By.xpath("//button[text()='Log in']");

    private final By welcomeUser = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String obterUsuarioLogado() {

        WaitUtils.esperarTexto(
                driver,
                welcomeUser,
                "Welcome");
        return getText(welcomeUser);
    }
}