package pages;

import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Payment extends Actions {
    private static final String nowRadioButton = "div[gtm='עכשיו']";
    private static final String laterRadioButton = "div[gtm='במועד מאוחר יותר']";
    private static final String sendGiftViaOption = ".circle";
    private static final String recieverEmailTextBox = "#email";
    private static final String recieverEmailOption = "svg[gtm='method-email']";
    private static final String sendersName = "input[placeholder='שם שולח המתנה']";
    private static final String submitButton = "button[gtm='המשך לתשלום']";


    public void sendGiftTo(String name, String email){
        waitForElementToAppear(By.cssSelector(nowRadioButton));
        clickElement(By.cssSelector(laterRadioButton));
        clickElement(By.cssSelector(nowRadioButton));

        clickElement(By.cssSelector(recieverEmailOption));
        sendKeysToElement(By.cssSelector(recieverEmailTextBox),email);


        clearTextBox(By.cssSelector(sendersName));
        sendKeysToElement(By.cssSelector(sendersName),name);
        Assert.assertEquals(name,getElementAttribute(By.cssSelector(sendersName)));

        clickElement(By.cssSelector(submitButton));

    }

    public void getElementColor() {
        System.out.println(DriverSingleton.getDriverInstance().findElement(By.cssSelector(submitButton)).getCssValue("background-color"));
    }


}
