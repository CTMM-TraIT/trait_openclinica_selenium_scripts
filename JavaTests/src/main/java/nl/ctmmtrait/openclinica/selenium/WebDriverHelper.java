package nl.ctmmtrait.openclinica.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jacob on 3/28/17.
 */
public class WebDriverHelper {

    private WebDriver webDriver;
    private long timeoutInSeconds;


    public WebDriverHelper(WebDriver webDriver, long timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
        this.webDriver = webDriver;
    }

    public void clearAndWrite(String elementID, String value) {
        webDriver.findElement(By.id(elementID)).sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
        webDriver.findElement(By.id(elementID)).sendKeys(value);
    }


    public void waitFor(String id) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }
}
