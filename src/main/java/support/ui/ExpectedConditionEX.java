package support.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionEX {
    private ExpectedConditionEX() {
    }

    public static ExpectedCondition<Boolean> MoreThanOneTab() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public String toString() {
                return "More than one Tab";
            }

            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getWindowHandles().size() > 1;

            }
        };
    }

    public static ExpectedCondition<WebElement> elementIsEnabled(WebElement webElement) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    if (webElement.isEnabled()) return webElement;
                    else return null;
                } catch (Exception e) {
                    return null;
                }
            }
            @Override
            public String toString() {
                return String.format("%s enabled", webElement.toString());
            }
        };
    }
}