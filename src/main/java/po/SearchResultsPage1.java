package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage1 extends AbstractPage1 {
    public static final By FIRST_RESULT_LINK_LOCATOR = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    public SearchResultsPage1(WebDriver driver) {
        super(driver);
    }

    public ItemPage1 openFirstItem () {
        waitForElementVisible(FIRST_RESULT_LINK_LOCATOR);
        driver.findElement(FIRST_RESULT_LINK_LOCATOR).click();
        return new ItemPage1(driver);
    }
}
