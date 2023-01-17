package models.components.product.product_detail.computer;

import models.components.product.product_detail.ProductEssentialComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerProductEssentialComponent extends ProductEssentialComponent {
    public ComputerProductEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    abstract public void selectProcessor();
    abstract public void selectRam();


}
