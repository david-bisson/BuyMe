package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CardReciever extends Actions{

    private static final String receiverNameTextBox= "input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
    private static final String eventNameDropDownList= ".selected-name";
    private static final String eventNameDropDownOption= "li[value='11']";
    private static final String blessingTextBox= "textarea[rows='4']";
    private static final String cleanAllButton= ".textarea-clear-all";
    private static final String continueButton= "button[type='submit']";
    private ExtentTest test;

    public CardReciever(ExtentTest test) {
        super(test);
        this.test=test;
    }


    public void fillCardReceiverPage(String name, String blessing) throws Exception {
        test.log(Status.INFO, "Card Receiver test begins");
        waitForElementToAppear(By.cssSelector(receiverNameTextBox));
        sendKeysToElement(By.cssSelector(receiverNameTextBox),name);
        test.pass("Send "+name+" to " +receiverNameTextBox );
        Assert.assertEquals(name,getElementAttribute(By.cssSelector(receiverNameTextBox)));
        clickElement(By.cssSelector(eventNameDropDownList));
        test.pass("Click on " +eventNameDropDownList);
        waitForElementToAppear(By.cssSelector(eventNameDropDownOption));
        clickElement(By.cssSelector(eventNameDropDownOption));
        test.pass("Click on " +eventNameDropDownOption);
        clearTextBox(By.cssSelector(blessingTextBox));
        test.pass("Click on " +blessingTextBox);
        sendKeysToElement(By.cssSelector(blessingTextBox),blessing);
        test.pass("Send text "+blessing+" to "+blessingTextBox);
        test.pass("Card Receiver", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Card Receiver")).build());
        clickElement(By.cssSelector(continueButton));
        test.pass("Click on " +continueButton);
        test.log(Status.INFO, "Card Receiver test begins ended successfully");

    }
}
