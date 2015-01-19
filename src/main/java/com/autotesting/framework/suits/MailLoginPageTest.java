package com.autotesting.framework.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.String;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MailLoginPageTest {
    private static final String USER_NAME_FOR_LOGIN = "auto_test_user01";
    private static final String PASSWORD_FOR_LOGIN = "Jut_123123";
    private static final String LOGIN_PAGE_LOGIN_FIELD_XPATH = "//input[@id='mailbox__login']";
    private static final String LOGIN_PAGE_PASSWORD_FIELD_XPATH = "//input[@id='mailbox__password']";
    private static final String MAIL_URL_FOR_TEST = "https://mail.ru";
    private static final String EXPECTED_USER_EMAIL_XPATH = "//i[@id='PH_user-email']";
    private WebElement element;
    WebDriver driver;

    @BeforeTest(description = "Инициализация драйвера")
    public void runDriverTest()
    {
        driver = new FirefoxDriver();
    }

    @Test(description = "Проверяем авторизацию пользователя на mail.ru")
    public void checkLoginPageTest()
    {
        driver.get(MAIL_URL_FOR_TEST);
        element = driver.findElement(By.xpath(LOGIN_PAGE_LOGIN_FIELD_XPATH));
        element.sendKeys(USER_NAME_FOR_LOGIN);
        element = driver.findElement(By.xpath(LOGIN_PAGE_PASSWORD_FIELD_XPATH));
        element.sendKeys(PASSWORD_FOR_LOGIN);
        element.submit();
        String result = driver.findElement(By.xpath(EXPECTED_USER_EMAIL_XPATH)).getText();
        Assert.assertEquals(result, USER_NAME_FOR_LOGIN+"@mail.ru", "Имена не совпадают");
    }

    @AfterTest(description = "Закрываем браузер")
    public void closeBrowser()
    {
        driver.quit();
    }
}
