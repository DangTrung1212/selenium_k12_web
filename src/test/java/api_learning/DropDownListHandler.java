package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import urls.Urls;

public class DropDownListHandler implements Urls {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.initDriver();
        try {
            driver.get(indexUrl + dropdownSlug);
            WebElement dropDownElement = driver.findElement(By.cssSelector("#dropdown"));
            Select select = new Select(dropDownElement);
            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);
            select.selectByIndex(2);
            Thread.sleep(1000);
            select.selectByValue("1");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
