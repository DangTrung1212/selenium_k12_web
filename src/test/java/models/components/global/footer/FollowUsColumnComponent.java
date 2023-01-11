package models.components.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "")
public class FollowUsColumnComponent extends FooterColumnComponent{
    public FollowUsColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
