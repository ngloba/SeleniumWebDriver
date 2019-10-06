package com.epam.po.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class NewBaseTest {

    public WebDriver driver;

    @BeforeClass
    public void initBrowser () {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
