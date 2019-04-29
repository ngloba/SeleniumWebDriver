package com.epam.mail.tests;

import com.epam.mail.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendingMailFromDraftTest extends BaseTest {

    @Test
    public void sendingMailFromDraftTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("nataliia.globa@mail.ru", "TestTest753");
        clickOnDraftFolder();

        Thread.sleep(1000);
        String subjectBefore = getSubject().getAttribute("title");
//        WebElement firstMail = driver.findElement(By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']"));
//        firstMail.click();
        openFirstMail();
        sendNewMail();
        //Thread.sleep(1000);
        //driver.switchTo().alert().accept();
        confirmSendingMail();
     Thread.sleep(10000);

        String subjectAfter = getSubject().getAttribute("title");

        Assert.assertNotEquals(subjectBefore, subjectAfter);


    }

}
