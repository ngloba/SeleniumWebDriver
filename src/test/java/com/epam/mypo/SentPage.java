package com.epam.mypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentPage extends AbstractPage{

    public static final By FIRST_MAIL_LOCATOR = By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']");

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public String getSubjectFromSent (){
        return driver.findElement(FIRST_MAIL_LOCATOR).getAttribute("title");
    }

}


