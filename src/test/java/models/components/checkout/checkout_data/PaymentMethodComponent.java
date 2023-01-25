package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;
import test_data.payment_method.PaymentMethod;

@ComponentCssSelector(value = "#opc-payment_method")
public class PaymentMethodComponent extends StepCheckoutComponent {
    public PaymentMethodComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public String selectPaymentMethod(PaymentMethod paymentMethod) {
        return SelectHelper.selectRadioBtn(element,paymentMethod.getPaymentMethodString(), true);
    }
}
