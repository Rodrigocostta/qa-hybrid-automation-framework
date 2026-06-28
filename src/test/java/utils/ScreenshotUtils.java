package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

        private ScreenshotUtils() {
        }

        public static void capturar(
                        WebDriver driver,
                        String nomeArquivo) {

                capturarRetornandoCaminho(
                                driver,
                                nomeArquivo);
        }

        public static String capturarRetornandoCaminho(
                        WebDriver driver,
                        String nomeArquivo) {

                try {

                        File origem = ((TakesScreenshot) driver)
                                        .getScreenshotAs(OutputType.FILE);

                        String nomeFinal = nomeArquivo
                                        + "_"
                                        + gerarTimestamp();

                        File destino = new File(
                                        ExecutionManager.getExecutionFolder()
                                                        + "/screenshots/"
                                                        + nomeFinal
                                                        + ".png");

                        destino.getParentFile().mkdirs();

                        Files.copy(
                                        origem.toPath(),
                                        destino.toPath(),
                                        StandardCopyOption.REPLACE_EXISTING);

                        return destino.getAbsolutePath();

                } catch (Exception e) {

                        throw new RuntimeException(
                                        "Erro ao capturar screenshot.",
                                        e);
                }
        }

        private static String gerarTimestamp() {

                return LocalDateTime.now()
                                .format(
                                                DateTimeFormatter.ofPattern(
                                                                "yyyyMMdd_HHmmss"));
        }

}