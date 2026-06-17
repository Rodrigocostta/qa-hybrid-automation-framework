package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.WaitUtils;

public class CartTest extends BaseTest {

        @Test
        public void deveRemoverProdutoDoCarrinho() throws InterruptedException {
                logInfo("CT005 - Remover Produto do Carrinho");

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                logInfo("Selecionando produto Samsung");
                homePage.clicarProdutoSamsung();

                logInfo("Adicionando produto ao carrinho");
                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                logInfo("Acessando carrinho");
                homePage.clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",
                                cartPage.produtoExisteNoCarrinho());

                logInfo("Removendo produto do carrinho");
                cartPage.removerProduto();
                cartPage.aguardarRemocaoProduto();

                logPass("Produto removido do carrinho com sucesso");
                capturarEvidencia("produto_removido");

                Assert.assertFalse(
                                "Produto deveria ter sido removido",
                                cartPage.produtoExisteNoCarrinho());

        }

}
