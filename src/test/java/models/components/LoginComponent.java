package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector("#login")
public class LoginComponent {
    private final WebDriver driver;
    private final By userNameSel = By.cssSelector("#username");
    private final By passWordSel =By.cssSelector("#password");
    private final By submitBtn = By.cssSelector("button[type='submit']");

    public LoginComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userName() {
        return driver.findElement(userNameSel);
    }

    public WebElement passWord() {
        return driver.findElement(passWordSel);
    }

    public WebElement submitBtn() {
        return driver.findElement(submitBtn);
    }
}
