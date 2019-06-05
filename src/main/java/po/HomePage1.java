package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage1 extends AbstractPage1 {
    private static final By SEARCH_INPUT_LOCATOR = By.cssSelector("#twotabsearchtextbox");
    private static final By GO_BUTTON_SEARCH = By.xpath("//input[@value='Go']");
    private static final String URL = "https://www.amazon.com/";

    public HomePage1(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void fillSearchInput(String query) {
        waitForElementVisible(SEARCH_INPUT_LOCATOR);
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(query);
    }

    public SearchResultsPage1 pressGo () {
        driver.findElement(GO_BUTTON_SEARCH).click();
        return new SearchResultsPage1(driver);
    }
}
