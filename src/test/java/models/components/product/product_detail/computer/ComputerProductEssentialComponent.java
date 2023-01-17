package models.components.product.product_detail.computer;

import models.components.product.product_detail.ProductEssentialComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;

public abstract class ComputerProductEssentialComponent extends ProductEssentialComponent {
    public ComputerProductEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    abstract public String selectProcessor(String processorType);
    abstract public String selectRam(String ramType);
    abstract public String selectHDD(String hDDType);
}
