package models.loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMod2 {
    private final WebDriver driver;
    private By userNameSel;
    private By passWordSel;
    private By submitBtnSel;

    public LoginPageMod2(WebDriver driver) {
        this.driver = driver;
    }
    public void inputUserName(String userName) {
        driver.findElement(userNameSel).sendKeys(userName);
    }
    public void inputPassWord(String passWord) {
        driver.findElement(passWordSel).sendKeys(passWord);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitBtnSel).click();
    }
}
