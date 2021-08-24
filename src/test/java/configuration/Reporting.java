package configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Reporting {


//    // create ExtentReports and attach reporter(s)
//    public static ExtentReports extent;
//    // creates a toggle for the given test, adds all log events under it
//    public static ExtentTest test;
//
//    public  void reportBuilder() throws Exception {
//        String cwd = System.getProperty("user.dir");
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
//        extent.attachReporter(htmlReporter);
//        test.log(Status.INFO, "from reporting JAVA ");
//        // screenshot
//        test.pass("details ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), "picName")).build());
//    }
//
//    public  void flushReport() {
//        extent.flush();
//    }

    public static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
