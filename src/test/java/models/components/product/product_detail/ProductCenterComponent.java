package models.components.product.product_detail;

import models.components.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ProductCenterComponent extends Component {
    public ProductCenterComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

}
