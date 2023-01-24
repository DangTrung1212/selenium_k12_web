package test.order;

import models.components.product.product_detail.computer.CheapComputerEssentialComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderCheapComputer extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testOrderCheapComputer(ComputerData computerData) {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.cheapComputerSlug);
        OrderComputerTestFlow<CheapComputerEssentialComponent> orderComputerTestFlow =
                new OrderComputerTestFlow<>(driver,computerData);
        orderComputerTestFlow.buildComputerAndAddToCart(
                CheapComputerEssentialComponent.class);
        orderComputerTestFlow.verifyCartPage();
        orderComputerTestFlow.clickTOSCheckboxAndCheckOut();
        orderComputerTestFlow.clickOnCheckoutAsGuestBtn();
        orderComputerTestFlow.inputBillingAddress();

//        orderComputerTestFlow.inputShippingAddress();
//        orderComputerTestFlow.inputShippingMethod();
//        orderComputerTestFlow.inputPaymentMethod();
//        orderComputerTestFlow.inputPaymentInfo();
//        orderComputerTestFlow.confirmOrder();
    }
    @DataProvider
    private ComputerData[] computerData() {
        String jsonDataLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(
                jsonDataLocation, ComputerData[].class);
    }



}
