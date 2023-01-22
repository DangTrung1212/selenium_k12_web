package test_flows.order;

import models.components.product.product_detail.computer.ComputerProductEssentialComponent;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;
import test_data.computer.ComputerData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerTestFlow<T extends ComputerProductEssentialComponent> {
    private final WebDriver driver;
    private final ComputerData computerData;

    public OrderComputerTestFlow(WebDriver driver, ComputerData computerData) {
        this.driver = driver;
        this.computerData = computerData;
    }

    public void orderComputerFlow(Class<T> computerEssentialClass) {
        ComputerProductPage<T> computerProductPage = new ComputerProductPage<>(driver);
        T computerEssentialComp =
                computerProductPage.computerProductEssentialComp(computerEssentialClass);
        String processorFullString = computerEssentialComp.selectProcessor(computerData.getProcessorType());
        System.out.println(extractAdditionalPriceFromText(processorFullString));
        String ramFullString = computerEssentialComp.selectRam(computerData.getRam());
        System.out.println(extractAdditionalPriceFromText(ramFullString));
        String hddFullString = computerEssentialComp.selectHDD(computerData.getHdd());
        System.out.println(extractAdditionalPriceFromText(hddFullString));
        String osFullString = computerEssentialComp.selectOS(computerData.getOS());
        System.out.println(extractAdditionalPriceFromText(osFullString));
        String sofwareFullString = computerEssentialComp.selectSoftware(computerData.getSoftware());
        System.out.println(extractAdditionalPriceFromText(sofwareFullString));
    }
    public static double extractAdditionalPriceFromText(String text) {
        double additionalPrice = 0;
        Pattern pattern = Pattern.compile("\\[\\+?(.+)\\]");
        try {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                additionalPrice = Double.parseDouble(matcher.group(1));
            }
        } catch (NullPointerException ignored) {};
        return additionalPrice;
    }
}
