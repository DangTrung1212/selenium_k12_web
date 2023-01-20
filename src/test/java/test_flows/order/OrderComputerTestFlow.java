package test_flows.order;

import models.components.product.product_detail.computer.ComputerProductEssentialComponent;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerTestFlow<T extends ComputerProductEssentialComponent> {
    private final WebDriver driver;


    public OrderComputerTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void orderComputerFlow(Class<T> computerEssentialClass, String processorType, String ramType) {
        ComputerProductPage<T> computerProductPage = new ComputerProductPage<>(driver);
        T computerEssentialComp =
                computerProductPage.computerProductEssentialComp(computerEssentialClass);
        System.out.println(computerEssentialComp.selectProcessor(processorType));
        System.out.println(computerEssentialComp.selectRam(ramType));
    }
}
