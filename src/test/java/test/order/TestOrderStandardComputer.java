package test.order;

import models.components.product.product_detail.computer.CheapComputerEssentialComponent;
import models.components.product.product_detail.computer.StandardComputerEssentialComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.global.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.order.OrderComputerTestFlow;
import urls.Urls;

public class TestOrderStandardComputer extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testOrderStandardComputer(ComputerData computerData) {
        driver.get(Urls.demoEcommerceBaseUrl + Urls.standardComputerSlug);
        OrderComputerTestFlow<StandardComputerEssentialComponent> orderComputerTestFlow =
                new OrderComputerTestFlow<>(driver,computerData);
        orderComputerTestFlow.orderComputerFlow(
                StandardComputerEssentialComponent.class);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider
    private ComputerData[] computerData() {
        return DataObjectBuilder.buildDataObjectFrom(
                "/src/test/java/test_data/computer/StandardComputerDataList.json", ComputerData[].class);
    }

}
