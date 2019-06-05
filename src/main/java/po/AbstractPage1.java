package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage1 {
    protected WebDriver driver;
    public static final int WAIT_FOR_ELEMENTS_SECONDS = 10;

    public AbstractPage1(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisible (By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENTS_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
