package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimplePage extends BasePage {

    @FindBy (xpath = "//header//a[contains(text(), 'What we did')]")
    private WebElement buttonField;

    public SimplePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheBtn() {
        buttonField.click();
    }
}
