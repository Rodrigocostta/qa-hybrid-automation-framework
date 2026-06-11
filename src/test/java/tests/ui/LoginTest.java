package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import data.TestData;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

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

        String usuarioLogado = loginPage.obterUsuarioLogado();

        Assert.assertEquals(
                "Welcome Qa_Rodrigo", usuarioLogado);

        capturarEvidencia("login_realizado");

    }

}
