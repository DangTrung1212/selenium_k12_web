package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import urls.Urls;

public class IframeHandler implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.initChromeDriver();
        try {
            driver.get(indexUrl+iframeSlug);
            WebElement iframeElement = driver.findElement(By.cssSelector("[id$='ifr']"));
            driver.switchTo().frame(iframeElement);
            WebElement iframeTextBox = driver.findElement(By.cssSelector("body"));
            iframeTextBox.click();
            iframeTextBox.clear();
            iframeTextBox.sendKeys("ABC");
            Thread.sleep(1000);
            driver.switchTo().defaultContent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
