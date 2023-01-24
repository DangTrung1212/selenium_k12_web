package models.pages.checkout_page;

import models.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionPage extends BasePage {
    private final By checkoutAsGuestBtnSel = By.cssSelector(".checkout-as-guest-button");
    public CheckoutOptionPage(WebDriver driver) {
        super(driver);
    }
    public void clickCheckoutAsGuestBtn() {
        element.findElement(checkoutAsGuestBtnSel).click();
    }
}
