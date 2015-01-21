package com.autotesting.framework.suits;

import com.autotesting.framework.screens.MailLoginPageScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.String;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.autotesting.framework.screens.MailBaseScreen;

public class MailLoginPageTest {
    private static final String USER_NAME_FOR_LOGIN = "auto_test_user01";
    protected MailLoginPageScreen mailLoginPageScreen;
    protected WebElement element;
    protected MailBaseScreen mailBaseScreen;
    WebDriver driver;

    @BeforeTest(description = "Инициализация драйвера")
    public void runDriverTest()
    {
        driver = new FirefoxDriver();
    }

    @Test(description = "Проверяем авторизацию пользователя на mail.ru")
    public void checkLoginPageTest()
    {
        mailLoginPageScreen = new MailLoginPageScreen().openLoginPageScreen(driver);
        mailLoginPageScreen = new MailLoginPageScreen().inputLogin(element, driver);
        mailLoginPageScreen = new MailLoginPageScreen().inputPassword(element, driver);
        mailLoginPageScreen = new MailLoginPageScreen().submitAuthorizationMailForm(element, driver);
        Assert.assertEquals(mailLoginPageScreen.getUserEmailText(driver), USER_NAME_FOR_LOGIN+"@mail.ru", "Имена не совпадают");
    }

    @AfterTest(description = "Закрываем браузер")
    public void closeBrowser()
    {
        mailBaseScreen = new MailBaseScreen().mailCloseBrowser(driver);
    }
}
