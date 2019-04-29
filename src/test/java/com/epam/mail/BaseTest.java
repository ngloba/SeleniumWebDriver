package com.epam.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected final MailHelper mailHelper = new MailHelper(this);
    public ChromeDriver driver;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //Maximize browser window via optiona
        driver = new ChromeDriver(options);

        //Open web page
        driver.get("https://mail.ru/");
    }


    @AfterClass
    public void dtopBrowser() {
        driver.quit();
    }

    protected void login(String login, String password) {

        //box.selectByVisibleText("mail.ru");
        mailHelper.login(login, password);
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    protected void createNewMailWindow() {
        mailHelper.createNewMailWindow();
    }

    protected void openFirstMail() {
        mailHelper.openFirstMail();
    }


    protected void clickOnDraftFolder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/drafts/']")));
        WebElement draftFolder = driver.findElement(By.xpath("//a[@href='/drafts/']"));
        draftFolder.click();
    }

    protected String fillSubject(String newMailSubject) {
        WebElement subjectField = driver.findElement(By.xpath("//div[@class='subject__container--HWnat']//input[@class='container--H9L5q size_s--3_M-_']"));
                subjectField.sendKeys(newMailSubject);
        return newMailSubject;
    }

    protected void fillAddress(String newAddress) {
        WebElement addressField = driver.findElement(By.xpath("//label[@class='container--zU301']//input[@class='container--H9L5q size_s--3_M-_']"));
        addressField.sendKeys(newAddress);
    }

    protected void saveDraftMail() {
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='compose-app__buttons']/span[2]"));
        saveButton.click();
    }

    protected void closeNewMailWindow() {
        WebElement closeNewMailWindow = driver.findElement(By.xpath("//div[@class='compose-app__compose']/div[2]/div[2]//button[2]"));
        closeNewMailWindow.click();
    }

    protected void sendNewMail() {
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='compose-app__buttons']/span[1]"));
        saveButton.click();
    }

    protected void confirmSendingMail() {
        WebElement confirmSendingButton = driver.findElement(By.xpath("//div[@data-test-id='confirmation:empty-letter']//button[1]"));
        confirmSendingButton.click();
    }

    protected WebElement getSubject() {
        return driver.findElement(By.cssSelector("div[class*='js-tooltip-direction_letter-subject llc__item_title']"));
    }

    protected void clickOnSentFolder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/drafts/']")));
        WebElement sentFolder = driver.findElement(By.xpath("//a[@href='/sent/']"));
        sentFolder.click();
    }
}
