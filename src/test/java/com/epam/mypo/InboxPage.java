package com.epam.mypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InboxPage extends AbstractPage{

    public static final By LOGIN_MAIL_LOCATOR = By.id("PH_user-email");
    public static final By SENT_FOLDER_LOCATOR = By.xpath("//a[@href='/sent/']");
    public static final By NEW_MAIL_CREATION_LOCATOR = By.xpath("//span[@class='compose-button__txt']");
    public static final By DRAF_FOLDER_LOCATOR = By.xpath("//a[@href='/drafts/']");
    public static final By FIRST_MAIL_LOCATOR = By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']");

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginMail () {
        waitForElementVisible(LOGIN_MAIL_LOCATOR);
        String result = driver.findElement(LOGIN_MAIL_LOCATOR).getAttribute("innerText");
        return result;
    }



    public NewMailPage clickOnNewMailButton () {
         waitForElementVisible(NEW_MAIL_CREATION_LOCATOR);
         driver.findElement(NEW_MAIL_CREATION_LOCATOR).click();
         return new NewMailPage (driver);
    }


    public DraftPage clickOnDraftFolder () {
        waitForElementVisible(DRAF_FOLDER_LOCATOR);
        driver.findElement(DRAF_FOLDER_LOCATOR).click();
        return new DraftPage (driver);
    }

    public SentPage clickOnSentFolder (){
        waitForElementVisible(SENT_FOLDER_LOCATOR);
        driver.findElement(SENT_FOLDER_LOCATOR).click();
        return new SentPage (driver);

    }

    public void RightClick () {
        waitForElementVisible(FIRST_MAIL_LOCATOR);
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(FIRST_MAIL_LOCATOR);
        actions.contextClick(elementLocator).perform();
    }
}
