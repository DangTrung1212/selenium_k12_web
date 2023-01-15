package models.pages;

import models.components.Component;
import models.components.global.TopMenuComponent;
import models.components.global.footer.FooterComponent;
import models.components.product.homepage_product.ProductGridComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Component {
    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
    }

    public TopMenuComponent topMenuComp() {
        return findComponent(driver, TopMenuComponent.class);
    }
    public ProductGridComponent productGridComponent() {
        return findComponent(driver, ProductGridComponent.class);
    }
    public FooterComponent footerComp() {
        return findComponent(driver, FooterComponent.class);
    }
}
