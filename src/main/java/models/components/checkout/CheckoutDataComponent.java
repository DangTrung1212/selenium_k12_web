package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.checkout.checkout_data.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = ".checkout-data")
public class CheckoutDataComponent extends Component {
    public CheckoutDataComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public BillAddressComponent billAddressComp() {
        return findComponent(driver, BillAddressComponent.class);
    }
    public ShippingAddressComponent shippingAddressComp() {
        return findComponent(driver, ShippingAddressComponent.class);
    }
    public ShippingMethodComponent shippingMethodComp() {
        return findComponent(driver, ShippingMethodComponent.class);
    }
    public PaymentMethodComponent paymentMethodComp() {
        return findComponent(driver, PaymentMethodComponent.class);
    }
    public PaymentInfoComponent paymentInfoComp() {
        return findComponent(driver, PaymentInfoComponent.class);
    }
    public ConfirmOrderComponent confirmOrderComp() {
        return findComponent(driver, ConfirmOrderComponent.class);
    }
}
