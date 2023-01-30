package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = ".cart-footer")
public class CartFooterComponent extends Component {
    public CartFooterComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public CartFooterTotalComponent cartFooterTotalComp() {
        return findComponent(driver, CartFooterTotalComponent.class);
    }



}
