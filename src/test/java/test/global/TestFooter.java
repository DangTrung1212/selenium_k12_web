package test.global;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import test.BaseTest;
import test_flows.global.FooterTestFlow;
import urls.Urls;

public class TestFooter extends BaseTest {
    @Test
    public void testFooter() {
        driver.get(Urls.demoEcommerceBaseUrl);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    @Test
    public void testProductCatFooterComp() {
        driver.get(Urls.demoEcommerceBaseUrl);
        Assert.fail("fail for screenshot");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();

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
