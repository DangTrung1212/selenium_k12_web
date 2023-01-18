package test.order;

import models.components.product.product_detail.computer.CheapComputerEssentialComponent;
import models.components.product.product_detail.computer.StandardComputerEssentialComponent;
import models.pages.product_page.ComputerProductPage;
import org.testng.annotations.Test;
import test.global.BaseTest;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderComputer extends BaseTest {
    @Test
    public void testOrderCheapComputer() {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.cheapComputerSlug);
        OrderComputerTestFlow<CheapComputerEssentialComponent> orderComputerTestFlow =
                new OrderComputerTestFlow<>(driver);
        orderComputerTestFlow.orderComputerFlow(
                CheapComputerEssentialComponent.class, "Slow", "8 GB");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testOrderStandardComputer() {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.standardComputerSlug);
        OrderComputerTestFlow<StandardComputerEssentialComponent> orderComputerTestFlow =
                new OrderComputerTestFlow<>(driver);
        orderComputerTestFlow.orderComputerFlow(
                StandardComputerEssentialComponent.class, "2.2", "4GB");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
