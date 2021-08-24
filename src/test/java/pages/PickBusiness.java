package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.openqa.selenium.By;

public class PickBusiness extends Actions {

    private static final String resturants = "BUYME DINE - מסעדות בפריסה ארצית";
    private static final String amountTextBox = "input[placeholder='הכנס סכום']";
    private static final String submitAmountButton = "button[gtm='בחירה']";
    private ExtentTest test;

    public PickBusiness(ExtentTest test) {
        super(test);
        this.test=test;
    }

    public void pickBusinessAndEnterAmount(String giftAmountValue) throws Exception {
        test.log(Status.INFO, "Pick a business and Send Amount");
        clickElement(By.linkText(resturants));
        test.pass("Click on restaurants button");
        sendKeysToElement(By.cssSelector(amountTextBox),giftAmountValue);
        test.pass("Send Amount Of: "+ giftAmountValue);
        clickElement(By.cssSelector(submitAmountButton));
        test.pass("Sign Up page", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Pick a business and Send Amount")).build());
        test.pass("Click on Submit button");
        test.log(Status.INFO, "Pick a business and Send Amount Ended Successfully");
    }
}
