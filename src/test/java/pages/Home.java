package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Home extends Actions{

    private static final String amountDropDown = "סכום";
    private static final String amountDropDown99 = "//*[@id='ember1008_chosen']/div/ul/li[2]";
    private static final String regionDropDown = "אזור";
    private static final String regionDropDownMerkaz = "//*[@id=\"ember1023_chosen\"]/div/ul/li[3]";
    private static final String categoryDropDown = "קטגוריה";
    private static final String categoryDropDownRestaurants = "//*[@id=\"ember1033_chosen\"]/div/ul/li[6]";
    private static final String findMeAGiftButton = "#ember1163";


    public void chooseGift() {

        clickElement(By.linkText(amountDropDown));
        clickElement(By.xpath(amountDropDown99));

        clickElement(By.linkText(regionDropDown));
        clickElement(By.xpath(regionDropDownMerkaz));

        clickElement(By.linkText(categoryDropDown));
        clickElement(By.xpath(categoryDropDownRestaurants));

        clickElement(By.cssSelector(findMeAGiftButton));


//        DropDownPicker(By.linkText(amountDropDown),By.linkText(amount));

    }
}
