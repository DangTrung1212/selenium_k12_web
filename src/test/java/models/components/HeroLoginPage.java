package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeroLoginPage extends BaseLoginPage {
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
    public void login(String userNameString, String passWordString) {
        userName().sendKeys(userNameString);
        passWord().sendKeys(passWordString);
        submitBtn().click();
    }
}
