package lession_15;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestWebDriver {
    String relativePath = "\\src\\test\\resources\\chromedriver.exe";
    String chromeDriver = System.getProperty("user.dir") + relativePath;
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
    }
}
