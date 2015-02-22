package com.autotesting.framework.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class WebDriverRunner{
    private static WebDriverWrapper driver;
    private static final Logger log = Logger.getLogger(WebDriverRunner.class);


    public WebDriverRunner() {
        try {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setCapability("platform", Platform.WINDOWS);
            driver = new WebDriverWrapper(new URL("http://localhost:4444/wd/hub"), capability);
        } catch (Exception e) {
            log.error("Ошибка при создании драйвера");
        }
    }

    public static WebDriverWrapper getDriver(){
        if (driver == null){
            new WebDriverRunner();
        }
        return driver;
    }

    public static void closeBrowser(){
        log.info("Закрываем браузер");
        driver.quit();
    }
}
