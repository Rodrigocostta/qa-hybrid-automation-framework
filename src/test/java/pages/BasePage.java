package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class BasePage {

    private WebElement elemento(By locator) {

        return driver.findElement(locator);

    }

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

        WebElement campo = elemento(locator);

        campo.clear();

        campo.sendKeys(texto);

    }

    protected String getText(By locator) {

        WaitUtils.esperarElementoVisivel(
                driver,
                locator);

        return elemento(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        WaitUtils.esperarElementoVisivel(
                driver,
                locator);

        return elemento(locator).isDisplayed();
    }

}