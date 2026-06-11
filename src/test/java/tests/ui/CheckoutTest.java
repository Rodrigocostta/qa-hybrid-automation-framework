package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.TestData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest {

        @Test
        public void deveFinalizarCompraComSucesso() {

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                homePage.clicarProdutoSamsung();

                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                homePage.clicarCarrinho();

                cartPage.clicarPlaceOrder();

                CheckoutPage checkoutPage = new CheckoutPage(driver);

                Assert.assertTrue(
                                "Modal de compra deveria estar visível",
                                checkoutPage.modalEstaVisivel());

                checkoutPage.preencherFormularioCompra(
                                TestData.NOME,
                                TestData.PAIS,
                                TestData.CIDADE,
                                TestData.CARTAO,
                                TestData.MES,
                                TestData.ANO);

                checkoutPage.clicarPurchase();

                String mensagemSucesso = checkoutPage.obterMensagemSucesso();

                Assert.assertEquals(
                                "Thank you for your purchase!", mensagemSucesso);

                capturarEvidencia(
                                "compra_realizada");

                checkoutPage.clicarOk();

        }

}
