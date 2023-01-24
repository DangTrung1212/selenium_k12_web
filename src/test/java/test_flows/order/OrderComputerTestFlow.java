package test_flows.order;

import models.components.cart.CartFooterTotalComponent;
import models.components.cart.CartItemComponent;
import models.components.checkout.checkout_data.BillAddressComponent;
import models.components.product.product_detail.computer.ComputerProductEssentialComponent;
import models.pages.CartPage;
import models.pages.checkout_page.CheckoutOptionPage;
import models.pages.checkout_page.CheckoutPage;
import models.pages.product_page.ComputerProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_data.user.UserBillAddressData;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerTestFlow<T extends ComputerProductEssentialComponent> {
    private final WebDriver driver;
    private final ComputerData computerData;

    private double totalPrice;
    private final int qty;
    private final UserBillAddressData defaultBillAddressData = DataObjectBuilder
            .buildDataObjectFrom(
                    "/src/test/java/test_data/user/DefaultBillingAddressData.json",
                    UserBillAddressData.class);

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

    public void buildComputerAndAddToCart(Class<T> computerEssentialClass) {
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
    }

    public void verifyCartPage() {
        CartPage cartPage = new CartPage(driver);
//        Verify add correct product, price and qty
        List<CartItemComponent> cartItemComps = cartPage.cartItemComps();
        if (cartItemComps.isEmpty()) Assert.fail("[ERR] Can't find any cart item.");
        CartItemComponent latestAddedItem = cartItemComps.get(cartItemComps.size() - 1);
        Assert.assertEquals(totalPrice, latestAddedItem.unitPrice(),
                "[ERR] Price after add to cart is not matched.");
        Assert.assertEquals(qty, latestAddedItem.qty(),
                "[ERR] Qty after add to cart is not matched. ");

//        Verify unit price, qty and subtotal
        double totalSubtotal = 0;
        for (CartItemComponent cartItemComp : cartItemComps) {
            double expectedTotalItemPrice = cartItemComp.qty() * cartItemComp.unitPrice();
            double actualTotalItemPrice = cartItemComp.totalItemPrice();
            Assert.assertEquals(expectedTotalItemPrice, actualTotalItemPrice,
                    "[ERR] Subtotal of cart item is not match qty and unit price. ");
            totalSubtotal += actualTotalItemPrice;
        }

//        Verify checkout price
        CartFooterTotalComponent cartFooterTotalComp= cartPage.cartFooterComp().cartFooterTotalComp();
        Map<String, Double> priceCatalogs = cartFooterTotalComp.priceCatalogs();
        double subtotal = 0;
        double checkoutPrice = 0;
        double extraFee = 0;
        for (String priceType : priceCatalogs.keySet()) {
            if (priceType.startsWith("Sub-Total")) subtotal = priceCatalogs.get(priceType);
            else if (priceType.startsWith("Total")) checkoutPrice = priceCatalogs.get(priceType);
            else extraFee = priceCatalogs.get(priceType);
        }
        Assert.assertEquals(subtotal + extraFee, checkoutPrice,
                "[ERR] Checkout price is not matched subtotal and extra fee. ");
    }
    public void clickTOSCheckboxAndCheckOut() {
        CartPage cartPage = new CartPage(driver);
        CartFooterTotalComponent cartFooterTotalComp = cartPage.cartFooterComp().cartFooterTotalComp();
        cartFooterTotalComp.checkTOSCheckbox(true);
        cartFooterTotalComp.clickOnCheckOutBtn();
    }
    public void clickOnCheckoutAsGuestBtn() {
        new CheckoutOptionPage(driver).clickCheckoutAsGuestBtn();
    }
    public void inputBillingAddress() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        BillAddressComponent billAddressComp = checkoutPage.checkoutDataComp().billAddressComp();
        billAddressComp.handleAddressDropdownAppear();
        billAddressComp.inputFirstname(defaultBillAddressData.getFirstname());
        billAddressComp.inputLastname(defaultBillAddressData.getLastname());
        billAddressComp.inputEmail(defaultBillAddressData.getEmail());
        billAddressComp.inputCountry(defaultBillAddressData.getCountry());
        billAddressComp.inputState(defaultBillAddressData.getState());
        billAddressComp.inputCity(defaultBillAddressData.getCity());
        billAddressComp.inputAddress1(defaultBillAddressData.getAdd1());
        billAddressComp.inputZipcode(defaultBillAddressData.getZipcode());
        billAddressComp.inputPhoneNum(defaultBillAddressData.getPhoneNum());
        billAddressComp.clickOnContinueBtn();
    }

    public void inputShippingAddress() {
    }

    public void inputShippingMethod() {
    }

    public void inputPaymentMethod() {
    }

    public void inputPaymentInfo() {
    }

    public void confirmOrder() {
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
