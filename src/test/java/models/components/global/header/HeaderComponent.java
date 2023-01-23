package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.ScrollAction;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {
    private final By topCartLinkSel = By.cssSelector("#topcartlink");
    public HeaderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void clickOnShoppingCart() {
        WebElement topCartLink = element.findElement(topCartLinkSel);
        ScrollAction.scrollToElement(topCartLink, driver);
        topCartLink.click();
    }

}
