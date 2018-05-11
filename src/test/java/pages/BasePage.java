package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected void compareTwoValues(String valueFromElement, String value){

        Assert.assertEquals(value, valueFromElement);
    }

}