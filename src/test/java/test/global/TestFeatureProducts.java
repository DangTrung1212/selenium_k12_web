package test.global;

import driver.DriverFactory;
import models.components.product.homepage_product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;
import urls.Urls;

import java.util.List;

public class TestFeatureProducts extends BaseTest {
    @Test
    public static void testFeatureProducts(WebDriver driver) {
        driver.get(Urls.demoEcommerceBaseUrl);
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComponents =homePage.productGridComponent().productItemComps();
        productItemComponents.forEach(productItem -> {
            System.out.printf("Product %s has price %s \n", productItem.titleEle().getText(),
                    productItem.priceEle().getText());
        });
    }
}
