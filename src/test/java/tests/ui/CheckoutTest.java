package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import data.model.CheckoutData;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest {

        @Test
        public void deveFinalizarCompraComSucesso() {

                /*
                 * Arrange
                 * Nesta etapa preparamos o cenário do teste.
                 * Aqui registramos informações iniciais e garantimos que tudo
                 * esteja pronto antes de executar a ação que será validada.
                 */
                LoggerUtils.info(
                                test,
                                "CT006 - Finalizar Compra com Sucesso");

                CartData dadosProduto = JsonUtils.carregarCartData();

                CheckoutData dadosCompra = JsonUtils.carregarCheckoutData();

                LoggerUtils.info(
                                test,
                                "Preparando produto para compra: "
                                                + dadosProduto.getProduto());

                /*
                 * Act
                 * Nesta etapa executamos a ação principal do teste.
                 * O objetivo é realizar apenas a operação que será validada,
                 * sem incluir verificações ou asserts.
                 */
                pages.homePage()
                                .clicarProduto(
                                                dadosProduto.getProduto());

                pages.productPage()
                                .adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                pages.homePage()
                                .clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",
                                pages.cartPage()
                                                .produtoExisteNoCarrinho(
                                                                dadosProduto.getProduto()));

                pages.cartPage()
                                .clicarPlaceOrder();

                Assert.assertTrue(
                                "Modal de compra deveria estar visível",
                                pages.checkoutPage()
                                                .modalEstaVisivel());

                LoggerUtils.info(
                                test,
                                "Preenchendo dados da compra");

                pages.checkoutPage()
                                .preencherFormularioCompra(
                                                dadosCompra.getNome(),
                                                dadosCompra.getPais(),
                                                dadosCompra.getCidade(),
                                                dadosCompra.getCartao(),
                                                dadosCompra.getMes(),
                                                dadosCompra.getAno());

                pages.checkoutPage()
                                .clicarPurchase();

                String mensagemSucesso = pages.checkoutPage()
                                .obterMensagemSucesso();

                /*
                 * Assert
                 * Nesta etapa verificamos se o resultado obtido corresponde
                 * ao esperado. Também registramos evidências e o resultado
                 * da execução no relatório.
                 */
                Assert.assertEquals(
                                "Mensagem de compra diferente do esperado",
                                "Thank you for your purchase!",
                                mensagemSucesso);

                capturarEvidencia(
                                "compra_realizada");

                LoggerUtils.sucesso(
                                test,
                                "Compra finalizada com sucesso");

                pages.checkoutPage()
                                .clicarOk();
        }

}