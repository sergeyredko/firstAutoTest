package com.autotesting.framework.utils;

import com.autotesting.framework.screens.MailBaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class WebDriverWrapper extends FirefoxDriver{

    public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;
    protected final Logger log = Logger.getLogger(MailBaseScreen.class);

    public void enterTextByXpath(String xpath, String text){
        log.info(String.format("[ACTION]: Ввод текста '%s' в элемент: '%s'", text, xpath));
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void clickByXpath(String xpath) {
        log.info("[ACTION]: Клик по элементу: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).click();
    }

    private void waitForElementPresentAndVisible(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
