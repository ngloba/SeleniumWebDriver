package com.epam.mypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewMailPage extends AbstractPage{

   public static final By NEW_ADRES_LOCATOR = By.xpath("//label[@class='container--zU301']//input[@class='container--H9L5q size_s--3_M-_']");
   public static final By NEW_MAIL_SUBJECT_LOCATOR = By.xpath("//div[@class='subject__container--HWnat']//input[@class='container--H9L5q size_s--3_M-_']");
   public static final By SAVE_NEW_MAIL_BUTTON_LOCATOR = By.xpath("//div[@class='compose-app__buttons']/span[2]");
   public static final By CLOSE_NEW_MAIL_WINDOW_BUTTON_LOCATOR = By.xpath("//div[@class='compose-app__compose']/div[2]/div[2]//button[2]");


    public NewMailPage(WebDriver driver) {
        super(driver);
    }

    public void newMailCreation (String newAdres, String newMailSubject) {
        waitForElementVisible(NEW_ADRES_LOCATOR);
        driver.findElement(NEW_ADRES_LOCATOR).sendKeys(newAdres);

        waitForElementVisible(NEW_MAIL_SUBJECT_LOCATOR);
        driver.findElement(NEW_MAIL_SUBJECT_LOCATOR).sendKeys(newMailSubject);
    }

    public InboxPage saveNewMailToDraft () {
        driver.findElement(SAVE_NEW_MAIL_BUTTON_LOCATOR).click();
        driver.findElement(CLOSE_NEW_MAIL_WINDOW_BUTTON_LOCATOR).click();
        return new InboxPage(driver);
    }
}
