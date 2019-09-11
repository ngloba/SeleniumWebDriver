package com.epam.mypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends AbstractPage{
    public static final By MAIL_SUBJECT_LOCATOR = By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']");
    public static final By FIRST_MAIL_LOCATOR = By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']");
    //public static final By FIRST_MAIL_LOCATOR = By.cssSelector("div[class*='llc__item llc__item_title']");
    public static final By SEND_MAIL_BUTTON_LOCATOR = By.xpath("//div[@class='compose-app__buttons']/span[1]");
    public static final By CONFIR_SENDING_MAIL_BUTTON_LOCATOR = By.xpath("//div[@data-test-id='confirmation:empty-letter']//button[1]");


    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public String getSubjectFromDraft () {

        return driver.findElement(FIRST_MAIL_LOCATOR).getAttribute("title");
    }

    public InboxPage sendingMailFromDraft () {
        waitForElementVisible(FIRST_MAIL_LOCATOR);
        driver.findElement(FIRST_MAIL_LOCATOR).click();
        driver.findElement(SEND_MAIL_BUTTON_LOCATOR).click();
        driver.findElement(CONFIR_SENDING_MAIL_BUTTON_LOCATOR).click();
        return new InboxPage(driver);
    }
}
