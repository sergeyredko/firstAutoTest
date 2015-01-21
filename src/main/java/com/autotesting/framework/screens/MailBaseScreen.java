package com.autotesting.framework.screens;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class MailBaseScreen {

    protected static final Logger log = Logger.getLogger(WebDriver.class);

    public MailBaseScreen mailCloseBrowser(WebDriver webDriver)
    {
        log.info("Закрываем браузер");
        webDriver.quit();
        return this;
    }
}
