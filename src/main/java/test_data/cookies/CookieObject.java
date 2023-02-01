package test_data.cookies;

import java.util.Date;

public class CookieObject {
    private String name;
    private String value;
    private String domain;
    private String path;
    private String expiry;
    private boolean isSecure;
    private boolean isHttpOnly;
    private String sameSite;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDomain() {
        return domain;
    }

    public String getPath() {
        return path;
    }

    public String getExpiry() {
        return expiry;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public boolean isHttpOnly() {
        return isHttpOnly;
    }

    public String getSameSite() {
        return sameSite;
    }

    @Override
    public String toString() {
        return "CookieObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", expiry=" + expiry +
                ", isSecure=" + isSecure +
                ", isHttpOnly=" + isHttpOnly +
                ", sameSite='" + sameSite + '\'' +
                '}';
    }
}
