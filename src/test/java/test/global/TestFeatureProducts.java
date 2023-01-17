package test.global;

import driver.DriverFactory;
import models.components.product.homepage_product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import urls.Urls;

import java.util.List;

public class TestFeatureProducts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.initChromeDriver();
        try {
            testFeatureProducts(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
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
