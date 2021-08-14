import configuration.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;
import pages.SignUp;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    @BeforeClass
    public static void runOnceBeforeClass() {
    DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
    DriverSingleton.getDriverInstance().manage().window().maximize();
    }


    @Test
    public void test01_useAngularLocator() {
        SignUp signUp = new SignUp();
        signUp.signUpToPage("Dudi","QAExpertsIL@gmail.com","Dd1122334455","Dd1122334455");

        Home home = new Home();
        home.chooseGift();
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }
}