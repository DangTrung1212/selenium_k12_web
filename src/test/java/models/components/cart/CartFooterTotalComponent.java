package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCssSelector(value = ".cart-total")
public class CartFooterTotalComponent extends Component {
    private final By priceTypeSel = By.cssSelector(".cart-total-left");
    private final By priceValueSel = By.cssSelector(".cart-total-right");

    public CartFooterTotalComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Map<String, Double> priceCatalogs() {
        Map<String, Double> priceCatalogs = new HashMap<>();
        String priceType;
        double priceValue;
        List<WebElement> priceRows = element.findElements(By.tagName("tr"));
        for (WebElement priceRow : priceRows) {
            priceType = priceRow.findElement(priceTypeSel).getText().trim().replace(":", "");
            priceValue = Double.parseDouble(priceRow.findElement(priceValueSel).getText().trim());
            priceCatalogs.put(priceType, priceValue);
        }
        return priceCatalogs;
    }

}
