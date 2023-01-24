package models.components.checkout.checkout_data;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectHelper;

@ComponentCssSelector(value = "#opc-billing")
public class BillAddressComponent extends Component {
    private final static By inputAddressDropdownSel = By.id("billing-address-select");
    private final static By firstnameSel = By.id("BillingNewAddress_FirstName");
    private final static By lastnameSel = By.id("BillingNewAddress_LastName");
    private final static By emailSel = By.id("BillingNewAddress_Email");
    private final static By selectCountryDropdownSel = By.id("BillingNewAddress_CountryId");
    private final static By selectStateDropdownSel = By.id("BillingNewAddress_StateProvinceId");
    private final static By loadingStateProgressBarSel = By.id("states-loading-progress");
    private final static By citySel = By.id("BillingNewAddress_City");
    private final static By add1Sel = By.id("BillingNewAddress_Address1");
    private final static By zipCodeSel = By.id("BillingNewAddress_ZipPostalCode");
    private final static By phoneNoSel = By.id("BillingNewAddress_PhoneNumber");
    private final static By continueBtnSel = By.cssSelector(".new-address-next-step-button");
    private final static By pleaseWaitSel = By.cssSelector("#billing-please-wait");
    public BillAddressComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void inputFirstname(String firstname) {
        element.findElement(firstnameSel).sendKeys(firstname);
    }
    public void inputLastname(String lastname) {
        element.findElement(lastnameSel).sendKeys(lastname);
    }
    public void inputEmail(String email) {
        element.findElement(emailSel).sendKeys(email);
    }
    public void inputCountry(String country) {
        WebElement dropdownCountry = element.findElement(selectCountryDropdownSel);
        Select select = new Select(dropdownCountry);
        select.selectByVisibleText(country);
        wait.until(driver -> !driver.findElement(loadingStateProgressBarSel).isDisplayed()
        );
    }
    public void inputState(String state) {
        WebElement dropdownState = element.findElement(selectStateDropdownSel);
        Select select = new Select(dropdownState);
        select.selectByVisibleText(state);
    }
    public void inputCity(String city) {
        element.findElement(citySel).sendKeys(city);
    }
    public void inputAddress1(String address1) {
        element.findElement(add1Sel).sendKeys(address1);
    }
    public void inputZipcode(String zipcode) {
        element.findElement(zipCodeSel).sendKeys(zipcode);
    }
    public void inputPhoneNum(String phoneNo) {
        element.findElement(phoneNoSel).sendKeys(phoneNo);
    }
    public void clickOnContinueBtn() {
        element.findElement(continueBtnSel).click();
        wait.until(driver -> !driver.findElement(pleaseWaitSel).isDisplayed());
    }
    public void handleAddressDropdownAppear() {
        if(!element.findElements(inputAddressDropdownSel).isEmpty()) {
            SelectHelper.selectDropDownOption(element, "New Address");
        }
    }
}
