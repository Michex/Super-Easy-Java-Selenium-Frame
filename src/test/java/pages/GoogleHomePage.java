package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }


    public void clickOnTheSearchBtn() {
        searchBtn.click();
    }

    public void fillSearchField(String searchRecord) {

        searchField.sendKeys(searchRecord);

    }
}
