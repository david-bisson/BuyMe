package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Payment extends Actions {
    private static final String nowRadioButton = "div[gtm='עכשיו']";
    private static final String laterRadioButton = "div[gtm='במועד מאוחר יותר']";
    private static final String recieverEmailTextBox = "#email";
    private static final String recieverEmailOption = "svg[gtm='method-email']";
    private static final String sendersName = "input[placeholder='שם שולח המתנה']";
    private static final String submitButton = "button[gtm='המשך לתשלום']";
    private ExtentTest test;

    public Payment(ExtentTest test) {
        super(test);
        this.test=test;
    }


    public void sendGiftTo(String name, String email) throws Exception {
        test.log(Status.INFO, "Send Gift To page tests begins");
        waitForElementToAppear(By.cssSelector(nowRadioButton));
        clickElement(By.cssSelector(laterRadioButton));
        test.pass("Click on laterRadioButton");
        clickElement(By.cssSelector(nowRadioButton));
        test.pass("Click on nowRadioButton");
        clickElement(By.cssSelector(recieverEmailOption));
        test.pass("Click on recieverEmailOption");
        sendKeysToElement(By.cssSelector(recieverEmailTextBox),email);
        test.pass("Click on recieverEmailTextBox");
        clearTextBox(By.cssSelector(sendersName));
        test.pass("Click on sendersName");
        sendKeysToElement(By.cssSelector(sendersName),name);
        test.pass("Send text "+name+" to sendersName");
        Assert.assertEquals(name,getElementAttribute(By.cssSelector(sendersName)));
        test.pass("Send gift to page", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Send gift to page")).build());
        clickElement(By.cssSelector(submitButton));
        test.pass("Click on submitButton" );
        test.log(Status.INFO, "Send Gift To page tests ended successfully");
    }
    public void getElementColor() throws Exception {
        System.out.println(DriverSingleton.getDriverInstance().findElement(By.cssSelector(submitButton)).getCssValue("background-color"));
        test.pass("Element Color is: "+ DriverSingleton.getDriverInstance().findElement(By.cssSelector(submitButton)).getCssValue("background-color"));
    }
}
