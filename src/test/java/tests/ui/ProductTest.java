package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import base.BaseTest;
import pages.PageManager;
import utils.LoggerUtils;
import utils.WaitUtils;

public class ProductTest extends BaseTest {

    PageManager pages = new PageManager(driver);

    /* Adiciona Produto ao Carrinho */
    @Test
    public void deveAdicionarProdutoAoCarrinho() {
        LoggerUtils.info(test,
                "CT004 - Adicionar Produto ao Carrinho");

        LoggerUtils.info(test,
                "Selecionando produto Samsung");
        pages.homePage().clicarProduto("Samsung galaxy s6");

        Assert.assertEquals(
                "Nome do produto incorreto",
                "Samsung galaxy s6",
                pages.productPage().obterNomeProduto());

        LoggerUtils.info(test,
                "Adicionando produto ao carrinho");
        pages.productPage().adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        String mensagem = alerta.getText();

        Assert.assertEquals(
                "Mensagem de produto adicionado incorreta",
                "Product added",
                mensagem);
        LoggerUtils.sucesso(test,
                "Produto adicionado ao carrinho com sucesso");
        capturarEvidencia("produto_adicionado");

        alerta.accept();
    }

}
