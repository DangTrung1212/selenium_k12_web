package models.pages;

import models.components.register.RegisterComponent;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public RegisterComponent registerComp() {
        return findComponent(driver, RegisterComponent.class);
    }
}
