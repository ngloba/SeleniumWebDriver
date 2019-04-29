package com.epam.cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverMVNSearchTest {

    private WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //Maximize browser window via optiona
        driver = new ChromeDriver(options);

        //Open web page
        driver.get("https://mvnrepository.com/");
    }

    @Test
    public void serachDependency()  {

        WebElement mvnSearch = driver.findElement(By.id("query"));
        mvnSearch.sendKeys("selenium java");
        WebElement mvnSearchButton = driver.findElement(By.className("button"));
        mvnSearchButton.click();
        WebElement mvnSearchResult = driver.findElement(By.xpath("//div[@class='im-header']//h2[@class='im-title']/a[text()='Selenium Java']"));

        //Setting standart timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(mvnSearchResult.isDisplayed(), "No results found");


    }

    @AfterClass
    public void dtopBrowser() {
        driver.quit();
        System.out.println("Browser was closed");
    }
}
