package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement component;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement findElement(By by) {
        return component.findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        return component.findElements(by);
    }

    protected <T extends Component> T findComponent(WebDriver driver, Class<T> componentClass) {
        return findComponents(driver, componentClass).get(0);
    }

    //    search component without knowing detail context => generic type
    protected <T extends Component> List<T> findComponents(WebDriver driver, Class<T> componentClass) {
        By cssSelector = getSelector(componentClass);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cssSelector));
        List<WebElement> results = component.findElements(cssSelector);
        Class<?>[] parameters = new Class[]{WebDriver.class, WebElement.class};
        Constructor<T> constructor;
        try {
            constructor = componentClass.getConstructor(parameters);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(
                    "Component must have constructor with param: " + Arrays.toString(parameters));
        }
//      Convert all webElement to Component
        List<T> components = results.stream().map(webElement ->
                {
                    try {
                        return constructor.newInstance(driver, webElement);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
        ).collect(Collectors.toList());
        return components;
    }

    private By getSelector(Class<? extends Component> componentClass) {
        if (componentClass.isAnnotationPresent(ComponentCssSelector.class)) {
            return By.cssSelector(componentClass.getAnnotation(ComponentCssSelector.class).value());
        } else if (componentClass.isAnnotationPresent(ComponentXpathSelector.class)) {
            return By.xpath(componentClass.getAnnotation(ComponentXpathSelector.class).value());
        } else {
            throw new IllegalArgumentException(String.format("Component %s must have annotation %s or %s ",
                    componentClass.getSimpleName(),
                    ComponentCssSelector.class.getSimpleName(),
                    ComponentXpathSelector.class.getSimpleName()));
        }
    }
}