package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utils.WaitUtils;
import model.CheckoutData;
import utils.JsonUtils;

public class CheckoutTest extends BaseTest {

        @Test
        public void deveFinalizarCompraComSucesso() {
                logInfo("CT006 - Finalizar Compra com Sucesso");

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                logInfo("Selecionando produto Samsung");
                homePage.clicarProdutoSamsung();

                logInfo("Adicionando produto ao carrinho");
                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                homePage.clicarCarrinho();

                cartPage.clicarPlaceOrder();

                CheckoutPage checkoutPage = new CheckoutPage(driver);

                Assert.assertTrue(
                                "Modal de compra deveria estar visível",
                                checkoutPage.modalEstaVisivel());

                logInfo("Preenchendo dados da compra");
                CheckoutData dados = JsonUtils.carregarCheckoutData();

                checkoutPage.preencherFormularioCompra(
                                dados.getNome(),
                                dados.getPais(),
                                dados.getCidade(),
                                dados.getCartao(),
                                dados.getMes(),
                                dados.getAno());

                checkoutPage.clicarPurchase();

                String mensagemSucesso = checkoutPage.obterMensagemSucesso();
                Assert.assertEquals(
                                "Mensagem de compra diferente do esperado",
                                "Thank you for your purchase!",
                                mensagemSucesso);

                logPass("Compra finalizada com sucesso");
                capturarEvidencia("compra_realizada");

                checkoutPage.clicarOk();

        }

}
