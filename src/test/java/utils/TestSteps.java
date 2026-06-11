
package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.ProductPage;

public class TestSteps {

    public static void adicionarSamsungAoCarrinho(WebDriver driver) {

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        homePage.clicarProdutoSamsung();

        productPage.adicionarAoCarrinho();

        Alert alerta = WaitUtils.esperarAlerta(driver);

        alerta.accept();
    }
}
    
    

