package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import urls.Urls;

import java.time.Duration;

public class AlertHandler implements Urls {
    private static final WebDriver driver = DriverFactory.initChromeDriver();
    private static final By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private static final By jsAlertConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private static final By jsAlertPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");

    public static void main(String[] args) {
        driver.get(indexUrl + jsAlertsSlug);
        WebElement jsAlert;
        try {
//            check alert
            jsAlert = driver.findElement(jsAlertSel);
            jsAlert.click();
            handleAlert(driver,true);
//            check confirm alert
            jsAlert = driver.findElement(jsAlertConfirmSel);
            jsAlert.click();
            handleAlert(driver, false);
//            check input alert
            jsAlert = driver.findElement(jsAlertPromptSel);
            jsAlert.click();
            handleAlert(driver, true, "Im hero");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static Alert getAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void handleAlert(WebDriver driver, boolean isConfirmed) {
        Alert alert = getAlert(driver);
        System.out.println(alert.getText());
        if (isConfirmed) alert.accept();
        else alert.dismiss();
    }

    public static void handleAlert(WebDriver driver, boolean isConfirmed, String inputText) {
        Alert alert = getAlert(driver);
        System.out.println(alert.getText());
        if (isConfirmed) {
            alert.sendKeys(inputText);
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
}
