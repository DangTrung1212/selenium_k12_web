package test.global;

import driver.DriverFactory;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import urls.Urls;

public class TestFooter {
    public static WebDriver driver = DriverFactory.initChromeDriver();

    public static void main(String[] args) {
        try {
            driver.get(Urls.demoBaseUrl);
            new TestFooter().testFooter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
    public void testFooter() {
        HomePage homePage = new HomePage(driver);
        FooterComponent footerComp = homePage.footerComp();
        testFooterColumn(footerComp.informationColumnComp());
        testFooterColumn(footerComp.myAccountColumnComponent());
        testFooterColumn(footerComp.followUsColumnComp());
        testFooterColumn(footerComp.customServiceColumnComp());
    }
    public void testFooterColumn(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerEle().getText());
        footerColumnComponent.linksEle().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
