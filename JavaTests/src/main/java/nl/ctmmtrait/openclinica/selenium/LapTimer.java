package nl.ctmmtrait.openclinica.selenium;

/**
 * Simple class to measure lap-times and log laptimes to System.out
 * Created by jacob on 3/9/17.
 */
public class LapTimer {

    private long startTime;


    public LapTimer() {
    }

    public void startLap() {
        startTime = System.currentTimeMillis();
    }

    public void lapAndLog(String message) {
        // See the file user-extensions-sample.js for the original source
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String endTimeString = Utilities.formatCurrentDateTime();
        message = message.replace(" ", "_");
        String output = "[" + message + "] " + endTimeString + " _Duration " + duration + " ms ";
        System.out.println(output);
        startLap();
    }
}
