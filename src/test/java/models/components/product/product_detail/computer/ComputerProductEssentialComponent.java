package models.components.product.product_detail.computer;

import models.components.product.product_detail.ProductEssentialComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;

import java.util.List;

public abstract class ComputerProductEssentialComponent extends ProductEssentialComponent {
    private final static By inputCheckboxSel = By.cssSelector(".option-list input");
    public ComputerProductEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    abstract public String selectProcessor(String processorType);
    abstract public String selectRam(String ramType);
    abstract public String selectHDD(String hDDType);
    abstract public String selectOS(String os);
    abstract public String selectSoftware(String software);
    public void unSelectAllDefaultCheckBox() {
        List<WebElement> inputCheckboxes = findElements(inputCheckboxSel);
        inputCheckboxes.forEach(inputCheckbox -> {
            if (inputCheckbox.isSelected()) inputCheckbox.click();
        });
    }
}
