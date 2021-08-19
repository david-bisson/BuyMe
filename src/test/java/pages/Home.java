package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Home extends Actions {

    private static final String amountDropDown = "סכום";
    private static final String amountDropDown99 = "li[data-option-array-index='1']";
    private static final String regionDropDown = "אזור";
    private static final String categoryDropDown = "קטגוריה";
    private static final String findMeAGiftButton = "תמצאו לי מתנה";


    public void chooseGift() {
        clickElement(By.linkText(amountDropDown));
        clickElement(By.cssSelector(amountDropDown99));
        clickElement(By.linkText(regionDropDown));
        clickElement(By.cssSelector(amountDropDown99));
        clickElement(By.linkText(categoryDropDown));
        listClickElement(By.cssSelector(".active-result"), "categoryDropDownRestaurants");
        clickElement(By.linkText(findMeAGiftButton));
    }
}
