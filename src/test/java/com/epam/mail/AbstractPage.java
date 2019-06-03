package com.epam.mail;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
protected WebDriver driver;
public static final int WAIT_FOR_ELEMENT_SECONDS = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
