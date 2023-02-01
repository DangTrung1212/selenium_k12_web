package test.bypass_login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestSaveCookie extends BaseTest {
    @Test
    public void loginShopify() {
        WebDriver driver = getDriver();
        driver.get("https://training-trung-dn.myshopify.com/admin");

    }
}
