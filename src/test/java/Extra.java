import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Extra {
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMe EXTRA Test Report", "Signup E2E flow");

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverSingleton.getDriverInstance().get(DriverSingleton.getURL());

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\EXTRA-extent.html");
        extent.attachReporter(htmlReporter);
    }

    /**
     * I like Javadoc
     */
    @Test
    public void extra() throws Exception {
        SignUp signUp = new SignUp(test);
        signUp.validateErrorMessagesOnLogging();
        signUp.signUpToPage("Dudi", "QAExpertsIL@gmail.com", "Dd1122334455", "Dd1122334455");
        test.info("EXTRA signup Passed");

        Home home = new Home(test);
        home.chooseGift();
        test.info("EXTRA Home Passed");

        PickBusiness pickBusiness = new PickBusiness(test);
        pickBusiness.scrollToElement(By.cssSelector(".buyme-footer-logo")); // SCROLL TO BOTTOM OF THE PAGE
        pickBusiness.pickBusinessAndEnterAmount("500");
        test.info("EXTRA pickBusiness Passed");

        CardReciever cardReciever = new CardReciever(test);
        cardReciever.fillCardReceiverPage("David", "שנה טובה ומתוקה");
        test.info("EXTRA fillCardReceiverPage Passed");


        Payment payment = new Payment(test);
        payment.getElementColor();
        test.info("EXTRA getElementColor passed");

        // go to https://convertingcolors.com/ and copy paste the result: rgba(255, 161, 38, 1)

        signUp.getElementSizeAndScreenShot();
        test.info("EXTRA getElementSizeAndScreenShot Passed");

    }

    @Ignore
    public void test02_error_messages_on_login() throws Exception {
        SignUp signUp = new SignUp(test);
        signUp.validateErrorMessagesOnLogging();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DriverSingleton.getDriverInstance().quit();
        extent.flush();

    }
}
