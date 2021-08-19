import configuration.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Extra {

    @BeforeClass
    public static void runOnceBeforeClass() {
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
    }

    /**
     * I like Javadoc
     */
    @Test
    public void extra() {


        SignUp signUp = new SignUp();

        signUp.validateErrorMessagesOnLogging();

        signUp.signUpToPage("Dudi", "QAExpertsIL@gmail.com", "Dd1122334455", "Dd1122334455");

        Home home = new Home();
        home.chooseGift();

        PickBusiness pickBusiness = new PickBusiness();
        pickBusiness.pickBusinessAndEnterAmount("500");

        CardReciever cardReciever = new CardReciever();
        cardReciever.fillCaregiverPage("David", "שנה טובה ומתוקה");

        Payment payment = new Payment();
        payment.getElementColor();

        // go to https://convertingcolors.com/ and copy paste the result: rgba(255, 161, 38, 1)

        signUp.getElementSizeAndScreenShot();

    }

    @Ignore
    public void test02_error_messages_on_login() {
        SignUp signUp = new SignUp();
        signUp.validateErrorMessagesOnLogging();
    }

    @AfterClass
    public static void tearDown() {
        DriverSingleton.getDriverInstance().quit();
    }
}
