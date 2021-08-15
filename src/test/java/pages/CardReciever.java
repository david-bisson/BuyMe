package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CardReciever extends Actions{

    private static final String someOneElseOption= "#";
    private static final String receiverNameTextBox= "#ember3084";
    private static final String eventNameDropDownList= ".selected-name";
    private static final String eventNameDropDownOption= "#ember3189";
    private static final String blessingTextBox= "textarea[rows='4']";
    private static final String cleanAllButton= ".textarea-clear-all";
    private static final String uploadPicture= "#";
    private static final String continueButton= "#ember3101";


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
