package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import base.BaseTest;
import utils.LoggerUtils;

public class LoginTest extends BaseTest {

        @Test
        public void deveAbrirModalLogin() {

                /*
                 * Arrange
                 * Nesta etapa preparamos o cenário do teste.
                 * Aqui registramos informações iniciais e garantimos que tudo
                 * esteja pronto antes de executar a ação que será validada.
                 */
                LoggerUtils.info(
                                test,
                                "CT002 - Abrir Modal de Login");

                LoggerUtils.info(
                                test,
                                "Validando abertura do modal de login");

                /*
                 * Act
                 * Nesta etapa executamos a ação principal do teste.
                 * O objetivo é realizar apenas a operação que será validada,
                 * sem incluir verificações ou asserts.
                 */
                pages.homePage().clicarLogin();

                /*
                 * Assert
                 * Nesta etapa verificamos se o resultado obtido corresponde
                 * ao esperado. Também registramos evidências e o resultado
                 * da execução no relatório.
                 */
                Assert.assertTrue(
                                "Modal de login deveria estar visível",
                                pages.homePage().modalLoginEstaVisivel());

                capturarEvidencia("modal_login");

                LoggerUtils.sucesso(
                                test,
                                "Modal de login exibido com sucesso");
        }

}
