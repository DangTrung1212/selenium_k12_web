package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import urls.Urls;

public class JavascriptExecutor implements Urls {
    private final static WebDriver driver = DriverFactory.initDriver();
    public static void main(String[] args) throws InterruptedException {
        driver.get(indexUrl + dynamicControlSlug);
        try {
            WebElement inputEle = driver.findElement(By.cssSelector("#input-example input"));
//            casting
            org.openqa.selenium.JavascriptExecutor javascriptExecutor =
                    (org.openqa.selenium.JavascriptExecutor) driver;
            javascriptExecutor.executeScript(
                    "let inputEle = document.querySelector('#input-example input');" +
                            "inputEle.setAttribute('style', 'border: 2px solid red')");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
