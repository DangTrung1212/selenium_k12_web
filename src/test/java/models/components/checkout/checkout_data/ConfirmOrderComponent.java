package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-confirm_order")
public class ConfirmOrderComponent extends Component {
    public ConfirmOrderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
