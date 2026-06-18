package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import data.model.LoginData;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonUtils;
import utils.LoggerUtils;

public class LoginTest extends BaseTest {

        @Test
        public void deveAbrirModalLogin() {
                LoggerUtils.info(test, "CT002 - Abrir Modal de Login");

                LoggerUtils.info(test, "acessando pagina inicial");
                HomePage homePage = new HomePage(driver);

                homePage.clicarLogin();

                capturarEvidencia("modal_login");
                LoggerUtils.sucesso(test, "Modal de login exibido com sucesso");
                Assert.assertTrue(
                                "Modal de login deveria estar visível",
                                homePage.modalLoginEstaVisivel());

        }

        @Test
        public void deveRealizarLoginComSucesso() {
                LoggerUtils.info(test, "CT003 - Realizar Login com Sucesso");

                LoggerUtils.info(test, "acessando pagina inicial");
                HomePage homePage = new HomePage(driver);

                LoginPage loginPage = new LoginPage(driver);

                LoggerUtils.info(test, "acessando modal de login");
                homePage.clicarLogin();

                LoggerUtils.info(test, "inserindo credenciais de login");

                LoginData dados = JsonUtils.carregarLoginData();

                loginPage.enterUsername(
                                dados.getUsername());

                loginPage.enterPassword(
                                dados.getPassword());

                LoggerUtils.info(test, "clicando em login");
                loginPage.clickLogin();

                String usuarioLogado = loginPage.obterUsuarioLogado();

                Assert.assertEquals("Usuário não logado",
                                "Welcome Qa_Rodrigo", usuarioLogado);

                LoggerUtils.sucesso(test, "Login realizado com sucesso");
                capturarEvidencia("login_realizado");

        }

}
