package support.cookie;

import com.google.gson.Gson;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import test_data.DataObjectBuilder;
import test_data.cookies.CookieObject;

import java.io.*;
import java.util.*;

public class CookieHelper {
    private static final String relativePath = "/src/main/java/test_data/cookies/cookies.json";
    private static final String absolutePath = System.getProperty("user.dir")
            + relativePath;
    public static void saveCookie(WebDriver driver, String domain) {
        Set<Cookie> cookies = driver.manage().getCookies();
//        List<Cookie> domainCookies = new ArrayList<>();
//        for (Cookie cookie : cookies) {
//            if (cookie.getDomain().equalsIgnoreCase(domain)) domainCookies.add(cookie);
//        }
//        Set<Cookie> cookieSet = new HashSet<>(domainCookies);
        File file = new File(absolutePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            Gson gson = new Gson();
            String cookieJson = gson.toJson(cookies);
            fileWriter.write(cookieJson);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addCookieToDriver(WebDriver driver) {
        CookieObject[] cookieObjects = DataObjectBuilder.buildDataObjectFrom(relativePath, CookieObject[].class);
        Cookie cookie;
        for (CookieObject cookieObject : cookieObjects) {
            Cookie.Builder builder = new Cookie.Builder(cookieObject.getName(), cookieObject.getValue());
            builder.path(cookieObject.getPath());
            builder.domain(cookieObject.getDomain());
            builder.isHttpOnly(cookieObject.isHttpOnly());
            builder.isSecure(cookieObject.isSecure());
            builder.sameSite(cookieObject.getSameSite());
            builder.sameSite(cookieObject.getExpiry());
            cookie = builder.build();
            driver.manage().addCookie(cookie);
        }
        System.out.println(driver.manage().getCookies().toString());
    }
}
