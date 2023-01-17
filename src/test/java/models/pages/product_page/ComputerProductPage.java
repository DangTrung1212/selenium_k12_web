package models.pages.product_page;

import models.components.product.product_detail.computer.ComputerProductEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerProductPage<T extends ComputerProductEssentialComponent> extends BaseProductPage{
    public ComputerProductPage(WebDriver driver) {
        super(driver);
    }
    public T computerProductEssentialComp(Class<T> computerProductCenterCompClass) {
        return findComponent(driver, computerProductCenterCompClass);
    }

}
