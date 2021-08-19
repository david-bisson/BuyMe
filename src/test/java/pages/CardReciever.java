package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CardReciever extends Actions{

    private static final String receiverNameTextBox= "input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
    private static final String eventNameDropDownList= ".selected-name";
    private static final String eventNameDropDownOption= "li[value='11']";
    private static final String blessingTextBox= "textarea[rows='4']";
    private static final String cleanAllButton= ".textarea-clear-all";
    private static final String continueButton= "button[type='submit']";


    public void fillCaregiverPage(String name, String blessing) {
        waitForElementToAppear(By.cssSelector(receiverNameTextBox));
        sendKeysToElement(By.cssSelector(receiverNameTextBox),name);
        Assert.assertEquals(name,getElementAttribute(By.cssSelector(receiverNameTextBox)));
        clickElement(By.cssSelector(eventNameDropDownList));
        clickElement(By.cssSelector(eventNameDropDownOption));
        clearTextBox(By.cssSelector(blessingTextBox));
        sendKeysToElement(By.cssSelector(blessingTextBox),blessing);
        clickElement(By.cssSelector(continueButton));

    }
}
