package com.epam.mail.tests;

import com.epam.mail.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

@Test
    public void loginTest() {
    mailHelper.login("nataliia.globa", "TestTest753");

    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("PH_user-email")));
    WebElement  loginMail= driver.findElement(By.id("PH_user-email"));
    String result = loginMail.getAttribute("innerText");

    Assert.assertTrue(result.equals("nataliia.globa@mail.ru"));

    }

}
