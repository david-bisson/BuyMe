package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Payment extends Actions {
    private static final String nowRadioButton = "#ember3223";
    private static final String laterRadioButton = "#ember3225";
    private static final String sendGiftViaOption = ".circle";
    private static final String recieverEmailTextBox = "#email";
    private static final String recieverEmailOption = "svg[data-ember-action='3234']";
    private static final String sendersName = "#ember3252";
    private static final String submitButton = "#ember3253";


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


}
