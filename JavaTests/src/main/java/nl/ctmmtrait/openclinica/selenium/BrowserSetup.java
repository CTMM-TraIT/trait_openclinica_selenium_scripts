package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by jacob on 3/9/17.
 */
public enum BrowserSetup {


    FIREFOX("webdriver.gecko.driver", false, "firefox", "firefox_binary", DesiredCapabilities.firefox()),
    CHROME("webdriver.chrome.driver", true, "chrome", "", DesiredCapabilities.chrome()),
    INTERNET_EXPLORER("webdriver.ie.driver", false, "IE", "firefox_binary", DesiredCapabilities.internetExplorer());


    private final String pathToBinaryKeyName;

    private final String driverSystemPropertyKeyName;

    private final DesiredCapabilities capabilities;



    private BrowserSetup(String driverSystemPropertyKeyName, boolean marionetteOn, String browserName, String pathToBinaryKeyName, DesiredCapabilities capabilities) {
        this.driverSystemPropertyKeyName = driverSystemPropertyKeyName;
        this.pathToBinaryKeyName = pathToBinaryKeyName;
        this.capabilities = capabilities;

        capabilities.setCapability("marionette", marionetteOn);
        capabilities.setJavascriptEnabled(true);
        capabilities.setBrowserName(browserName);
        capabilities.setCapability("webdriver.log.file","webdriver-output.log");
    }

    public void initBrowserSetup(String pathToBrowserExecutable, String pathToDriver) {
        System.setProperty(driverSystemPropertyKeyName, pathToDriver);
        capabilities.setCapability(pathToBinaryKeyName, pathToBrowserExecutable);
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }
}
