package com.autotesting.framework.utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;

public class WebDriverRunner {
    private static FirefoxDriver driver;
    private static final Logger log = Logger.getLogger(WebDriverRunner.class);

    public WebDriverRunner() {
        try {
            driver = new FirefoxDriver();
        } catch (Exception e) {
            log.error("Ошибка при создании драйвера");
        }
    }

    public static FirefoxDriver getDriver(){
        if (driver == null){
            new WebDriverRunner();
        }
        return driver;
    }

    public static void closeBrowser(){
        log.info("Закрываем драйвер");
        driver.quit();
    }
}
