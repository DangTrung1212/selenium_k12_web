package lab_15;


import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    private static final String windowDriverRelativePath = "\\src\\test\\resources\\chromedriver.exe";
    private static final String macDriverRelativePath = "/src/test/resources/chromedriver.exe";
    private static final String rootPath = System.getProperty("user.dir");

    public static void main(String[] args) {
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
        chromeOptions.addArguments("--incognito");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get("https://sdetpro.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        end session
        webDriver.quit();

    }


}
