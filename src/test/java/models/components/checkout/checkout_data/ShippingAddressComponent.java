package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = "#opc-shipping")
public class ShippingAddressComponent extends StepCheckoutComponent {
    private final static By continueBtnSel = By.cssSelector(".new-address-next-step-button");
    public ShippingAddressComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
