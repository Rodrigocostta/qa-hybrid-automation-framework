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
        logInfo("CT002 - Abrir Modal de Login");

        logInfo("acessando pagina inicial");
        HomePage homePage = new HomePage(driver);

        homePage.clicarLogin();

        logPass("Modal de login exibido com sucesso");
        Assert.assertTrue(
                "Modal de login deveria estar visível",
                homePage.modalLoginEstaVisivel());

    }

    @Test
    public void deveRealizarLoginComSucesso() {
        logInfo("CT003 - Realizar Login com Sucesso");

        logInfo("acessando pagina inicial");
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        logInfo("acessando modal de login");
        homePage.clicarLogin();

        logInfo("inserindo credenciais de login");
        loginPage.enterUsername(TestData.USERNAME);
        loginPage.enterPassword(TestData.PASSWORD);

        logInfo("clicando em login");
        loginPage.clickLogin();

        String usuarioLogado = loginPage.obterUsuarioLogado();

        Assert.assertEquals("Usuário não logado",
                "Welcome Qa_Rodrigo", usuarioLogado);

        logPass("Login realizado com sucesso");
        capturarEvidencia("login_realizado");

    }

}
