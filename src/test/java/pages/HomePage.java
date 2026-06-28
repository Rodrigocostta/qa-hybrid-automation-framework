package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By botaoLogin = By.id("login2");
    private final By modalLogin = By.id("logInModal");
    private final By menuCarrinho = By.id("cartur");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String obterTituloPagina() {
        return driver.getTitle();
    }

    public void clicarLogin() {
        click(botaoLogin);
    }

    public boolean modalLoginEstaVisivel() {
        return isDisplayed(modalLogin);
    }

    public void clicarProduto(
            String produto) {

        click(By.linkText(produto));
    }

    public void clicarCarrinho() {
        click(menuCarrinho);
    }

}
