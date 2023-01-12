package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import urls.Urls;

public class HeroLoginPage extends BaseLoginPage {
    public final String url = Urls.indexUrl + Urls.loginSlug;
    private final By userNameSel = By.cssSelector("#username");
    private final By passWordSel = By.cssSelector("#password");
    private final By submitBtnSel = By.cssSelector("btn[type='submit']");

    public HeroLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement userName() {
        return driver.findElement(userNameSel);
    }

    @Override
    public WebElement passWord() {
        return driver.findElement(passWordSel);
    }

    @Override
    public WebElement submitBtn() {
        return driver.findElement(submitBtnSel);
    }

    @Override
    public void navigateToPage() {
        driver.get(url);
    }

    @Override
    public void login(String userNameString, String passWordString) {
        navigateToPage();
        userName().sendKeys(userNameString);
        passWord().sendKeys(passWordString);
        submitBtn().click();
    }


}
