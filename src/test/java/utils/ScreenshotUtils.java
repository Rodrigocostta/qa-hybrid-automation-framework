package utils;

import java.io.File;
//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

        public static void capturar(WebDriver driver, String nomeArquivo) {

                try {

                        System.out.println("Capturando screenshot: " + nomeArquivo);

                        File origem = ((TakesScreenshot) driver)
                                        .getScreenshotAs(OutputType.FILE);

                        File destino = new File(
                                        "target/screenshots/" + nomeArquivo + ".png");

                        destino.getParentFile().mkdirs();

                        Files.copy(
                                        origem.toPath(),
                                        destino.toPath(),
                                        StandardCopyOption.REPLACE_EXISTING);

                        System.out.println("Screenshot salvo com sucesso");

                } catch (Exception e) {

                        System.out.println("ERRO AO CAPTURAR SCREENSHOT");

                        System.out.println("Classe do erro: "
                                        + e.getClass().getName());

                        System.out.println("Mensagem: "
                                        + e.getMessage());

                        e.printStackTrace();
                }
        }
}