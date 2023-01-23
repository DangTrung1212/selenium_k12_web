package models.pages;

import models.components.cart.CartFooterComponent;
import models.components.cart.CartItemComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public List<CartItemComponent> cartItemComps() {
        return findComponents(driver, CartItemComponent.class);
    }
    public CartFooterComponent cartFooterComp() {
        return findComponent(driver, CartFooterComponent.class);
    }
}
