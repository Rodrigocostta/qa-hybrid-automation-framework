package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private final By botaoLogin = By.id("login2");
    private final By modalLogin = By.id("logInModal");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /* BOtão de login */
    public void clicarLogin() {
        driver.findElement(botaoLogin).click();
    }

    /* Vizualizar modal */
    public boolean modalLoginEstaVisivel() {
        return driver.findElement(modalLogin).isDisplayed();
    }

}
