package com.autotesting.framework.utils;

import org.openqa.selenium.Capabilities;
import com.autotesting.framework.screens.MailBaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import java.net.URL;

public class WebDriverWrapper extends RemoteWebDriver{

    public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;
    protected final Logger log = Logger.getLogger(MailBaseScreen.class);

    public WebDriverWrapper(URL remoteUrl, Capabilities capabilities){
        super(remoteUrl, capabilities);
    }

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
