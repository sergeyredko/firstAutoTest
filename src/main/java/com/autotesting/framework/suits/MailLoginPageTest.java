package com.autotesting.framework.suits;

import com.autotesting.framework.screens.MailLoginPageScreen;
import org.openqa.selenium.WebElement;
import java.lang.String;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MailLoginPageTest {
    private static final String USER_NAME_FOR_LOGIN = "auto_test_user01";
    protected MailLoginPageScreen mailLoginPageScreen;

    @Test(description = "Проверяем авторизацию пользователя на mail.ru")
    public void checkLoginPageTest()
    {
        mailLoginPageScreen = new MailLoginPageScreen().openLoginPageScreen();
        mailLoginPageScreen.inputLogin();
        mailLoginPageScreen.inputPassword();
        mailLoginPageScreen.submitAuthorizationMailForm();
        Assert.assertEquals(mailLoginPageScreen.getUserEmailText(), USER_NAME_FOR_LOGIN+"@mail.ru", "Имена не совпадают");
    }

    @AfterTest(description = "Закрываем браузер")
    public void closeBrowser()
    {
        mailLoginPageScreen.mailCloseBrowser();
    }
}
