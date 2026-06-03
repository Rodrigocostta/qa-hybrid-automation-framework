package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    /*
     * esse conjunto classe garante a inicialização e finalização do driver
     * corretamente das conexoses com o navegador, além de garantir a abertura da
     * página que será testada
     */

    protected WebDriver driver;

    /* URL Base da aplicação */
    private static final String URL_BASE = "https://www.demoblaze.com/";

    // Fazer Verifcao de telas de trabalho
    public void aguardarUrlContem(String parteUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(parteUrl));
    }

    @Before
    public void iniciar() {
        /* baixa o driver automaticamente */
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }

}
