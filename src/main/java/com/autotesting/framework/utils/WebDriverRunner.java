package com.autotesting.framework.utils;

import org.apache.log4j.Logger;

public class WebDriverRunner {
    private static WebDriverWrapper driver;
    private static final Logger log = Logger.getLogger(WebDriverRunner.class);

    public WebDriverRunner() {
        try {
            driver = new WebDriverWrapper();
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
