package com.epam.bonus;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BananaSongTests {
    public FirefoxDriver driver;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\data\\temp\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test
    public void youTubeIsOpenTest () {
        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchField.sendKeys("Banana Song");
        WebElement submitButton = driver.findElementByXPath("//div[@class='FPdoLc VlcLAe']/center/input[1]");
        submitButton.click();
        WebElement songLink = driver.findElement(By.xpath("//a[contains(@href,'youtube.com')]/h3[contains(text(),'Despicable Me')]"));
        songLink.click();

        String pageTitle = driver.getCurrentUrl();
        boolean pageResult = pageTitle.matches("^https://www.youtube.com/.*$");
        Assert.assertTrue(pageResult);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='view-count style-scope yt-view-count-renderer']")));
        WebElement viewCount = driver.findElement(By.xpath("//span[@class='view-count style-scope yt-view-count-renderer']"));
        String text = viewCount.getText();
        int count = Integer.parseInt(text.replaceAll("\\D+",""));
        boolean result = count > 50000000;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void closeBrowser () {
        driver.quit();
    }
}
