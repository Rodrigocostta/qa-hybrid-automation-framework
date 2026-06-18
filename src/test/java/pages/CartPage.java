package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CartPage extends BasePage {

    private final By botaoDelete = By.linkText("Delete");
    private final By botaoPlaceOrder = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {

        super(driver);
    }

    public boolean produtoExisteNoCarrinho(
            String produto) {

        try {

            By produtoCarrinho = By.xpath(
                    "//tr[contains(.,'" + produto + "')]");

            WaitUtils.esperarElementoVisivel(
                    driver,
                    produtoCarrinho);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public void removerProduto() {

        click(botaoDelete);
    }

    public void aguardarRemocaoProduto(
            String produto) {

        By produtoCarrinho = By.xpath(
                "//tr[contains(.,'" + produto + "')]");

        WaitUtils.esperarProdutoRemovido(
                driver,
                produtoCarrinho);
    }

    public void clicarPlaceOrder() {

        click(botaoPlaceOrder);
    }
}