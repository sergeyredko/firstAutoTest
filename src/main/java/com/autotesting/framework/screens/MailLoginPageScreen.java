package com.autotesting.framework.screens;

import org.openqa.selenium.By;

public class MailLoginPageScreen extends MailBaseScreen{
    private final String MAIL_URL_FOR_TEST = "https://mail.ru";
    private final String EXPECTED_USER_EMAIL_XPATH = "//i[@id='PH_user-email']";
    private final String USER_NAME_FOR_LOGIN = "auto_test_user01";
    private final String LOGIN_PAGE_LOGIN_FIELD_XPATH = "//input[@id='mailbox__login']";
    private final String LOGIN_PAGE_PASSWORD_FIELD_XPATH = "//input[@id='mailbox__password']";
    private static final String PASSWORD_FOR_LOGIN = "Jut_123123";
    private static final String LOGIN_PAGE_BUTTON_XPATH = "//input[@id='mailbox__auth__button']";

    public MailLoginPageScreen openLoginPageScreen() {
        log.info(String.format("Открываем в браузере страницу логина по адресу %s", MAIL_URL_FOR_TEST));
        driver.get(MAIL_URL_FOR_TEST);
        return this;
    }

    public String getUserEmailText() {
        log.info(String.format("Получаем значение имени пользователя из хедера страницы логина: '%s'", USER_NAME_FOR_LOGIN));
        String result = driver.findElement(By.xpath(EXPECTED_USER_EMAIL_XPATH)).getText();
        return result;
    }

    public MailLoginPageScreen inputLogin()
    {
        log.info(String.format("Вводим логин: '%s'", USER_NAME_FOR_LOGIN));
        driver.enterTextByXpath(LOGIN_PAGE_LOGIN_FIELD_XPATH, USER_NAME_FOR_LOGIN);
        return this;
    }

    public MailLoginPageScreen inputPassword()
    {
        log.info(String.format("Вводим пароль: '%s'", PASSWORD_FOR_LOGIN));
        driver.enterTextByXpath(LOGIN_PAGE_PASSWORD_FIELD_XPATH, PASSWORD_FOR_LOGIN);
        return this;
    }

    public MailLoginPageScreen submitAuthorizationMailForm()
    {
        log.info(String.format("Отправляем форму кликом по кнопке Войти"));
        driver.clickByXpath(LOGIN_PAGE_BUTTON_XPATH);
        return this;
    }
}
