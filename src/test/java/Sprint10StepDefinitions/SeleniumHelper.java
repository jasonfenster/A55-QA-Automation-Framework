package Sprint10StepDefinitions;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class SeleniumHelper {
    private static WebDriver driver;

    public static void initialize(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(":arguments[0].click();", element);
    }
    }
}
