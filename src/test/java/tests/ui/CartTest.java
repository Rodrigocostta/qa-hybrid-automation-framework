package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CartTest extends BaseTest {

        @Test
        public void deveRemoverProdutoDoCarrinho() {

                /*
                 * Arrange
                 * Nesta etapa preparamos o cenário do teste.
                 * Aqui registramos informações iniciais e garantimos que tudo
                 * esteja pronto antes de executar a ação que será validada.
                 */
                LoggerUtils.info(
                                test,
                                "CT005 - Remover Produto do Carrinho");

                CartData dadosProduto = JsonUtils.carregarCartData();

                LoggerUtils.info(
                                test,
                                "Preparando produto: "
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

                LoggerUtils.info(
                                test,
                                "Adicionando produto ao carrinho");

                pages.productPage()
                                .adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                LoggerUtils.info(
                                test,
                                "Acessando carrinho para validar a remoção");

                pages.homePage()
                                .clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",
                                pages.cartPage()
                                                .produtoExisteNoCarrinho(
                                                                dadosProduto.getProduto()));

                LoggerUtils.info(
                                test,
                                "Removendo produto do carrinho");

                pages.cartPage()
                                .removerProduto();

                pages.cartPage()
                                .aguardarRemocaoProduto(
                                                dadosProduto.getProduto());

                /*
                 * Assert
                 * Nesta etapa verificamos se o resultado obtido corresponde
                 * ao esperado. Também registramos evidências e o resultado
                 * da execução no relatório.
                 */
                Assert.assertFalse(
                                "Produto deveria ter sido removido",
                                pages.cartPage()
                                                .produtoExisteNoCarrinho(
                                                                dadosProduto.getProduto()));

                capturarEvidencia(
                                "produto_removido");

                LoggerUtils.sucesso(
                                test,
                                "Produto removido do carrinho com sucesso");
        }

}