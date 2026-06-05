package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import data.TestData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.WaitUtils;

public class HomePageTest extends BaseTest {

    @Test
    public void DeveAbrirPaginaInicial() {

        System.out.println("Iniciando teste");

        HomePage homePage = new HomePage(driver);

        String titulo = homePage.obterTituloPagina();

        System.out.println("Titulo encontrado: " + titulo);

        Assert.assertEquals("STORE", titulo);

        System.out.println("Teste finalizado com sucesso");
    }

    @Test
    public void deveAbrirModalLogin() {

        HomePage homePage = new HomePage(driver);

        homePage.clicarLogin();

        Assert.assertTrue(
                "Modal de login deveria estar visível",
                homePage.modalLoginEstaVisivel());
    }

    @Test
    public void deveRealizarLoginComSucesso() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        homePage.clicarLogin();

        loginPage.enterUsername(TestData.USERNAME);

        loginPage.enterPassword(TestData.PASSWORD);

        loginPage.clickLogin();

        /* Validar Login */
        aguardarUrlContem("demoblaze");

        String usuarioLogado = loginPage.obterUsuarioLogado();

        Assert.assertEquals(
                "Welcome Qa_Rodrigo",
                usuarioLogado);

    }

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

    @Test
    public void deveAdicionarProdutoAoCarrinhoComSucesso() {

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        homePage.clicarProdutoSamsung();

        Assert.assertEquals(
                "Samsung galaxy s6",
                productPage.obterNomeProduto());

        productPage.adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        Assert.assertEquals(
                "Product added",
                alerta.getText());

        alerta.accept();

        homePage.clicarCarrinho();

        Assert.assertTrue(
                "Produto deveria estar no carrinho",
                cartPage.produtoEstaNoCarrinho());
    }

    @Test
    public void deveRemoverProdutoDoCarrinho() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        homePage.clicarProdutoSamsung();

        productPage.adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        alerta.accept();

        homePage.clicarCarrinho();

        Assert.assertTrue(
                cartPage.produtoExisteNoCarrinho());

        cartPage.removerProduto();
        Thread.sleep(3000);

        Assert.assertFalse(
                "Produto deveria ter sido removido",
                cartPage.produtoExisteNoCarrinho());

    }

    @Test
    public void deveAbrirModalDeCompra() {

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        homePage.clicarProdutoSamsung();

        productPage.adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        alerta.accept();

        homePage.clicarCarrinho();

        cartPage.clicarPlaceOrder();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        Assert.assertTrue(
                "Modal de compra deveria estar visível",
                checkoutPage.modalEstaVisivel());

        checkoutPage.preencherFormularioCompra(
                TestData.NOME,
                TestData.PAIS,
                TestData.CIDADE,
                TestData.CARTAO,
                TestData.MES,
                TestData.ANO);

        checkoutPage.clicarPurchase();

        String mensagemSucesso = checkoutPage.obterMensagemSucesso();

        Assert.assertEquals(
                "Thank you for your purchase!",
                mensagemSucesso);

        checkoutPage.clicarOk();
    }
}
