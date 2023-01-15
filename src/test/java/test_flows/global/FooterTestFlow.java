package test_flows.global;

import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import urls.Urls;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;
    public String baseUrl = Urls.demoBaseUrl;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyFooterComponent() {
        driver.get(baseUrl);
        try {
            HomePage homePage = new HomePage(driver);
            FooterComponent footer = homePage.footerComp();
            verifyInformationColumn(footer.informationColumnComp());
            verifyCustomerServiceColumn(footer.customServiceColumnComp());
//            verifyMyAccountColumn(footer.myAccountColumnComponent());
//            verifyFollowUsColumn(footer.followUsColumnComp());

        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    private void verifyInformationColumn(InformationColumnComponent informationColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");
        List<String> expectedLinks =  Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy",
                baseUrl + "/conditions-of-use", baseUrl + "/about-us", baseUrl + "/contactus");;
        handleTestFooterColumnComponent(informationColumnComponent, expectedLinkTexts, expectedLinks);
    }
    private void verifyCustomerServiceColumn(CustomerServiceColumnComponent customerServiceColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products"
                );
        List<String> expectedLinks =  Arrays.asList(
                baseUrl + "/search", baseUrl + "/news", baseUrl + "/blog", baseUrl + "/recentlyviewedproducts",
                baseUrl + "/compareproducts", baseUrl + "/newproducts");
        handleTestFooterColumnComponent(customerServiceColumnComponent, expectedLinkTexts, expectedLinks);
    }
    private void verifyMyAccountColumn(MyAccountColumnComponent myAccountColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("", "");
        List<String> expectedLinks =  Arrays.asList("", "");;
        handleTestFooterColumnComponent(myAccountColumnComponent, expectedLinkTexts, expectedLinks);
    }
    private void verifyFollowUsColumn(FollowUsColumnComponent followUsColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("", "");
        List<String> expectedLinks =  Arrays.asList("", "");;
        handleTestFooterColumnComponent(followUsColumnComponent, expectedLinkTexts, expectedLinks);
    }
    private void handleTestFooterColumnComponent
            (FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedLinks) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinks = new ArrayList<>();

        System.out.println(footerColumnComponent.headerEle().getText());
        footerColumnComponent.linksEle().forEach(link -> {
            actualLinkTexts.add(baseUrl + link.getText().trim());
            actualLinks.add(link.getAttribute("href"));
        });
        if (actualLinkTexts.isEmpty() || actualLinks.isEmpty()) {
            Assert.fail("ERROR: Texts or links is empty.");
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLinkTexts, expectedLinkTexts,
                "ERROR: Link texts of footer column are not matched");
        softAssert.assertEquals(actualLinkTexts, expectedLinks,
                "ERROR: Hyperlinks of footer column are not matched");
    }
}
