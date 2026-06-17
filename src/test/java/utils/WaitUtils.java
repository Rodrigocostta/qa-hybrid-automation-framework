package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

        private static final int TIMEOUT = 10;

        private WaitUtils() {
        }

        /*
         * Espera um elemento ficar visível
         */
        public static void esperarElementoVisivel(
                        WebDriver driver,
                        By locator) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(locator));
        }

        /*
         * Espera um texto aparecer dentro de um elemento
         */
        public static void esperarTexto(
                        WebDriver driver,
                        By locator,
                        String texto) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

                wait.until(
                                ExpectedConditions.textToBePresentInElementLocated(
                                                locator,
                                                texto));
        }

        /*
         * Espera um elemento ficar clicável
         */
        public static void esperarElementoClicavel(
                        WebDriver driver,
                        By locator) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

                wait.until(
                                ExpectedConditions.elementToBeClickable(locator));
        }

        /*
         * Espera a URL conter determinado texto
         */
        public static void esperarUrlContem(
                        WebDriver driver,
                        String textoUrl) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

                wait.until(
                                ExpectedConditions.urlContains(textoUrl));
        }

        /*
         * Espera um alerta aparecer
         */
        public static Alert esperarAlerta(
                        WebDriver driver) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

                return wait.until(
                                ExpectedConditions.alertIsPresent());
        }

        public static void esperarProdutoRemovido(
                        WebDriver driver,
                        By produtoCarrinho) {

                WebDriverWait wait = new WebDriverWait(
                                driver,
                                Duration.ofSeconds(10));

                wait.until(
                                ExpectedConditions.invisibilityOfElementLocated(
                                                produtoCarrinho));
        }
}