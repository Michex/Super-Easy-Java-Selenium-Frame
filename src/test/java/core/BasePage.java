package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected void compareTwoValues(String valueFromElement, String value) {

        Assert.assertEquals(value, valueFromElement);
    }

    public void goToPage(String url) {

        driver.get(url);
    }

}