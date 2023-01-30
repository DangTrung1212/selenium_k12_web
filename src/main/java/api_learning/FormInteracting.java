package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;

public class FormInteracting {
    private static final WebDriver driver = DriverFactory.initChromeDriver();

    public static void main(String[] args) {
        driver.get("https://the-internet.herokuapp.com/login");
        try {
            login("#username", "#password", "button[type='submit']");
        } catch (Exception event) {
            event.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();
//        need to find element again => DOM changed
        login("#username", "#password", "button[type='submit']");
    }

    public static void login(String userNameSelector, String passWordSelector, String submitLocator) {
        WebElement userNameInput = driver.findElement(By.cssSelector(userNameSelector));
        WebElement passWordInput = driver.findElement(By.cssSelector(passWordSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitLocator));
        userNameInput.sendKeys("Abc");
        passWordInput.sendKeys("123456");
        submitButton.click();
    }
}
