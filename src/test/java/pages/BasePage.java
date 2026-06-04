package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {

        WaitUtils.esperarElementoClicavel(
                driver,
                locator);

        driver.findElement(locator).click();
    }

    protected void type(
            By locator,
            String texto) {

        WaitUtils.esperarElementoVisivel(
                driver,
                locator);

        driver.findElement(locator).clear();

        driver.findElement(locator).sendKeys(texto);
    }

    protected String getText(By locator) {

        WaitUtils.esperarElementoVisivel(
                driver,
                locator);

        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        WaitUtils.esperarElementoVisivel(
                driver,
                locator);

        return driver.findElement(locator).isDisplayed();
    }
}