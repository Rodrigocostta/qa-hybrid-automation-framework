package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigManager;

public class WaitUtils {

        private static WebDriverWait criarWait(
                        WebDriver driver) {

                return new WebDriverWait(
                                driver,
                                Duration.ofSeconds(
                                                ConfigManager.getTimeout()));
        }

        private WaitUtils() {
        }

        /*
         * Espera um elemento ficar visível
         */
        public static void esperarElementoVisivel(
                        WebDriver driver,
                        By locator) {

                criarWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        /*
         * Espera um texto aparecer dentro de um elemento
         */
        public static void esperarTexto(
                        WebDriver driver,
                        By locator,
                        String texto) {

                criarWait(driver).until(ExpectedConditions.textToBePresentInElementLocated(locator, texto));
        }

        /*
         * Espera um elemento ficar clicável
         */
        public static void esperarElementoClicavel(
                        WebDriver driver,
                        By locator) {

                criarWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
        }

        /*
         * Espera a URL conter determinado texto
         */
        public static void esperarUrlContem(
                        WebDriver driver,
                        String textoUrl) {

                criarWait(driver).until(ExpectedConditions.urlContains(textoUrl));
        }

        /*
         * Espera um alerta aparecer
         */
        public static Alert esperarAlerta(
                        WebDriver driver) {

                return criarWait(driver).until(
                                ExpectedConditions.alertIsPresent());
        }

        public static void esperarProdutoRemovido(
                        WebDriver driver,
                        By locator) {

                criarWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

        public static boolean esperarElementoInvisivel(
                        WebDriver driver,
                        By locator) {

                return criarWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

        public static WebElement esperarPresencaElemento(
                        WebDriver driver,
                        By locator) {

                return criarWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
        }

}