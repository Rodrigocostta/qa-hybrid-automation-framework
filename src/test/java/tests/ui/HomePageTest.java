package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import pages.PageManager;
import utils.LoggerUtils;

public class HomePageTest extends BaseTest {

        @Test
        public void deveAbrirPaginaInicial() {

                LoggerUtils.info(test,
                                "CT001 - Abrir Página Inicial");

                LoggerUtils.info(test,
                                "Abrindo página inicial");

                String titulo = pages.homePage().obterTituloPagina();

                LoggerUtils.info(test,
                                "Título encontrado: " + titulo);

                Assert.assertEquals(
                                "Título da página incorreto",
                                "STORE", titulo);

                capturarEvidencia("pagina_inicial");
                LoggerUtils.sucesso(test,
                                "Título da página inicial esperado encontrado");

        }

}
