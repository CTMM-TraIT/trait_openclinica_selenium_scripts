package nl.ctmmtrait.openclinica.selenium;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by jacob on 3/29/17.
 */
public class Utilities {

//    private static final String PATTERN = "EEE MMM dd yyyy HH:mm:ss 'GMT'.SSSZ";

    private static final String PATTERN = "E MMM dd y HH:mm:ss";

    public static String formatCurrentDateTime() {
        // Result of test run: test EditExistingSubject completed successfully at Tue Aug 02 2016 21:31:25 GMT+0200 (W. Europe Standard Time). Duration 15415 ms
        Instant now = Instant.now();
        return formatDateTime(now);
    }

    public static String formatDateTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN)
                                        .withZone( ZoneId.systemDefault() );
        String strDate = formatter.format(instant);
        return strDate;
    }


    /**
     * Switches a web-driver to a relative URL.
     * @param driver the web-driver
     */
    public static void activateMenu(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("nav_Tasks_link"))).build().perform();
    }
}
