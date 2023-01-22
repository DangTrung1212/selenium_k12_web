package models.components.product.product_detail.computer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;


public class CheapComputerEssentialComponent extends ComputerProductEssentialComponent {
    public CheapComputerEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    @Override
    public String selectProcessor(String processorType) {
        return SelectHelper.selectRadioBtn(getSelfElement(), processorType, true);
    }

    @Override
    public String selectRam(String ramType) {
        return SelectHelper.selectRadioBtn(getSelfElement(), ramType, true);
    }

    @Override
    public String selectHDD(String hDDType) {
        return SelectHelper.selectRadioBtn(getSelfElement(), hDDType, true);
    }

    @Override
    public String selectOS(String os) {
        return null;
    }

    @Override
    public String selectSoftware(String software) {
        return SelectHelper.selectRadioBtn(getSelfElement(), software, true);
    }
}
