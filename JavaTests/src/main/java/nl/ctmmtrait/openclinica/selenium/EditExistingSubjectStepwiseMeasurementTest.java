package nl.ctmmtrait.openclinica.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import nl.ctmmtrait.openclinica.selenium.AbstractPerformanceTest;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditExistingSubjectStepwiseMeasurementTest extends AbstractPerformanceTest {

  public EditExistingSubjectStepwiseMeasurementTest(String baseURL, WebDriver driver, long timeOutInSeconds) {
    super(baseURL, driver, timeOutInSeconds);
  }

  public void run(String userID, String userPWD) throws Exception {

    LapTimer lapTimer = new LapTimer();
    lapTimer.startLap();
    driver.get(baseUrl + "/OpenClinica/pages/login/login");

    webDriverHelper.clearAndWrite("username", userID);
    webDriverHelper.clearAndWrite("j_password", userPWD);

    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Subject Matrix")).click();
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    lapTimer.lapAndLog("Edit_Existing_Subject - ClickSubjectMatrix");
    // ERROR: Caught exception [unknown command [lapAndLog]]
    driver.findElement(By.xpath("(//img[@alt='View'])[8]")).click();
    driver.findElement(By.name("bt_EnterData1")).click();
    new Select(driver.findElement(By.id("sectionTabSelectElement"))).selectByVisibleText("Script");
    driver.findElement(By.id("input33581")).clear();
    String startTime = Utilities.formatCurrentDateTime();
    driver.findElement(By.id("input33581")).sendKeys("Data entered on " + startTime);
    driver.findElement(By.id("input33582")).clear();
    driver.findElement(By.id("input33582")).sendKeys("25:45");
    driver.findElement(By.id("srl")).click();
    driver.findElement(By.id("input33582")).clear();
    driver.findElement(By.id("input33582")).sendKeys("05:45");
    driver.findElement(By.id("srl")).click();
    lapTimer.lapAndLog("Edit_Existing_Subject - EditSubjectMatrix");
    driver.findElement(By.linkText("Subject Matrix")).click();
    driver.findElement(By.linkText("Log Out")).click();
    assertEquals("OpenClinica", driver.getTitle());
  }
}
