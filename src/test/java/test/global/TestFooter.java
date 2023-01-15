package test.global;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import test_flows.global.FooterTestFlow;
import urls.Urls;

public class TestFooter {

    public void testFooter() {
        WebDriver driver = DriverFactory.initChromeDriver();
        driver.get(Urls.demoBaseUrl);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        try {
            footerTestFlow.verifyFooterComponent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testProductCatFooterComp() {
        WebDriver driver = DriverFactory.initChromeDriver();
        driver.get(Urls.demoBaseUrl);
        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCatFooterComponent();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public void testHardAssertion() {
        Assertion assertion = new Assertion();
//        assertion.assertEquals(2,3);
        assertion.assertFalse(false);
        assertion.assertTrue(true);
    }

    public void testSortAssertion() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2, 3);
        System.out.println("heelo");
        softAssert.assertAll();
    }

}
