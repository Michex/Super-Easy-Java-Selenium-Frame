package tests;

import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleSearchPage;

public class GoogleSearchTest extends TestBase {

    @Test
    public void doTestMagic() {

        String searchValue = data.getSearchValue();

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.checkSearchingValueNameInField(searchValue);
    }

}