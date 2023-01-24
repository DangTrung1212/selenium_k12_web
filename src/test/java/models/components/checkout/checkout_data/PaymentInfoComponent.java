package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = "#opc-payment_info")

public class PaymentInfoComponent extends Component {
    public PaymentInfoComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
