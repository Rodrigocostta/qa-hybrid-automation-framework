package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.model.CartData;
import pages.PageManager;
import utils.JsonUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class CartTest extends BaseTest {

        PageManager pages = new PageManager(driver);

        @Test
        public void deveRemoverProdutoDoCarrinho() {

                LoggerUtils.info(test,
                                "CT005 - Remover Produto do Carrinho");

                CartData dadosProduto = JsonUtils.carregarCartData();

                LoggerUtils.info(test,
                                "Selecionando produto: " + dadosProduto.getProduto());

                pages.homePage().clicarProduto(dadosProduto.getProduto());

                LoggerUtils.info(test,
                                "Adicionando produto ao carrinho");

                pages.productPage().adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                alerta.accept();

                LoggerUtils.info(test,
                                "Acessando carrinho");

                pages.homePage().clicarCarrinho();

                Assert.assertTrue(
                                "Produto não encontrado no carrinho",
                                pages.cartPage().produtoExisteNoCarrinho(dadosProduto.getProduto()));

                LoggerUtils.info(test,
                                "Removendo produto do carrinho");

                pages.cartPage().removerProduto();

                pages.cartPage().aguardarRemocaoProduto(dadosProduto.getProduto());

                LoggerUtils.sucesso(test,
                                "Produto removido do carrinho com sucesso");

                capturarEvidencia(
                                "produto_removido");

                Assert.assertFalse(
                                "Produto deveria ter sido removido",
                                pages.cartPage().produtoExisteNoCarrinho(
                                                dadosProduto.getProduto()));
        }

}
