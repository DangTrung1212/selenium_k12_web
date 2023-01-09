package models.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseLoginPage {
    public WebDriver driver;

    public BaseLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract WebElement userName();

    public abstract WebElement passWord();

    public abstract WebElement submitBtn();
}
