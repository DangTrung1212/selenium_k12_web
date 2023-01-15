package test.global;

import driver.DriverFactory;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import test_flows.global.FooterTestFlow;
import urls.Urls;

public class TestFooter {

    @Test
    public void testFooter() {
        WebDriver driver = DriverFactory.initChromeDriver();
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    @Test
    public void testHardAssertion() {
        Assertion assertion = new Assertion();
//        assertion.assertEquals(2,3);
        assertion.assertFalse(false);
        assertion.assertTrue(true);
    }
    @Test
    public void testSortAssertion() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2,3);
        softAssert.assertTrue(false);
        System.out.println("heelo");
        softAssert.assertAll();
    }

}
