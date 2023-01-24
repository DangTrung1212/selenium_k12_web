package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentXpathSelector(value = "#opc-shipping_method")
public class ShippingMethodComponent extends Component {
    public ShippingMethodComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
