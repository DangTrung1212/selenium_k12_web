package test_flows.global;

import models.components.Component;
import models.components.global.TopMenuComponent;
import models.components.global.TopMenuComponent.TopMenuItemComponent.SublistComponent;
import models.components.global.footer.*;
import models.pages.BasePage;

import static models.components.global.TopMenuComponent.TopMenuItemComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import urls.Urls;


import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;
    public String baseUrl = Urls.demoBaseUrl;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    private void verifyInformationColumn(InformationColumnComponent informationColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");
        List<String> expectedLinks = Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy",
                baseUrl + "/conditions-of-use", baseUrl + "/about-us", baseUrl + "/contactus");
        ;
        handleTestFooterColumnComponent(informationColumnComponent, expectedLinkTexts, expectedLinks);
    }

    private void verifyCustomerServiceColumn(CustomerServiceColumnComponent customerServiceColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products"
        );
        List<String> expectedLinks = Arrays.asList(
                baseUrl + "/search", baseUrl + "/news", baseUrl + "/blog", baseUrl + "/recentlyviewedproducts",
                baseUrl + "/compareproducts", baseUrl + "/newproducts");
        handleTestFooterColumnComponent(customerServiceColumnComponent, expectedLinkTexts, expectedLinks);
    }

    private void verifyMyAccountColumn(MyAccountColumnComponent myAccountColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("", "");
        List<String> expectedLinks = Arrays.asList("", "");
        ;
        handleTestFooterColumnComponent(myAccountColumnComponent, expectedLinkTexts, expectedLinks);
    }

    private void verifyFollowUsColumn(FollowUsColumnComponent followUsColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("", "");
        List<String> expectedLinks = Arrays.asList("", "");
        ;
        handleTestFooterColumnComponent(followUsColumnComponent, expectedLinkTexts, expectedLinks);
    }

    private void handleTestFooterColumnComponent
            (FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedLinks) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinks = new ArrayList<>();
        footerColumnComponent.linksEle().forEach(link -> {
            actualLinkTexts.add(link.getText().trim());
            actualLinks.add(link.getAttribute("href"));
        });
        if (actualLinkTexts.isEmpty() || actualLinks.isEmpty()) {
            Assert.fail("ERROR: Texts or links is empty.");
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLinkTexts, expectedLinkTexts,
                "ERROR: Link texts of footer column are not matched");
        softAssert.assertEquals(actualLinks, expectedLinks,
                "ERROR: Hyperlinks of footer column are not matched");
        softAssert.assertAll();
    }

    public void verifyFooterComponent() {
            BasePage basePage = new BasePage(driver);
            FooterComponent footer = basePage.footerComp();
            verifyInformationColumn(footer.informationColumnComp());
            verifyCustomerServiceColumn(footer.customServiceColumnComp());
//            verifyMyAccountColumn(footer.myAccountColumnComponent());
//            verifyFollowUsColumn(footer.followUsColumnComp());
    }

    public void verifyProductCatFooterComponent() {
        BasePage basePage = new BasePage(driver);
        TopMenuComponent topMenuComp = basePage.topMenuComp();
        List<TopMenuItemComponent> menuItemComps = topMenuComp.topMenuItemComps();
        if (menuItemComps.isEmpty()) {
            Assert.fail("No menu item in top menu component");
        }
        TopMenuItemComponent randomMenuItem = menuItemComps.get
                (new SecureRandom().nextInt(menuItemComps.size()));
        WebElement clickedEle;
        String clickEleHref;
        if (randomMenuItem.sublistComps().isEmpty()) {
            clickedEle = randomMenuItem.catItemLinkEle();
            clickEleHref = clickedEle.getAttribute("href");
            clickedEle.click();
        } else {
            List<SublistComponent> subListItems = randomMenuItem.sublistComps();
            SublistComponent sublistItem = subListItems.get(new SecureRandom().nextInt(subListItems.size()));
            clickedEle = sublistItem.getSelfElement();
            clickEleHref = clickedEle.getAttribute("href");
            clickedEle.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            System.out.println(clickedEle);
            wait.until(ExpectedConditions.urlContains(clickEleHref));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("[ERR] Target page is not matched!");
        }
        verifyFooterComponent();

    }
}
