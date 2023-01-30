package models.components.checkout.checkout_data.payment_info;

import models.components.checkout.checkout_data.PaymentInfoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOrderComponent extends PaymentInfoComponent {
    private static final By purchaseNumSel = By.cssSelector("#PurchaseOrderNumber");
    public PurchaseOrderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void inputPurchaseNum(String number){
        element.findElement(purchaseNumSel).sendKeys(number);
    }
}
