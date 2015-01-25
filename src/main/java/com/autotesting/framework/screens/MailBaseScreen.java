package com.autotesting.framework.screens;

import com.autotesting.framework.utils.WebDriverRunner;
import com.autotesting.framework.utils.WebDriverWrapper;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class MailBaseScreen {

    protected static final Logger log = Logger.getLogger(WebDriver.class);

    protected WebDriverWrapper driver = new WebDriverRunner().getDriver();

    public MailBaseScreen mailCloseBrowser()
    {
        WebDriverRunner.closeBrowser();
        return this;
    }
}
