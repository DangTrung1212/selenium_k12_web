package models.loginpages;

import models.components.LoginComponent;
import org.openqa.selenium.WebDriver;

public class LoginPageMod3 {
    private final WebDriver driver;
    public LoginComponent loginComp;

    public LoginPageMod3(WebDriver driver) {
        this.driver = driver;
    }

    public LoginComponent loginComp() {
        return new LoginComponent(driver);
    }
}
