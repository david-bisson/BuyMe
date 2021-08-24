import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import configuration.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMe Test Report", "Signup E2E flow");

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().get(DriverSingleton.getURL());

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\BuyMe-Test-Report.html");
        extent.attachReporter(htmlReporter);

    }


    @Test
    public void test() throws Exception {
        SignUp signUp = new SignUp(test);
        signUp.signUpToPage("Dudi", "QAExpertsIL@gmail.com", "Dd1122334455", "Dd1122334455");


        Home home = new Home(test);
        home.chooseGift();

        PickBusiness pickBusiness = new PickBusiness(test);
        pickBusiness.pickBusinessAndEnterAmount("500");

        CardReciever cardReciever = new CardReciever(test);
        cardReciever.fillCardReceiverPage("David", "שנה טובה ומתוקה");

        Payment payment = new Payment(test);
        payment.sendGiftTo("Uncle Moses", "mosesfarm@QAExperts.com");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DriverSingleton.getDriverInstance().quit();
        extent.flush();


    }

}
