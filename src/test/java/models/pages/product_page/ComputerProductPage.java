package models.pages.product_page;

import models.components.product.product_detail.computer.ComputerProductCenterComponent;
import org.openqa.selenium.WebDriver;

public class ComputerProductPage<T extends ComputerProductCenterComponent> extends BaseProductPage{
    public ComputerProductPage(WebDriver driver) {
        super(driver);
    }
    public T computerProductCenterComp(Class<T> computerProductCenterCompClass) {
        return findComponent(driver, computerProductCenterCompClass);
    }

}
