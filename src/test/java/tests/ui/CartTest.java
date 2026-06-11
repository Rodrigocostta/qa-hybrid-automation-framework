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
        public void deveAdicionarProdutoAoCarrinhoComSucesso() {

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                homePage.clicarProdutoSamsung();

                Assert.assertEquals(
                                "Samsung galaxy s6",
                                productPage.obterNomeProduto());

                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                Assert.assertEquals(
                                "Product added",
                                alerta.getText());

                alerta.accept();

                homePage.clicarCarrinho();

                capturarEvidencia("produto_no_carrinho");

                Assert.assertTrue(
                                "Produto deveria estar no carrinho",
                                cartPage.produtoEstaNoCarrinho());
        }

        @Test
        public void deveRemoverProdutoDoCarrinho() throws InterruptedException {

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                homePage.clicarProdutoSamsung();

                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                homePage.clicarCarrinho();

                Assert.assertTrue(
                                cartPage.produtoExisteNoCarrinho());

                cartPage.removerProduto();
                Thread.sleep(3000);

                capturarEvidencia("produto_removido");

                Assert.assertFalse(
                                "Produto deveria ter sido removido",
                                cartPage.produtoExisteNoCarrinho());

        }

}
