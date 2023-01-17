package models.components.product.product_detail.computer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandardComputerEssentialComponent extends ComputerProductEssentialComponent {
    public StandardComputerEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    @Override
    public String selectProcessor(String processorType) {
        return null;
    }

    @Override
    public String selectRam(String ramType) {
        return null;
    }

    @Override
    public String selectHDD(String hDDType) {
        return null;
    }


}
