package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.ComponentXpathSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectHelper;

@ComponentCssSelector(value = "#opc-shipping_method")
public class ShippingMethodComponent extends StepCheckoutComponent {
    private final By shippingMethodsSel = By.cssSelector(".method-list");

    public ShippingMethodComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public String selectShippingMethod(String shippingMethod) {
        WebElement shippingMethodEle = element.findElement(shippingMethodsSel);
        return SelectHelper.selectRadioBtn(shippingMethodEle, shippingMethod, true);
    }
}
