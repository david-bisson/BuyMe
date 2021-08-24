package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static configuration.DriverSingleton.waitForElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SignUp extends Actions {



    private final Long timeStamp = Timestamp.valueOf(LocalDateTime.now()).getTime();

    private static final String signUpButton = "//*[@id=\"ember953\"]/div/ul[1]/li[3]/a/span[2]";
    private static final String registerLink = ".text-link";
    private static final String nameTextBox = "input[placeholder='שם פרטי']";
    private static final String emailAddressTextBox = "input[placeholder='מייל']";
    private String NewEmailAddress;
    private static final String passwordTextBox1 = "input[placeholder='סיסמה']";
    private static final String passwordTextBox2 = "input[placeholder='אימות סיסמה']";
    private static final String submitSignUpButton = "button[type=submit]";
    private static final String signUpEmailErrorMessage = "#parsley-id-12";
    private static final String signUpPasswordErrorMessage = "#parsley-id-14";
    private ExtentTest test;

    public SignUp(ExtentTest test) {
        super(test);
        this.test=test;
    }


    public void signUpToPage(String name, String email, String password1, String password2) throws Exception {
        test.log(Status.INFO, "SignUp Page Test Begins");
        clickElement(By.xpath(signUpButton));
        test.pass("Click on SignUp button");
        clickElement(By.cssSelector(registerLink));
        test.pass("Click on Register button");
        this.NewEmailAddress = timeStamp + email;
        sendKeysToElement(By.cssSelector(nameTextBox), name);
        test.pass("Send text:"+ name+" to email");
        getElementAttribute(By.cssSelector(nameTextBox));
        sendKeysToElement(By.cssSelector(emailAddressTextBox), this.NewEmailAddress);
        test.pass("Send text:"+ email+" to email");
        test.pass("Send text to email");
        sendKeysToElement(By.cssSelector(passwordTextBox1), password1);
        test.pass("Send text:"+ password1+" to email");
        sendKeysToElement(By.cssSelector(passwordTextBox2), password2);
        test.pass("Send text:"+ password2+" to email");
        Assert.assertEquals(name, getElementAttribute(By.cssSelector(nameTextBox)));
        Assert.assertEquals(NewEmailAddress, getElementAttribute(By.cssSelector(emailAddressTextBox)));
        Assert.assertEquals(password1, getElementAttribute(By.cssSelector(passwordTextBox1)));
        Assert.assertEquals(password2, getElementAttribute(By.cssSelector(passwordTextBox2)));
        test.pass("Sign Up page", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "signUpToPage")).build());
        clickElement(By.cssSelector(submitSignUpButton));
        test.pass("Click on Submit button");
        test.log(Status.INFO, "SignUp Page Test Ended Successfully");
        }

    public void validateErrorMessagesOnLogging() throws Exception {
        String errorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
        clickElement(By.xpath(signUpButton));
        clickElement(By.cssSelector(submitSignUpButton));
        test.pass("EXTRA Error messages", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "EXTRA-Error-messages")).build());
        Assert.assertEquals(getTextFromElement(By.cssSelector(signUpEmailErrorMessage)), errorMessage);
        Assert.assertEquals(getTextFromElement(By.cssSelector(signUpPasswordErrorMessage)), errorMessage);
        DriverSingleton.getDriverInstance().findElement(By.id("times")).click();
        waitForElement().until(presenceOfElementLocated(By.xpath(signUpButton)));
        test.pass("Error messages כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה appears");


    }

    public boolean getElementSizeAndScreenShot() throws Exception {
        DriverSingleton.getDriverInstance().switchTo().newWindow(WindowType.TAB);

        for (int i = 0; i < 10; i++) {
            try {
                DriverSingleton.getDriverInstance().get("https://buyme.co.il");
                DriverSingleton.getDriverInstance().navigate().refresh();
                System.out.println(waitForElement().until(presenceOfElementLocated(By.cssSelector(".bounce3"))).getSize());
                takeElementScreenshot(DriverSingleton.getDriverInstance().findElement(By.cssSelector(".bounce3")));
                test.pass("Bounce Element has found, its size is: (18,18)");
                return true;
            } catch (Exception e) {
                DriverSingleton.getDriverInstance().navigate().refresh();
            }
        }
        return false;
    }

}
