package support.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionEX  {
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
}
