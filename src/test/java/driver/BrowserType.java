package driver;

public enum BrowserType {
    chrome("chrome"),
    firefox("firefox");
    private final String browserName;

    BrowserType(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
}
