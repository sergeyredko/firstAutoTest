package com.autotesting.framework.screens;

import com.autotesting.framework.utils.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MailBaseScreen {

    protected static final Logger log = Logger.getLogger(WebDriver.class);
    FirefoxDriver driver = new WebDriverRunner().getDriver();

    public MailBaseScreen mailCloseBrowser()
    {
        WebDriverRunner.closeBrowser();
        return this;
    }
}
