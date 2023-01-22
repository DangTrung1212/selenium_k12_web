package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectHelper {
    public static String selectRadioBtn(WebElement radioBtnContainer, String text, Boolean isInputPrecedingSibling) {
        By optionSel;
        String textValue;
        if (isInputPrecedingSibling) {
            optionSel = By.xpath(String.format("//label[contains(text(),'%s" +
                    "')]/preceding-sibling::input", text));
            List<WebElement> option = radioBtnContainer.findElements(optionSel);
            if (!option.isEmpty()) {
                if (!option.get(0).isSelected()) {
                    option.get(0).click();
                }
                textValue = option.get(0).findElement(By.xpath("following-sibling::label")).getText();
            } else {
                throw new RuntimeException("No option contained " + text);
            }
        } else {
            optionSel = By.xpath(String.format("//label[contains(text(),'%s" +
                    "')]/following-sibling::input", text));
            List<WebElement> option = radioBtnContainer.findElements(optionSel);
            if (!option.isEmpty()) {
                if (!option.get(0).isSelected()) {
                    option.get(0).click();
                }
                textValue = option.get(0).findElement(By.xpath("preceding-sibling::label")).getText();
            } else {
                throw new RuntimeException("No option contained " + text);
            }
        }
        return textValue;
    }

    public static String selectDropDownOption(WebElement dropDownContainer, String uniqueText) {
        By optionSel = By.xpath(String.format("//select/option[contains(text(),'%s')]", uniqueText));
        WebElement optionEle;
        String optionText;
        try {
            optionEle = dropDownContainer.findElement(optionSel);
            optionText = optionEle.getText();
        } catch (Exception e) {
            throw new RuntimeException("No such option contains " + uniqueText);
        }
        Select select = new Select(optionEle.findElement(By.xpath("..")));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(uniqueText)) {
                select.selectByVisibleText(option.getText());
                break;
            }
        }
        return optionText;


    }
}
