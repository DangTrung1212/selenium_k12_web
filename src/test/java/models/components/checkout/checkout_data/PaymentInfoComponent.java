package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import models.components.checkout.checkout_data.payment_info.CODComponent;
import models.components.checkout.checkout_data.payment_info.CreditCardInfoComponent;
import models.components.checkout.checkout_data.payment_info.MoneyOrderComponent;
import models.components.checkout.checkout_data.payment_info.PurchaseOrderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectHelper;
import test_data.payment_method.CreditCard;

@ComponentCssSelector(value = "#opc-payment_info")

public class PaymentInfoComponent extends StepCheckoutComponent {
//    Credit Card Selector

//    Purchase Order Selector


    public PaymentInfoComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public CreditCardInfoComponent creditCartInfoComp() {
        return new CreditCardInfoComponent(driver, element);
    }
    public PurchaseOrderComponent purchaseOrderComp() {
        return new PurchaseOrderComponent(driver, element);
    }
    public CODComponent codComp() {
        return new CODComponent(driver, element);
    }
    public MoneyOrderComponent moneyOrderComp() {
        return new MoneyOrderComponent(driver,element);
    }


}
