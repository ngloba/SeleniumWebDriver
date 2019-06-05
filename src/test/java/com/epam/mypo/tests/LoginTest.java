package com.epam.mypo.tests;

import com.epam.mypo.HomePage;
import com.epam.mypo.InboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import po.HomePage1;

public class LoginTest extends BaseTest{
    private WebDriver driver;
    @Test
    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillLogin("nataliia.globa", "TestTest753");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("PH_user-email")));
        InboxPage inboxPage = homePage.pressLogin();

 //       WebElement loginMail= driver.findElement(By.id("PH_user-email"));
        String result = inboxPage.getLoginMail();

        Assert.assertTrue(result.equals("nataliia.globa@mail.ru"));

    }
}
