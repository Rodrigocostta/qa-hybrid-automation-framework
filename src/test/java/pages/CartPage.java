package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CartPage extends BasePage {

    private final By produtoSamsung = By.xpath("//tr[contains(.,'Samsung galaxy s6')]");
    private final By botaoDelete = By.linkText("Delete");
    private final By botaoPlaceOrder = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean produtoEstaNoCarrinho() {
        return isDisplayed(produtoSamsung);
    }

    public void removerProduto() {
        click(botaoDelete);
    }

    public void aguardarRemocaoProduto() {

        WaitUtils.esperarProdutoRemovido(
                driver,
                produtoSamsung);
    }

    public boolean produtoExisteNoCarrinho() {

        return driver.findElements(
                By.xpath("//tr[contains(.,'Samsung galaxy s6')]"))
                .size() > 0;
    }

    public void clicarPlaceOrder() {
        click(botaoPlaceOrder);
    }
}
