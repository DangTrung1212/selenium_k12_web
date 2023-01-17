package test_flows.order;

import models.components.product.product_detail.computer.CheapComputerEssentialComponent;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerTestFlow {
    private final WebDriver driver;
    public OrderComputerTestFlow(WebDriver driver) {
        this.driver = driver;
    }
    public void orderCheapComputerFlow() {
        ComputerProductPage<CheapComputerEssentialComponent> computerProductPage = new ComputerProductPage<>(driver);
        CheapComputerEssentialComponent cheapComputerCenterComp =
                computerProductPage.computerProductEssentialComp(CheapComputerEssentialComponent.class);
        cheapComputerCenterComp.selectProcessor("Slow");
        cheapComputerCenterComp.selectRam("4 GB");
    }

}
