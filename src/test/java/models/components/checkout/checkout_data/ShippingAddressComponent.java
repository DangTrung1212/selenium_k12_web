package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentXpathSelector(value = "#opc-shipping")
public class ShippingAddressComponent extends Component {
    public ShippingAddressComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
