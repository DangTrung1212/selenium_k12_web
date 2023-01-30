package models.components.checkout.checkout_data.payment_info;

import models.components.checkout.checkout_data.PaymentInfoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CODComponent extends PaymentInfoComponent {
    private final static By infoSel = By.cssSelector(".info");
    private final static String message = "You will pay by COD";
    public CODComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void verifyMessage() {
        Assert.assertEquals(message, findElement(infoSel).getText(),"[ERR] Message of COD is not matched. ");
    }

}
