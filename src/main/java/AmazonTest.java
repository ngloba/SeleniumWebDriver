import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import po.HomePage1;
import po.ItemPage1;
import po.SearchResultsPage1;

import java.util.concurrent.TimeUnit;

public class AmazonTest {
    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    private void initBrowser () {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Amazon search test")
    public void amazonSearchTest () {
        HomePage1 homePage = new HomePage1(driver);
        homePage.open();
        homePage.fillSearchInput("Iphon SE");
        SearchResultsPage1 searchResultsPage = homePage.pressGo();
        ItemPage1 itemPage = searchResultsPage.openFirstItem();
        Double iphonePrice = itemPage.getItemPrice();
        Assert.assertTrue(iphonePrice < 200, "Iphone SE costs more than $200");


    }

    @AfterClass(description = "close browser")
    public void kill(){
        driver.quit();
    }
}
