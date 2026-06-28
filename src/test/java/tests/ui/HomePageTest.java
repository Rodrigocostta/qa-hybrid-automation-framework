package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import utils.LoggerUtils;

public class HomePageTest extends BaseTest {

        @Test
        public void deveAbrirPaginaInicial() {

                /*
                 * Arrange
                 * Nesta etapa preparamos o cenário do teste.
                 * Aqui registramos informações iniciais e garantimos que tudo
                 * esteja pronto antes de executar a ação que será validada.
                 */
                LoggerUtils.info(
                                test,
                                "CT001 - Abrir Página Inicial");

                LoggerUtils.info(
                                test,
                                "Validando abertura da página inicial");

                /*
                 * Act
                 * Nesta etapa executamos a ação principal do teste.
                 * O objetivo é realizar apenas a operação que será validada,
                 * sem incluir verificações ou asserts.
                 */
                String titulo = pages.homePage()
                                .obterTituloPagina();

                /*
                 * Assert
                 * Nesta etapa verificamos se o resultado obtido corresponde
                 * ao esperado. Também registramos evidências e o resultado
                 * da execução no relatório.
                 */
                LoggerUtils.info(
                                test,
                                "Título encontrado: " + titulo);

                Assert.assertEquals(
                                "Título da página incorreto",
                                "STORE",
                                titulo);

                capturarEvidencia(
                                "pagina_inicial");

                LoggerUtils.sucesso(
                                test,
                                "Página inicial validada com sucesso");
        }

}
