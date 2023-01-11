package models.pages;

import models.components.Component;
import models.components.global.footer.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Component {
    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
    }
    public FooterComponent footerComp() {
        return findComponent(driver, FooterComponent.class);
    }
}
