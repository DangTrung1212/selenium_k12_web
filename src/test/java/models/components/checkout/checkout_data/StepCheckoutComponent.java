package models.components.checkout.checkout_data;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepCheckoutComponent extends Component {
    private final static By continueBtnSel = By.cssSelector("input[value=\"Continue\"]");
    private final static By pleaseWaitSel = By.cssSelector(".please-wait");
    public StepCheckoutComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void clickOnContinueBtn() {
        element.findElement(continueBtnSel).click();
        wait.until(driver -> !driver.findElement(pleaseWaitSel).isDisplayed());
    }
}
