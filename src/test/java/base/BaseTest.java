package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ScreenshotUtils;

public class BaseTest {

    /*
     * esse conjunto classe garante a inicialização e finalização do driver
     * corretamente das conexoses com o navegador, além de garantir a abertura da
     * página que será testada
     */

    protected WebDriver driver;

    /* URL Base da aplicação */

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

        /* URL Base da aplicação */
        driver.get(Config.BASE_URL);
    }

    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void capturarEvidencia(String nomeArquivo) {

        ScreenshotUtils.capturar(
                driver,
                nomeArquivo);
    }

}
