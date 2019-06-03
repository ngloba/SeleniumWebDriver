package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AbstractPage {
    public static final By FIRST_RESULT_LINK_LOCATOR = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ItemPage openFirstItem () {
        waitForElementVisible(FIRST_RESULT_LINK_LOCATOR);
        driver.findElement(FIRST_RESULT_LINK_LOCATOR).click();
        return new ItemPage(driver);
    }
}
