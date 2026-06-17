package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;

import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void DeveAbrirPaginaInicial() {
        logInfo("CT001 - Abrir Página Inicial");

        logInfo("Abrindo página inicial");
        HomePage homePage = new HomePage(driver);

        String titulo = homePage.obterTituloPagina();

        logInfo("Título encontrado: " + titulo);

        Assert.assertEquals(
                "Título da página incorreto",
                "STORE",
                titulo);

        logPass("Título da página inicial esperado encontrado");

    }

}
