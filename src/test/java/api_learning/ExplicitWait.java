package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExpectedConditionEX;
import urls.Urls;

import java.time.Duration;

public class ExplicitWait implements Urls {
    private static final WebDriver driver = DriverFactory.initDriver();
    public static void main(String[] args) {
        try {
            driver.get(indexUrl);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditionEX.MoreThanOneTab());
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
