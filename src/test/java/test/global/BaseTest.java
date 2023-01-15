package test.global;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public void initChromeSession() {
        driver = DriverFactory.initChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeChromeSession() {
        if (driver != null) driver.quit();
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
//            Get test method name
            String methodName = result.getName();
//            Get created time
            Calendar calendar = new GregorianCalendar();
            String fileName = String.format("%s-%d-%d-%d-%d-%d-%d-%d.png",
                    methodName,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DATE),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    calendar.get(Calendar.MILLISECOND));
            File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir") + "\\screenshot\\" + fileName;
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
