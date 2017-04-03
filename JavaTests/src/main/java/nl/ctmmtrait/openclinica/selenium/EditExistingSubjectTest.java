package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class EditExistingSubjectTest extends AbstractPerformanceTest {

  public EditExistingSubjectTest(String baseURL, WebDriver driver, long timeOutInSeconds) {
    super(baseURL, driver, timeOutInSeconds);
  }

  public void run(String userID, String userPWD) throws Exception {
    long startTime = System.currentTimeMillis();
    driver.get(baseUrl + "/OpenClinica/pages/login/login");
    webDriverHelper.clearAndWrite("username", userID);
    webDriverHelper.clearAndWrite("j_password", userPWD);


    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Subject Matrix")).click();
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.xpath("(//img[@alt='View'])[22]")).click();
    driver.findElement(By.name("bt_EnterData1")).click();
    new Select(driver.findElement(By.id("sectionTabSelectElement"))).selectByVisibleText("Script");
    driver.findElement(By.id("input33581")).clear();
    driver.findElement(By.id("input33581")).sendKeys("Data entered on " + startTime);
    driver.findElement(By.id("input33582")).clear();
    driver.findElement(By.id("input33582")).sendKeys("25:45");
    driver.findElement(By.id("srl")).click();
    driver.findElement(By.id("input33582")).clear();
    driver.findElement(By.id("input33582")).sendKeys("05:45");
    driver.findElement(By.id("srl")).click();
    driver.findElement(By.linkText("Subject Matrix")).click();
    driver.findElement(By.linkText("Log Out")).click();
    assertEquals("OpenClinica", driver.getTitle());
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | {new Date()} | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | {(storedVars["endTime"].getTime() - storedVars["startTime"].getTime())} | ]]
    String endTime = Utilities.formatCurrentDateTime();
    long duration = System.currentTimeMillis() - startTime;

    // Result of test run: test EditExistingSubject completed successfully at Tue Aug 02 2016 21:31:25 GMT+0200 (W. Europe Standard Time). Duration 15415 ms
    System.out.println("EditExistingSubject completed successfully at " + endTime + ". Duration " + duration + " ms");
  }
}
