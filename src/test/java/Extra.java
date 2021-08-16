import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static configuration.DriverSingleton.waitForElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Extra {

    @BeforeClass
    public static void runOnceBeforeClass() {
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
    }


    @Test
    public void test01_print_loading_element_size() {
        DriverSingleton.getDriverInstance().navigate().refresh();
        System.out.println(waitForElement().until(presenceOfElementLocated(By.id("app-loading-img"))).getSize());
    }

    @Test
    public void test02_error_messages_on_login() {
        SignUp signUp = new SignUp();
        signUp.validateErrorMessagesOnLogging();
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }
}
