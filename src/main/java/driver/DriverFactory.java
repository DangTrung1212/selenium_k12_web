package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(String browserName) {
        if (driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            BrowserType browserType;
            try {
                browserType = BrowserType.valueOf(browserName);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException(browserName + " is not supported browser.");
            }
            switch (browserType) {
                case chrome:
                    desiredCapabilities.setBrowserName(BrowserType.chrome.getBrowserName());
                    break;
                case firefox:
                    desiredCapabilities.setBrowserName(BrowserType.firefox.getBrowserName());
                    break;
            }
            String hub = "http://localhost:4444/wd/hub";
            try {
                driver = new RemoteWebDriver(new URL(hub), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public void closeBrowserSession() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver initChromeDriver() {
        WebDriver driver = new ChromeDriver();
        System.out.println(SeleniumManager.getInstance().getDriverPath("chromedriver"));
        System.out.println(SeleniumManager.getInstance().getDriverPath("geckodriver"));
        return driver;
    }
}
