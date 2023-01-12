package models.components;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;

public class GenericType {
    public static <T extends BaseLoginPage>void login(Class<T> loginPageClass) {
        Class<?>[] params = new Class[]{WebDriver.class};
        try {
            Constructor<T> constructor = loginPageClass.getConstructor(params);
            T loginObj = constructor.newInstance(DriverFactory.initDriver());
            loginObj.login("abc",  "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        login(HeroLoginPage.class);
    }
}
