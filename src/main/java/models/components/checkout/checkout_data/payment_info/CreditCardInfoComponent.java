package models.components.checkout.checkout_data.payment_info;

import models.components.checkout.checkout_data.PaymentInfoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectHelper;
import test_data.payment_method.CreditCard;

public class CreditCardInfoComponent extends PaymentInfoComponent {
    private static final By creditCardDropdownSel = By.cssSelector("#CreditCardType");
    private static final By cardHolderNameSel = By.cssSelector("#CardholderName");
    private static final By cardNumberSel = By.cssSelector("#CardNumber");
    private static final By cardExpiredMonthDropdownSel = By.cssSelector("#ExpireMonth");
    private static final By cardExpiredYearDropdownSel = By.cssSelector("#ExpireYear");
    private static final By cardCodeSel = By.cssSelector("#CardCode");
    public CreditCardInfoComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void selectCreditCard(CreditCard creditCard) {
        WebElement creditCardDropdown = element.findElement(creditCardDropdownSel);
        SelectHelper.selectDropDownOption(creditCardDropdown, creditCard.getCreditCardStr());
    }
    public void inputCardHolderName(String name){
        element.findElement(cardHolderNameSel).sendKeys(name);
    }

    public void inputCardNumber(String number){
        element.findElement(cardNumberSel).sendKeys(number);
    }

    public void inputExpiredMonth(String month){
        Select select = new Select(element.findElement(cardExpiredMonthDropdownSel));
        select.selectByValue(month);
    }

    public void inputExpiredYear(String year){
        Select select = new Select(element.findElement(cardExpiredYearDropdownSel));
        select.selectByVisibleText(year);
    }

    public void inputCardCode(String code){
        element.findElement(cardCodeSel).sendKeys(code);
    }

}
