package models.pages.checkout_page;

import models.components.checkout.CheckoutDataComponent;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutDataComponent checkoutDataComp() {
        return findComponent(driver, CheckoutDataComponent.class);
    }
}
