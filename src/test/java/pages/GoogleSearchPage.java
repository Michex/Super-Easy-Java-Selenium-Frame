package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {


    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchValueElement;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }


    public void checkSearchingValueNameInField(String searchValue) {
        String valueFromElement = searchValueElement.getAttribute("value");
        compareTwoValues(valueFromElement, searchValue);
    }
}
