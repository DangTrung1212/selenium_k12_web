package test_flows.order;

import models.components.product.product_detail.computer.CheapComputerCenterComponent;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerTestFlow {
    private final WebDriver driver;
    public OrderComputerTestFlow(WebDriver driver) {
        this.driver = driver;
    }
    public void orderCheapPCFlow() {
        ComputerProductPage<CheapComputerCenterComponent> computerProductPage = new ComputerProductPage<>(driver);
        CheapComputerCenterComponent cheapComputerCenterComp =
                computerProductPage.computerProductCenterComp(CheapComputerCenterComponent.class);
        cheapComputerCenterComp.selectProcessor();
        cheapComputerCenterComp.selectRam();
    }

}
