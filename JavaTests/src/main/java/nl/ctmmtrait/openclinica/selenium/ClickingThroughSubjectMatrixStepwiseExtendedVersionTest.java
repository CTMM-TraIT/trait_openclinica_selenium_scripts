package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ClickingThroughSubjectMatrixStepwiseExtendedVersionTest extends AbstractPerformanceTest {


  public ClickingThroughSubjectMatrixStepwiseExtendedVersionTest(String baseURL, WebDriver driver, long timeOutInSeconds) {
    super(baseURL, driver, timeOutInSeconds);
  }


  public void run(String userID, String userPWD) throws Exception {
    LapTimer lapTimer = new LapTimer();
    lapTimer.startLap();
    driver.get(baseUrl + "/OpenClinica/pages/login/login");
    webDriverHelper.clearAndWrite("username", userID);
    webDriverHelper.clearAndWrite("j_password", userPWD);

    driver.findElement(By.name("submit")).click();
    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - Login");

    driver.findElement(By.linkText("Subject Matrix")).click();
    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - LoadSubjectMatrix_size_15");
    new Select(driver.findElement(By.name("maxRows"))).selectByVisibleText("50");

    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - LoadSubjectMatrix_size_50");
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Next\"]")).click();
//    driver.findElement(By.xpath("//tr[@id='findSubjects_row4']/td[7]/table/tbody/tr/td/a/img")).click();
//    driver.findElement(By.xpath("(//a[contains(text(),'View/Enter Data')])[4]")).click();

    driver.findElement(By.xpath("(//img[@alt='View'])[8]")).click();
    Thread.sleep(1000);
    lapTimer.startLap();
    driver.findElement(By.name("bt_EnterData1")).click();

    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - Section1_Save");
    Select dropdown = new Select(driver.findElement(By.id("sectionTabSelectElement")));
    dropdown.selectByVisibleText("Lab");



    webDriverHelper.clearAndWrite("input33556", "1");

    webDriverHelper.clearAndWrite("input33557", "");

    webDriverHelper.clearAndWrite("input33558", "2");

    webDriverHelper.clearAndWrite("input33559", "");

    webDriverHelper.clearAndWrite("input33560", "3");

    webDriverHelper.clearAndWrite("input33561", "");

    webDriverHelper.clearAndWrite("input33562", "4");

    webDriverHelper.clearAndWrite("input33563", "");

    webDriverHelper.clearAndWrite("input33564", "5");

    webDriverHelper.clearAndWrite("input33565", "");

    webDriverHelper.clearAndWrite("input33566", "6");

    webDriverHelper.clearAndWrite("input33567", "");

    webDriverHelper.clearAndWrite("input33568", "7");

    webDriverHelper.clearAndWrite("input33569", "");

    webDriverHelper.clearAndWrite("input33570", "8");

    webDriverHelper.clearAndWrite("input33571", "");

    webDriverHelper.clearAndWrite("input33572", "9");

    webDriverHelper.clearAndWrite("input33573", "");

    webDriverHelper.clearAndWrite("input33574", "99");
    lapTimer.startLap();
    driver.findElement(By.id("srl")).click();
    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - Section2_Save");


    webDriverHelper.clearAndWrite("input33582", "24:01");

    webDriverHelper.clearAndWrite("input33581", "One plus one makes two");

    webDriverHelper.clearAndWrite("input33582", "00:01");
    lapTimer.startLap();
    driver.findElement(By.id("srl")).click();
    lapTimer.lapAndLog("Extended_Edit_Existing_Subject - Section3_Save");
    driver.findElement(By.linkText("Subject Matrix")).click();
    driver.findElement(By.linkText("Log Out")).click();
    assertEquals("OpenClinica", driver.getTitle());
  }
}
