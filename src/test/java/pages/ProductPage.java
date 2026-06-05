package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By nomeProduto = By.cssSelector(".name");

    private final By botaoAddToCart = By.linkText("Add to cart");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String obterNomeProduto() {
        return getText(nomeProduto);
    }

    public void adicionarAoCarrinho() {
        click(botaoAddToCart);
    }
}