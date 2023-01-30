package models.components.checkout.checkout_data.payment_info;

import models.components.checkout.checkout_data.PaymentInfoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MoneyOrderComponent extends PaymentInfoComponent {
    private final static By infoSel = By.cssSelector(".info");
    private final static String message = "Tricentis GmbH\n" +
            "Leonard-Bernstein-Straße 10\n" +
            "1220 Vienna\n" +
            "Austria";
    public MoneyOrderComponent(WebDriver driver, WebElement element) {
        super(driver, element);

    }
    public void verifyMessage() {
        String actualMessage = findElement(infoSel).getText();
        Assert.assertTrue(actualMessage.contains(message));
    }
}
