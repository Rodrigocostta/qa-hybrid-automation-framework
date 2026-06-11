package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import utils.WaitUtils;

public class ProductTest extends BaseTest {

    /* Adiciona Produto ao Carrinho */
    @Test
    public void deveAdicionarProdutoAoCarrinho() {

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        homePage.clicarProdutoSamsung();

        Assert.assertEquals(
                "Samsung galaxy s6",
                productPage.obterNomeProduto());

        productPage.adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        String mensagem = alerta.getText();

        Assert.assertEquals(
                "Product added",
                mensagem);

        alerta.accept();
    }

}
