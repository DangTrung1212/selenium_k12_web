package models.components.checkout.checkout_data;

import driver.DriverFactory;
import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-confirm_order")
public class ConfirmOrderComponent extends StepCheckoutComponent {
    public ConfirmOrderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    @Deprecated
    @Override
    public void clickOnContinueBtn() {
    }
}

