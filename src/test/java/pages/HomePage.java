package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private WebDriver driver;

    private final By botaoLogin = By.id("login2");
    private final By modalLogin = By.id("logInModal");
    private final By produtoSamsung = By.linkText("Samsung galaxy s6");
    private final By menuCarrinho = By.id("cartur");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /* BOtão de login */
    public void clicarLogin() {
        click(botaoLogin);
    }

    /* Vizualizar modal */
    public boolean modalLoginEstaVisivel() {
        return isDisplayed(modalLogin);
    }

    /* Produto Samsung */
    public void clicarProdutoSamsung() {
        click(produtoSamsung);
    }

    public void clicarCarrinho() {
        click(menuCarrinho);
    }

}
