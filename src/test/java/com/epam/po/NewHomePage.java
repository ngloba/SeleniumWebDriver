package com.epam.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewHomePage extends NewAbstractPage {


    public NewHomePage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://mailbox.org/en/";
    private static final By SEARCH_LOGIN_BUTTON_LOCATOR = By.xpath("//a[@title='Login']");
    private static final By SEARCH_LOGIN_MAIL_LOCATOR = By.id("login-username-input");
    private static final By SEARCH_PASSWORD_LOCATOR = By.id("login-password-input");
    private static final By SEARCH_LOGIN_LOCATOR = By.id("login-login-button");
    private static final By SEARCH_MAIL_BUTTON_LOCATOR = By.xpath("//i[@class=\"fa fa-envelope-o app-icon-mail\"]");
    private static final By SEARCH_CONTACT_AVATAR_LOCATOR = By.xpath("//div[@class=\"contact-picture\"]");
    private static final By SEARCH_MY_CONTACT_DATA_LOCATOR = By.xpath("//a[@data-name=\"my-contact-data\"]");
    private static final By SEARCH_LOGGED_CONTACT_LOCATOR = By.className("job");



    public void open() {
        driver.get(URL);
    }

    public void  fillLogin(String login, String password) {
        driver.findElement(SEARCH_LOGIN_BUTTON_LOCATOR).click();
        driver.findElement(SEARCH_LOGIN_MAIL_LOCATOR).sendKeys(login);
        driver.findElement(SEARCH_PASSWORD_LOCATOR).sendKeys(password);



}

public void pressLogin(){
    driver.findElement(SEARCH_LOGIN_LOCATOR).click();
   // waitForElementVisible(SEARCH_MAIL_BUTTON_LOCATOR);
   // driver.findElement(SEARCH_MAIL_BUTTON_LOCATOR).click();
}


    public String gettingContact () {
        waitForElementVisible(SEARCH_CONTACT_AVATAR_LOCATOR);
        driver.findElement(SEARCH_CONTACT_AVATAR_LOCATOR).click();
        waitForElementVisible(SEARCH_MY_CONTACT_DATA_LOCATOR);
        driver.findElement(SEARCH_MY_CONTACT_DATA_LOCATOR).click();
        waitForElementVisible(SEARCH_LOGGED_CONTACT_LOCATOR);
        String result = driver.findElement(SEARCH_LOGGED_CONTACT_LOCATOR).getText();
        return result;


}

}


