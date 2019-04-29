package com.epam.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MailHelper {
    ChromeDriver driver;
    private static BaseTest baseTest;

    public MailHelper(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    public static void login(String login, String password) {
        WebElement loginField = baseTest.getDriver().findElement(By.id("mailbox:login"));
        Select box = new Select(baseTest.getDriver().findElement(By.id("mailbox:domain")));
        WebElement passwordField = baseTest.getDriver().findElement(By.id("mailbox:password"));
        WebElement loginButton = baseTest.getDriver().findElement(By.id("mailbox:submit"));

        loginField.sendKeys(login);
        //box.selectByVisibleText("mail.ru");
        box.selectByIndex(0);
        passwordField.sendKeys(password);
        loginButton.submit();
    }


    public static void createNewMailWindow() {
        WebElement createMailButton = baseTest.getDriver().findElement(By.xpath("//span[@class='compose-button__txt']"));
        createMailButton.click();
    }

    public static void openFirstMail () {
        WebElement draftSubject = baseTest.getDriver().findElement(By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']"));
        draftSubject.click();
    }
}