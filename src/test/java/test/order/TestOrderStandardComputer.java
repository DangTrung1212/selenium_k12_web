package test.order;

import models.components.product.product_detail.computer.StandardComputerEssentialComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_data.payment_method.PaymentMethod;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderStandardComputer extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testOrderStandardComputer(ComputerData computerData) {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.standardComputerSlug);
        OrderComputerTestFlow<StandardComputerEssentialComponent> orderComputerTestFlow =
                new OrderComputerTestFlow<>(driver,computerData);
        orderComputerTestFlow.buildComputerAndAddToCart(
                StandardComputerEssentialComponent.class);
        orderComputerTestFlow.verifyCartPage();
        orderComputerTestFlow.clickTOSCheckboxAndCheckOut();
        orderComputerTestFlow.clickOnCheckoutAsGuestBtn();
        orderComputerTestFlow.inputBillingAddress();
        orderComputerTestFlow.inputShippingAddress();
        orderComputerTestFlow.inputShippingMethod();
        orderComputerTestFlow.inputPaymentMethod(PaymentMethod.getRandomPaymentMethod());
        orderComputerTestFlow.inputPaymentInfo();
    }
    @DataProvider
    private ComputerData[] computerData() {
        String jsonDataLocation = "/src/test/java/test_data/computer/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(
                jsonDataLocation, ComputerData[].class);
    }

}
