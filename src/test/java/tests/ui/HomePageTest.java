package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    @Test
    public void deveAbrirPaginaInicial() {

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
    public void devePreencherFormularioLogin() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        homePage.clicarLogin();

        loginPage.enterUsername("teste");

        loginPage.enterPassword("123456");
    }
}