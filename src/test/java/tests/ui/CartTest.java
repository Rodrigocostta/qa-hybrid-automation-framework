package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CartTest extends BaseTest {

        @Test
        public void deveRemoverProdutoDoCarrinho() {

                LoggerUtils.info(
                                test,
                                "CT005 - Remover Produto do Carrinho");

                HomePage homePage = new HomePage(driver);

                ProductPage productPage = new ProductPage(driver);

                CartPage cartPage = new CartPage(driver);

                CartData dadosProduto = JsonUtils.carregarCartData();

                LoggerUtils.info(
                                test,
                                "Selecionando produto: "
                                                + dadosProduto.getProduto());

                homePage.clicarProduto(
                                dadosProduto.getProduto());

                LoggerUtils.info(
                                test,
                                "Adicionando produto ao carrinho");

                productPage.adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                LoggerUtils.info(
                                test,
                                "Acessando carrinho");

                homePage.clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",
                                cartPage.produtoExisteNoCarrinho(
                                                dadosProduto.getProduto()));

                LoggerUtils.info(
                                test,
                                "Removendo produto do carrinho");

                cartPage.removerProduto();

                cartPage.aguardarRemocaoProduto(
                                dadosProduto.getProduto());

                LoggerUtils.sucesso(
                                test,
                                "Produto removido do carrinho com sucesso");

                capturarEvidencia(
                                "produto_removido");

                Assert.assertFalse(
                                "Produto deveria ter sido removido",
                                cartPage.produtoExisteNoCarrinho(
                                                dadosProduto.getProduto()));
        }

}
