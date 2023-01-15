package models.components.global.footer;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterColumnComponent extends Component {
    private final By headerSel = By.tagName("h3");
    private final By linkSel = By.cssSelector("li a");
    FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public WebElement headerEle() {
        return element.findElement(headerSel);
    }
    public List<WebElement> linksEle() {
        return element.findElements(linkSel);
    }
}
