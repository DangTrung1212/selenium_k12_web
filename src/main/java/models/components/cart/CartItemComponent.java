package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".cart-item-row")
public class CartItemComponent extends Component {
    private final By unitPriceSel = By.cssSelector(".product-unit-price");
    private final By qtySel = By.cssSelector(".qty-input");
    private final By productSubtotalSel = By.cssSelector(".product-subtotal");
    public CartItemComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public double unitPrice() {
        return Double.parseDouble(element.findElement(unitPriceSel).getText().trim());
    }
    public double totalItemPrice() {
        return Double.parseDouble(element.findElement(productSubtotalSel).getText().trim());
    }
    public int qty() {
        return Integer.parseInt(element.findElement(qtySel).getAttribute("value"));
    }
}
