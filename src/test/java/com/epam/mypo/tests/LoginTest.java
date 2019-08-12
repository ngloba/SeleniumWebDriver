package com.epam.mypo.tests;

import com.epam.mypo.HomePage;
import com.epam.mypo.InboxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillLogin("nataliia.globa", "TestTest753");
        InboxPage inboxPage = homePage.pressLogin();
       String result = inboxPage.getLoginMail();
        Assert.assertTrue(result.equals("nataliia.globa@mail.ru"));

    }
}
