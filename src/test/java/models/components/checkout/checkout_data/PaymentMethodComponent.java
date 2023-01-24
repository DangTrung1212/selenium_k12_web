package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-payment_method")
public class PaymentMethodComponent extends Component {
    public PaymentMethodComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
