package nl.ctmmtrait.openclinica.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Runs the performance monitoring tests for the OpenClinica instances by TraIT / Lygature. The tests can be run using
 * from the command-line (Windows or Linux) with 4 required parameters which have to be given in this order:
 * <ul>
 *     <li>Browser to use <b>FF</b>, <b>CHR</b> or <b>IE</b></li>
 *     <li>Path to the Selenium web-driver associated with the browser</li>
 *     <li>The URL or the TraIT OpenClinica instance to use </li>
 *     <li>The user name to use for the log in</li>
 *     <li>The password of the user</li>
 * <ul/>
 *
 * For example
 * <pre>
 *     java -jar .......  FF /home/tester/webdrivers/ https://www-acc.openclinica.nl tester secret
 * </pre>
 * Created by jacob on 3/9/17.
 */
public class Main {

    private static final String FIREFOX_DRIVER = "FF";
    private static final String CHROME_DRIVER = "CHR";
    private static final String IE_DRIVER = "IE";

    private static final long TIME_OUT_IN_SECONDS = 20;



    private static WebDriver createDriver(String driverType, String pathToDriver, String pathToBrowserExecutable) {
        WebDriver driver;

        switch (driverType) {
            case FIREFOX_DRIVER : {
                BrowserSetup browserSetup = BrowserSetup.FIREFOX;
                browserSetup.initBrowserSetup(pathToBrowserExecutable, pathToDriver);
                driver = new FirefoxDriver(browserSetup.getCapabilities());
                break;
            }
            case CHROME_DRIVER : {
                BrowserSetup browserSetup = BrowserSetup.CHROME;
                browserSetup.initBrowserSetup(pathToBrowserExecutable, pathToDriver);
                driver = new ChromeDriver(browserSetup.getCapabilities());
                break;
            }
            case IE_DRIVER : {
                BrowserSetup browserSetup = BrowserSetup.INTERNET_EXPLORER;
                browserSetup.initBrowserSetup(pathToBrowserExecutable, pathToDriver);
                driver = new InternetExplorerDriver(browserSetup.getCapabilities());
                break;
            }
            default: throw new IllegalStateException("Unknown driver type specified: " + driverType);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static void checkDriverPath(String driverPath) {
        File file = new File(driverPath);
        if (! file.exists()) {
            throw new IllegalStateException("Path to driver executable does not exist: " + driverPath);
        }
        if (! file.canExecute()) {
            throw new IllegalStateException("Driver is not executable at: " + driverPath);
        }
    }


    public static void main(String[] args) {
        String driverType = args[0];
        String driverPath = args[1];
        String pathToBrowserExecutable = args[2];
        String testURL = args[3];
        String userID = args[4];
        String userPassword = args[5];

        System.out.println("Performance Monitor TraIT-OpenClinica");
        System.out.println("");
        System.out.println("Driver type:                " + driverType);
        System.out.println("Driver path:                " + driverPath);
        System.out.println("Path to browser executable: " + pathToBrowserExecutable);
        System.out.println("Test URL:                   " + testURL);
        System.out.println("");

        checkDriverPath(driverPath);

        WebDriver driver = createDriver(driverType, driverPath, pathToBrowserExecutable);
        driver.manage().window().maximize();

        ClickingThroughSubjectMatrixStepwiseExtendedVersionTest clickingThroughSubjectMatrixStepwiseExtendedVersionTest
         = new ClickingThroughSubjectMatrixStepwiseExtendedVersionTest(testURL, driver, TIME_OUT_IN_SECONDS);

        EditExistingSubjectStepwiseMeasurementTest editExistingSubjectStepwiseMeasurementTest =
                new EditExistingSubjectStepwiseMeasurementTest(testURL, driver, TIME_OUT_IN_SECONDS);

        ClickingThroughSubjectMatrixTest clickingThroughSubjectMatrixTest
                = new ClickingThroughSubjectMatrixTest(testURL, driver, TIME_OUT_IN_SECONDS);

        EditExistingSubjectTest editExistingSubjectTest
                = new EditExistingSubjectTest(testURL, driver, TIME_OUT_IN_SECONDS);
        try {
            clickingThroughSubjectMatrixTest.run(userID, userPassword);

            editExistingSubjectTest.run(userID, userPassword);

            editExistingSubjectStepwiseMeasurementTest.run(userID, userPassword);

            clickingThroughSubjectMatrixStepwiseExtendedVersionTest.run(userID, userPassword);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.close();
        }


        try {
            // wait 10 seconds before closing the browser
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    //    driver.quit();
    }
}
