package api_learning;


import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class ElementDisplaying {
    private static final WebDriver driver = DriverFactory.initChromeDriver();

    public static void main(String[] args) {
        driver.get("https://the-internet.herokuapp.com/login");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out
                .println("Check if it displaying: "
                        + isElementDisplayingByFindElements("img[alt='Fork me on GitHub']"));
        System.out.println("Check if it displaying: "
                + isElementDisplayingByTryCatch("img[alt='Fork me on GitHub']"));
        driver.close();
    }

    public static boolean isElementDisplayingByFindElements(String cssSelector) {
        List<WebElement> listOfElement = driver.findElements(By.cssSelector(cssSelector));
        return !listOfElement.isEmpty();
    }

    public static boolean isElementDisplayingByTryCatch(String cssSelector) {
        WebElement investigatingElement = null;
        try {
            investigatingElement = driver.findElement(By.cssSelector(cssSelector));
        } catch (NoSuchElementException ignored) {
        }
        return investigatingElement != null;
    }
}

