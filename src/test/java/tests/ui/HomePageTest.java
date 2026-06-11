package tests.ui;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;

import pages.HomePage;
import utils.LogUtils;


public class HomePageTest extends BaseTest {

    @Test
    public void DeveAbrirPaginaInicial() {

        LogUtils.info("Iniciando teste da página inicial");

        HomePage homePage = new HomePage(driver);

        String titulo = homePage.obterTituloPagina();


        LogUtils.info("Título encontrado: " + titulo);

        Assert.assertEquals("STORE", titulo);

        LogUtils.info("Teste finalizado com sucesso");

     

       
    }

}
