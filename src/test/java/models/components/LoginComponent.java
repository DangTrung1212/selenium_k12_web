package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginComponent {
    private final WebDriver driver;
    private By userNameSel;
    private By passWordSel;
    private By submitBtn;

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
