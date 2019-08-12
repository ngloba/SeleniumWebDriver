package com.epam.mypo.tests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;


    @BeforeClass(description = "Start browser")
    public void initBrowser () {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
       driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();

    }

//base


    @AfterClass(description = "close browser")
    public void kill(){
        driver.quit();
    }
}
