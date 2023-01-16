package models.components.product.product_detail.computer;

import models.components.product.product_detail.ProductCenterComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerProductCenterComponent extends ProductCenterComponent {
    public ComputerProductCenterComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    abstract public void selectProcessor();
    abstract public void selectRam();


}
