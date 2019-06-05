package com.epam.mypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

    private static final By SEARCH_LOGIN_LOCATOR = By.id("mailbox:login");
    private static final By SEARCH_BOX_LOCATOR = By.id("mailbox:domain");
    private static final By SEARCH_PASSWORD_LOCATOR = By.id("mailbox:password");
    private static final By SEARCH_LOGIN_BUTTON_LOCATOR = By.id("mailbox:submit");
    private static final String URL = "https://mail.ru/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }


    public void fillLogin(String login, String password){
        driver.findElement(SEARCH_LOGIN_LOCATOR).sendKeys(login);
        new Select(driver.findElement(SEARCH_BOX_LOCATOR)).selectByIndex(0);
        driver.findElement(SEARCH_PASSWORD_LOCATOR).sendKeys(password);
    }

    public InboxPage pressLogin () {
        driver.findElement(SEARCH_LOGIN_BUTTON_LOCATOR).click();
        return new InboxPage (driver);
    }
}
