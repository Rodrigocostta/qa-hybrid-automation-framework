package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import data.model.CheckoutData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest {

        @Test
        public void deveFinalizarCompraComSucesso() {
                LoggerUtils.info(test, "CT006 - Finalizar Compra com Sucesso");

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                LoggerUtils.info(test, "Selecionando produto Samsung");

                CartData dadosProduto = JsonUtils.carregarCartData();

                LoggerUtils.info(test, "Selecionando produto: " + dadosProduto.getProduto());
                homePage.clicarProduto(dadosProduto.getProduto());

                LoggerUtils.info(test, "Adicionando produto ao carrinho");
                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                homePage.clicarCarrinho();

                Assert.assertTrue("Produto não encontrado no carrinho",

                                cartPage.produtoExisteNoCarrinho(dadosProduto.getProduto()));

                cartPage.clicarPlaceOrder();

                CheckoutPage checkoutPage = new CheckoutPage(driver);

                Assert.assertTrue(
                                "Modal de compra deveria estar visível",
                                checkoutPage.modalEstaVisivel());

                LoggerUtils.info(test, "Preenchendo dados da compra");
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

                LoggerUtils.sucesso(test, "Compra finalizada com sucesso");
                capturarEvidencia("compra_realizada");

                checkoutPage.clicarOk();

        }

}
