package models.components.product.product_detail.computer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;

public class StandardComputerEssentialComponent extends ComputerProductEssentialComponent {
    public StandardComputerEssentialComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    @Override
    public String selectProcessor(String processorType) {
        return SelectHelper.selectDropDownOption(getSelfElement(), processorType);
    }

    @Override
    public String selectRam(String ramType) {
        return SelectHelper.selectDropDownOption(getSelfElement(), ramType);
    }

    @Override
    public String selectHDD(String hDDType) {
        return SelectHelper.selectRadioBtn(getSelfElement(), hDDType, true);
    }

    @Override
    public String selectOS(String os) {
        return SelectHelper.selectRadioBtn(getSelfElement(), os, true);
    }

    @Override
    public String selectSoftware(String software) {
        return SelectHelper.selectRadioBtn(getSelfElement(), software, true);
    }


}
