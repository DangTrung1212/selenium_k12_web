package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import urls.Urls;

import java.time.Duration;

public class CheckBoxAndInputStatus implements Urls {
    private static final WebDriver driver = DriverFactory.initChromeDriver();
    private static final By checkBoxExampleSel = By.cssSelector("#checkbox-example");
    private static final By inputExampleSel = By.cssSelector("#input-example");

    public static void main(String[] args) {
        driver.get(indexUrl + dynamicControlSlug);
        try {
            WebElement checkBoxExampleEle = driver.findElement(checkBoxExampleSel);
            WebElement checkBoxELe = checkBoxExampleEle.findElement(By.cssSelector("input"));
            WebElement inputExampleEle = driver.findElement(inputExampleSel);
            WebElement textInputELe = inputExampleEle.findElement(By.cssSelector("input"));

            WebElement inputStatusBtn = inputExampleEle.findElement(By.cssSelector("button"));
//            Tick checkbox if not selected
            if (!checkBoxELe.isSelected()) checkBoxELe.click();
//            Enable text input
            if (!textInputELe.isEnabled()) {
                inputStatusBtn.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//
//
//              Solution 1:
/**             wait.until(ExpectedConditions.attributeToBe(
*                      textInputELe, "disabled", "")); // value = "false" or "null" can't match
*
*               System.out.println(textInputELe.getAttribute("disabled")); //log: null https://prnt.sc/eh43gThXSIMy
 *               "true" https://prnt.sc/tiajDqsRLula
**/
//              Solution 2:
//                wait.until(ExpectedConditionEX.elementIsEnabled(textInputELe));
                System.out.println(textInputELe.getAttribute("disabled"));
                textInputELe.sendKeys("Trash life");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        driver.quit();
    }
}
