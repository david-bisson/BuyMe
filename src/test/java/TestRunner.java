import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    @BeforeClass
    public static void runOnceBeforeClass() {
    DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverSingleton.getDriverInstance().manage().window().maximize();
    DriverSingleton.getDriverInstance().get("https://buyme.co.il/");

    }


    @Test
    public void test() {
        SignUp signUp = new SignUp();
        signUp.signUpToPage("Dudi","QAExpertsIL@gmail.com","Dd1122334455","Dd1122334455");

        Home home = new Home();
        home.chooseGift();

        PickBusiness pickBusiness = new PickBusiness();
        pickBusiness.pickBusinessAndEnterAmount("500");

        CardReciever cardReciever = new CardReciever();
        cardReciever.fillCaregiverPage("David","שנה טובה ומתוקה");

        Payment payment = new Payment();
        payment.sendGiftTo("Uncle Moses","mosesfarm@QAExperts.com");
    }

    @AfterClass
    public static void tearDown() {
       DriverSingleton.getDriverInstance().quit();
    }
}
