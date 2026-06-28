package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import data.model.CheckoutData;
import pages.CheckoutPage;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest {

        @Test
        public void deveFinalizarCompraComSucesso() {
                LoggerUtils.info(test,
                                "CT006 - Finalizar Compra com Sucesso");

                LoggerUtils.info(test,
                                "Selecionando produto Samsung");

                CartData dadosProduto = JsonUtils.carregarCartData();

                LoggerUtils.info(test,
                                "Selecionando produto: " + dadosProduto.getProduto());
                pages.homePage().clicarProduto(dadosProduto.getProduto());

                LoggerUtils.info(test,
                                "Adicionando produto ao carrinho");
                pages.productPage().adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);
                alerta.accept();

                pages.homePage().clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",

                                pages.cartPage().produtoExisteNoCarrinho(dadosProduto.getProduto()));

                pages.cartPage().clicarPlaceOrder();

                CheckoutPage checkoutPage = new CheckoutPage(driver);

                Assert.assertTrue(
                                "Modal de compra deveria estar visível",
                                checkoutPage.modalEstaVisivel());

                LoggerUtils.info(test,
                                "Preenchendo dados da compra");

                CheckoutData dados = JsonUtils.carregarCheckoutData();

                pages.checkoutPage().preencherFormularioCompra(
                                dados.getNome(),
                                dados.getPais(),
                                dados.getCidade(),
                                dados.getCartao(),
                                dados.getMes(),
                                dados.getAno());

                pages.checkoutPage().clicarPurchase();

                String mensagemSucesso = pages.checkoutPage().obterMensagemSucesso();

                Assert.assertEquals(
                                "Mensagem de compra diferente do esperado",
                                "Thank you for your purchase!",
                                mensagemSucesso);

                LoggerUtils.sucesso(test, "Compra finalizada com sucesso");
                capturarEvidencia("compra_realizada");

                pages.checkoutPage().clicarOk();

        }

}
