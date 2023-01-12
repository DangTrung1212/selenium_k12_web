package models.components.global.footer;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public InformationColumnComponent informationColumnComp() {
        return findComponent(driver, InformationColumnComponent.class);
    }
    public CustomServiceColumnComponent customServiceColumnComp() {
        return findComponent(driver, CustomServiceColumnComponent.class);
    }
    public FollowUsColumnComponent followUsColumnComp() {
        return findComponent(driver, FollowUsColumnComponent.class);
    }
    public MyAccountColumnComponent myAccountColumnComponent() {
        return findComponent(driver, MyAccountColumnComponent.class);
    }
}
