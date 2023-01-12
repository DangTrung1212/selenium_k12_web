package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import urls.Urls;

import java.util.List;

public class HoverAndNarrowDownHandler implements Urls {
    private static final WebDriver driver = DriverFactory.initChromeDriver();
    private static final By figureSel = By.cssSelector(".figure");
    private static final By figCaptionNameSel = By.cssSelector(".figcaption h5");
    private static final By figCaptionLinkSel = By.cssSelector(".figcaption a");


    public static void main(String[] args) {
        driver.get(indexUrl + hoverSlug);
        Actions actions = new Actions(driver);
        try {
            List<WebElement> figureElements = driver.findElements(figureSel);
            if (figureElements.isEmpty()) {
                throw new Exception("Cant find list of element");
            } else {
                for (WebElement figureElement : figureElements) {
                    WebElement figCationNameEle = figureElement.findElement(figCaptionNameSel);
                    WebElement figCaptionLinkEle = figureElement.findElement(figCaptionLinkSel);
                    System.out.println("Before Hover");
                    System.out.println("is figCaptionNameEle displayed: " + figCationNameEle.isDisplayed());
                    System.out.println("is figCaptionLinkEle displayed: " + figCaptionLinkEle.isDisplayed());
//                    Hover
                    System.out.println("After hover");
                    actions.moveToElement(figureElement).perform();
                    System.out.println("is figCaptionNameEle displayed: " + figCationNameEle.isDisplayed());
                    System.out.println("is figCaptionLinkEle displayed: " + figCaptionLinkEle.isDisplayed());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
