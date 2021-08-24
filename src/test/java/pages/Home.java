package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Home extends Actions {

    private static final String amountDropDown = "סכום";
    private static final String amountDropDown99 = "li[data-option-array-index='1']";
    private static final String regionDropDown = "אזור";
    private static final String categoryDropDown = "קטגוריה";
    private static final String findMeAGiftButton = "תמצאו לי מתנה";
    private ExtentTest test;

    public Home(ExtentTest test) {
        super(test);
        this.test=test;
    }


    public void chooseGift() throws Exception {
        test.log(Status.INFO, "Choose Gist Page Test Begins");
        clickElement(By.linkText(amountDropDown));
        test.pass("Open Amount Drop Down");
        clickElement(By.cssSelector(amountDropDown99));
        test.pass("Choose Amount");
        clickElement(By.linkText(regionDropDown));
        test.pass("Open Region Drop Down");
        clickElement(By.cssSelector(amountDropDown99));
        test.pass("Choose Region");
        clickElement(By.linkText(categoryDropDown));
        test.pass("Open Category Drop Down");
        listClickElement(By.cssSelector(".active-result"), "categoryDropDownRestaurants");
        test.pass("Choose Category");
        clickElement(By.linkText(findMeAGiftButton));
        test.pass("Home Page", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "HomePage")).build());
        test.pass("Click on SignUp button");
        test.log(Status.INFO, "Choose Gift Page Test Ended Successfully");
    }
}
