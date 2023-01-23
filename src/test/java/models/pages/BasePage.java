package models.pages;

import models.components.Component;
import models.components.global.TopMenuComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.header.HeaderComponent;
import models.components.product.homepage_product.ProductGridComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Component {
    private final By pageTitleSel = By.cssSelector(".page-title");
    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
    }
    public HeaderComponent headerComp() {
        return findComponent(driver, HeaderComponent.class);
    }
    public String pageTitle() {
        return findElement(pageTitleSel).getText();
    }
    public TopMenuComponent topMenuComp() {
        return findComponent(driver, TopMenuComponent.class);
    }

    public FooterComponent footerComp() {
        return findComponent(driver, FooterComponent.class);
    }
}
