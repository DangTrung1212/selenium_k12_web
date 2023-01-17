package test.order;

import org.testng.annotations.Test;
import test.global.BaseTest;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderComputer extends BaseTest {
    @Test
    public void testOrderCheapComputer() {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.cheapComputerSlug);
        OrderComputerTestFlow orderComputerTestFlow = new OrderComputerTestFlow(driver);
        orderComputerTestFlow.orderCheapComputerFlow();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
