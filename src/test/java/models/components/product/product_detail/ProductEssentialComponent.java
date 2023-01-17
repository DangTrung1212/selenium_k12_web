package models.components.product.product_detail;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = ".product-essential")
public abstract class ProductEssentialComponent extends Component {
    public ProductEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

}
