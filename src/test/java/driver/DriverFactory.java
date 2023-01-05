package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private static final String windowDriverRelativePath = "\\src\\test\\resources\\chromedriver.exe";
    private static final String macDriverRelativePath = "/src/test/resources/chromedriver.exe";
    private static final String rootPath = System.getProperty("user.dir");

    public static WebDriver initDriver() {
        String chromeDriverPath = "";
        if (OS.isFamilyMac()) {
            chromeDriverPath = rootPath + macDriverRelativePath;
        } else if (OS.isFamilyWindows()) {
            chromeDriverPath = rootPath + windowDriverRelativePath;

        } else {
            System.out.println("Not Support this OS.");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito", "--maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
