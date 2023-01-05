package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteracting {
    private static final WebDriver driver = DriverFactory.initDriver();
    public static void main(String[] args) {
        driver.get("https://the-internet.herokuapp.com/login");
        login("#username", "#password","button[type='submit']");
        driver.navigate().refresh();
    }
    public static void login(String userNameSelector, String passWordSelector, String submitLocator) {
        WebElement userNameInput= driver.findElement(By.cssSelector(userNameSelector));
        WebElement passWordInput = driver.findElement(By.cssSelector(passWordSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitLocator));
        userNameInput.sendKeys("Abc");
        passWordInput.sendKeys("123456");
        submitButton.click();
    }
}
