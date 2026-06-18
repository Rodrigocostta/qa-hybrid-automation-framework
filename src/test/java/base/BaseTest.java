package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BaseTest {

    /*
     * esse conjunto classe garante a inicialização e finalização do driver
     * corretamente das conexoses com o navegador, além de garantir a abertura da
     * página que será testada
     */

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    private boolean testeFalhou = false;

    @Rule
    public TestWatcher reportWatcher = new TestWatcher() {

        protected static final ExtentReports extent = ExtentReportManager.getInstance();

        /* cria o teste no relatório */
        @Override
        protected void starting(
                Description description) {

            testeFalhou = false;

            test = extent.createTest(
                    description.getMethodName());
        }

        /* marca o teste como aprovado */
        @Override
        protected void succeeded(
                Description description) {

            try {

                String caminhoScreenshot = ScreenshotUtils
                        .capturarRetornandoCaminho(
                                driver,
                                description.getMethodName()
                                        + "_sucesso");

                test.pass(
                        "Teste executado com sucesso");

                test.addScreenCaptureFromPath(
                        caminhoScreenshot);

            } catch (Exception e) {

                test.warning(
                        "Não foi possível anexar screenshot de sucesso");

            }
        }

        /* marca o teste como falho */
        @Override
        protected void failed(
                Throwable e,
                Description description) {

            testeFalhou = true;

            test.fail(e);
        }

        /* finaliza o teste no relatório */

        @Override
        protected void finished(
                Description description) {

            extent.flush();

        }

    };

    /* URL Base da aplicação */

    @Before
    public void iniciar() {

        /* inicializa o relatório de extensão */
        extent = ExtentReportManager.getInstance();

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
        driver.get(
                ConfigManager.getBaseUrl());
    }

    @After
    public void finalizar() {

        try {

            if (testeFalhou) {

                ScreenshotUtils.capturar(
                        driver,
                        "ERRO_" + System.currentTimeMillis());

            }

        } finally {

            driver.quit();

        }
    }

    /* metodos Extents Reports */
    protected void capturarEvidencia(String nomeArquivo) {

        ScreenshotUtils.capturar(
                driver,
                nomeArquivo);
    }

    protected void logInfo(String mensagem) {

        if (test != null) {
            test.info(mensagem);
        }
    }

    protected void logPass(String mensagem) {

        if (test != null) {
            test.pass(mensagem);
        }
    }

}
