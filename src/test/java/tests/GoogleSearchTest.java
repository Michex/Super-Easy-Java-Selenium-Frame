package tests;

import data.TestData;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleSearchPage;

import java.io.IOException;

public class GoogleSearchTest extends TestBase {

    private TestData testData;

    @Test
    public void doTestMagic() throws IOException {

        testData = TestData.initTestData();

        String searchValue = testData.getSearchData();

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.checkSearchingValueNameInField(searchValue);
    }

}