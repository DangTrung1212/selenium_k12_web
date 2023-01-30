package models.components.register;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectHelper;

@ComponentCssSelector(value = ".registration-page")
public class RegisterComponent extends Component {

    public RegisterComponent(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    //    Personal Info:
    public String selectGender(String gender) {
        return null;
    }
    public String enterFirstName(String fName) {
        return null;
    }
    public String enterLastName(String lName) {
        return null;
    }
    public String enterEmail(String email) {
        return null;
    }

}
