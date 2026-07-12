package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import utils.LoggerUtils;
import utils.WaitUtils;

public class ProductTest extends BaseTest {

        @Test
        public void deveAdicionarProdutoAoCarrinho() {

                LoggerUtils.info(
                                test,
                                "CT004 - Adicionar Produto ao Carrinho");

                LoggerUtils.info(
                                test,
                                "Preparando seleção do produto");

                pages.homePage()
                                .clicarProduto("Samsung galaxy s6");

                Assert.assertEquals(
                                "Nome do produto incorreto",
                                "Samsung galaxy s6",
                                pages.productPage().obterNomeProduto());

                LoggerUtils.info(
                                test,
                                "Adicionando produto ao carrinho");

                pages.productPage()
                                .adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                String mensagem = alerta.getText();

                Assert.assertEquals(
                                "Mensagem de produto adicionado incorreta",
                                "Product added",
                                mensagem);

                // Fecha o alerta antes de qualquer interação com o navegador
                alerta.accept();

                capturarEvidencia(
                                "produto_adicionado");

                LoggerUtils.sucesso(
                                test,
                                "Produto adicionado ao carrinho com sucesso");
        }

}