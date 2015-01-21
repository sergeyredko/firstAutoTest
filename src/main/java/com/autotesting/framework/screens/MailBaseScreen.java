package com.autotesting.framework.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailBaseScreen {
    public MailBaseScreen mailCloseBrowser(WebDriver webDriver)
    {
        webDriver.quit();
        return this;
    }
}
