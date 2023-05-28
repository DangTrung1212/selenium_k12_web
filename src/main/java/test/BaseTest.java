package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private final static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;
    private String browser;

    //This method returns the WebDriver instance that is associated with the current thread
    protected WebDriver getDriver() {
        return driverThread.get().getDriver(browser);
    }

    //This method initializes a browser session before each test
    @BeforeTest(description = "Init browser session")
    @Parameters({"browser"})
    public void initBrowserSession(String browser) {
        //Sets the browser value to the one passed in as a parameter
        this.browser = browser;
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowserSession() {
        driverThread.get().closeBrowserSession();
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
//            Get test method name
            String methodName = result.getName();
//            Get created time
            Calendar calendar = new GregorianCalendar();
            String fileName = String.format("%s-y%d-m%d-d%d__h%d-%d-%d-%d.png",
                    methodName,
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DATE),
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    calendar.get(Calendar.MILLISECOND));
            WebDriver driver = getDriver();
            File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileLocation = "";
            if (OS.isFamilyMac()) fileLocation = System.getProperty("user.dir") + "/screenshot/" + fileName;
            else if (OS.isFamilyWindows())
                fileLocation = System.getProperty("user.dir") + "\\screenshot\\" + fileName;

            try {
                FileUtils.copyFile(screenshotBase64Data, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                try (InputStream inputStream = Files.newInputStream(content)) {
                    Allure.addAttachment(methodName, inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
