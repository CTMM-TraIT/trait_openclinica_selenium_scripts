package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ClickingThroughSubjectMatrixTest extends AbstractPerformanceTest {

  public ClickingThroughSubjectMatrixTest(String baseURL, WebDriver driver, long timeOutInSeconds) {
    super(baseURL, driver, timeOutInSeconds);
  }

  public void run(String userID, String userPWD) throws Exception {
    long startTime = System.currentTimeMillis();
    driver.get(baseUrl + "/OpenClinica/pages/login/login");

    webDriverHelper.clearAndWrite("username", userID);
    webDriverHelper.clearAndWrite("j_password", userPWD);

    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Subject Matrix")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.linkText("Notes & Discrepancies")).click();
    driver.findElement(By.linkText("Study Audit Log")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    //*[@id="subnav_Tasks"]/div/div[8]/div/a
    //*[@id="nav_Tasks_link"]
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("View Datasets")).click();
    driver.findElement(By.name("bt_View1")).click();
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("View Study")).click();
    driver.findElement(By.name("bt_View1")).click();
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("Users")).click();
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("Source Data Verification")).click();
    driver.findElement(By.linkText("View By Study Subject ID")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("View Events")).click();
    driver.findElement(By.id("startDateField")).clear();
    driver.findElement(By.id("startDateField")).sendKeys("01-Mar-2000");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    Utilities.activateMenu(driver);
    driver.findElement(By.linkText("Build Study")).click();
    driver.findElement(By.xpath("(//img[@alt='View'])[3]")).click();
    driver.findElement(By.linkText("Go back to the Build Study page")).click();
    driver.findElement(By.cssSelector("img[alt=\"View\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Log Out")).click();
    assertEquals("OpenClinica", driver.getTitle());
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | {new Date()} | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | {(storedVars["endTime"].getTime() - storedVars["startTime"].getTime())} | ]]
    long duration = System.currentTimeMillis() - startTime;
    String endTime = Utilities.formatCurrentDateTime();
    System.out.println("ClickingThrough completed successfully at " + endTime + ". Duration " + duration + " ms");
  }
}
