package test_flows.order;

import models.components.cart.CartFooterComponent;
import models.components.cart.CartFooterTotalComponent;
import models.components.product.product_detail.computer.ComputerProductEssentialComponent;
import models.pages.CartPage;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;
import test_data.computer.ComputerData;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerTestFlow<T extends ComputerProductEssentialComponent> {
    private final WebDriver driver;
    private final ComputerData computerData;

    private double totalPrice;
    private final int qty;

    public OrderComputerTestFlow(WebDriver driver, ComputerData computerData) {
        this.driver = driver;
        this.computerData = computerData;
        this.qty = 1;

    }

    public OrderComputerTestFlow(WebDriver driver, ComputerData computerData, int qty) {
        this.driver = driver;
        this.computerData = computerData;
        this.qty = qty;
    }

    public void orderComputerFlow(Class<T> computerEssentialClass) {
        ComputerProductPage<T> computerProductPage = new ComputerProductPage<>(driver);
        T computerEssentialComp =
                computerProductPage.computerProductEssentialComp(computerEssentialClass);
        computerEssentialComp.unSelectAllDefaultCheckBox();
//        processor
        String processorFullString = computerEssentialComp.selectProcessor(computerData.getProcessorType());
        System.out.println("Processor price: " + extractAdditionalPriceFromText(processorFullString));
        double processorAddPrice = extractAdditionalPriceFromText(processorFullString);
//        ram
        String ramFullString = computerEssentialComp.selectRam(computerData.getRam());
        System.out.println("Ram Price: " + extractAdditionalPriceFromText(ramFullString));
        double ramAddPrice = extractAdditionalPriceFromText(ramFullString);
//      hdd
        String hddFullString = computerEssentialComp.selectHDD(computerData.getHdd());
        System.out.println("HDD Price: " + extractAdditionalPriceFromText(hddFullString));
        double hDDAddPrice = extractAdditionalPriceFromText(hddFullString);
//        os
        String osFullString = computerEssentialComp.selectOS(computerData.getOS());
        System.out.println("OS Price: " + extractAdditionalPriceFromText(osFullString));
        double osAddPrice = extractAdditionalPriceFromText(osFullString);
//        software
        String sofwareFullString = computerEssentialComp.selectSoftware(computerData.getSoftware());
        System.out.println("Software Price: " + extractAdditionalPriceFromText(sofwareFullString));
        double softwareAddPrice = extractAdditionalPriceFromText(sofwareFullString);
//        total
        double totalAddPrice = processorAddPrice + ramAddPrice + hDDAddPrice + osAddPrice + softwareAddPrice;
        double productPrice = computerEssentialComp.productPrice();
        System.out.println("totalAddPrice: " + totalAddPrice);
        System.out.println("productPrice: " + productPrice);
        totalPrice = (totalAddPrice + productPrice) * qty;
        System.out.println(totalPrice);
//        click on add to cart
        computerEssentialComp.clickAddToCartBtn();
//        click on shopping cart link text:
        computerProductPage.headerComp().clickOnShoppingCart();
        verifyTotalCartPrice();
    }
    public void verifyTotalCartPrice () {
        CartPage cartPage = new CartPage(driver);
        CartFooterComponent cartFooterComp=cartPage.cartFooterComp();
        CartFooterTotalComponent cartFooterTotalComp = cartFooterComp.cartFooterTotalComp();
        Map<String, Double> priceCatalogs = cartFooterTotalComp.priceCatalogs();
        for (String priceType : priceCatalogs.keySet()) {
            System.out.println((priceType + ": " + priceCatalogs.get(priceType)));
        }
    }
    private static double extractAdditionalPriceFromText(String text) {
        double additionalPrice = 0;
        Pattern pattern = Pattern.compile("\\[\\+?(.+)\\]");
        try {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                additionalPrice = Double.parseDouble(matcher.group(1));
            }
        } catch (NullPointerException ignored) {
        }
        return additionalPrice;
    }

}
