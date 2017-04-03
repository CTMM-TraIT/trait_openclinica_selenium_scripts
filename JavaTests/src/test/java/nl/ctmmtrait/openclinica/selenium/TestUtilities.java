package nl.ctmmtrait.openclinica.selenium;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jacob on 3/29/17.
 */
public class TestUtilities {

    @Test
    public void testFormatCurrentTime() {
        // Result of test run: test EditExistingSubject completed successfully at Tue Aug 02 2016 21:31:25 GMT+0200 (W. Europe Standard Time). Duration 15415 ms

        ZoneId zoneId = ZoneId.of("Europe/Amsterdam");
        Instant localDateTime = Instant.parse("2016-08-02T19:31:25Z");

        String result = Utilities.formatDateTime(localDateTime);
        Assert.assertEquals("Tue Aug 02 2016 21:31:25", result);
    }

}
