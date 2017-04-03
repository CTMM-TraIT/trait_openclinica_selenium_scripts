package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by jacob on 3/29/17.
 */
public abstract class AbstractPerformanceTest {

    protected WebDriver driver;
    protected WebDriverHelper webDriverHelper;
    protected String baseUrl;

    public AbstractPerformanceTest(String baseURL, WebDriver driver, long timeOutInSeconds) {
        this.driver = driver;
        this.baseUrl = baseURL;
        this.webDriverHelper = new WebDriverHelper(driver, timeOutInSeconds);
        driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
    }

    public abstract void run(String userID, String userPWD) throws Exception;
}
