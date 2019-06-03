package com.epam.mail.tests;

import com.epam.mail.BaseTest;
import com.epam.mail.MailHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewMailCreationTest extends BaseTest {

    @Test
    public void newMailCreationTest() throws InterruptedException {
        MailHelper.login("nataliia.globa", "TestTest753");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  //      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='compose-button__txt']")));
        createNewMailWindow();
        fillAddress("nataliia.globa@mail.ru");
        String newMailSubject = fillSubject( "New Test Mail 5");

        // WebElement bodyField = driver.findElement(By.cssSelector("div[class*='cke_editable cke_editable_inline cke_contents_true cke_show_borders']"));
        //WebElement bodyField = driver.findElement(By.cssSelector("div[class^='editable-container'] div div"));
        WebElement bodyField = driver.findElement(By.xpath("//div[contains(@class, 'editable-') and contains(@class, 'cke_')]"));
         bodyField.click();
           bodyField.sendKeys("Bla Bla Bla");
        saveDraftMail();


        closeNewMailWindow();

        // WebElement draftFolder = driver.findElement(By.cssSelector("a.nav__item js-shortcut nav__item_active nav__item_shortcut"));
//       WebElement draftFolder = driver.findElement(By.linkText("/drafts/"));
//        WebElement draftFolder = driver.findElement(By.xpath("//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut']"));
//        WebElement draftFolder = driver.findElement(By.xpath("//nav[@class='nav nav_expanded nav_hover-support']//a[5]//div[@class='nav__folder-name__txt']"));
        clickOnDraftFolder();

      Thread.sleep(1000);


      //  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']")));
        WebElement draftSubject = getSubject();

        String result = draftSubject.getAttribute("title");

      //  Assert.assertEquals(result, newMailSubject);
        Assert.assertTrue(result.equals(newMailSubject));


    }

}
