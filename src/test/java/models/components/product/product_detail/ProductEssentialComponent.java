package models.components.product.product_detail;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.ui.ScrollAction;

@ComponentCssSelector(value = ".product-essential")
public abstract class ProductEssentialComponent extends Component {
    private final By barNotificationSel = By.cssSelector("#bar-notification");
    private final By productPriceSel = By.cssSelector(".product-price");
    private final By addToCartSel = By.cssSelector(".add-to-cart-button");
    public ProductEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public double productPrice() {
        return Double.parseDouble(findElement(productPriceSel).getText());
    }
    public void clickAddToCartBtn() {
        WebElement addToCartBtn = findElement(addToCartSel);
        ScrollAction.scrollToElement(addToCartBtn, driver);
        addToCartBtn.click();
    }
    private void waitUntilSuccessAddToCartMsg() {
        String successAddToCartMsg = "The product has been added to your shopping cart";
        WebElement barNotification = findElement(barNotificationSel);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(barNotification, successAddToCartMsg));
        } catch (Exception e) {
            e.printStackTrace();
            clickAddToCartBtn();
        }
    }


}
