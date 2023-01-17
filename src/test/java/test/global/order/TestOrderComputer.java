package test.global.order;

import org.testng.annotations.Test;
import test.global.BaseTest;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderComputer extends BaseTest {
    @Test
    public void testOrderCheapComputer() {
        driver.get(Urls.demoBaseUrl);
        OrderComputerTestFlow orderComputerTestFlow = new OrderComputerTestFlow(driver);
        orderComputerTestFlow.orderCheapComputerFlow();
    }
}
