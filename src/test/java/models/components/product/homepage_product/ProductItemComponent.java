package models.components.product.homepage_product;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".item-box")
public class ProductItemComponent extends Component {
    private final By priceSel = By.cssSelector(".price.actual-price");
    private final By titleSel = By.cssSelector(".product-title");

    public ProductItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement titleEle() {
        return component.findElement(titleSel);
    }

    public WebElement priceEle() {
        return component.findElement(priceSel);
    }
}
