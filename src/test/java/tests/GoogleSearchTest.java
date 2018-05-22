package tests;

import core.BaseTest;
import data.SearchValuesData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleSearchPage;

import java.io.IOException;

public class GoogleSearchTest extends BaseTest {

    private SearchValuesData searchValuesData;

    @DataProvider(name = "googleSearchTest")
    public Object[][] createData() throws IOException {
        searchValuesData = SearchValuesData.initTestData();
        return new Object[][]{{searchValuesData.getSearchValue1()}, {searchValuesData.getSearchValue2()}, {searchValuesData.getSearchValue3()}
        };
    }


    @Test(dataProvider = "googleSearchTest")
    public void doTestMagic(String searchValue) {

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.goToPage(config.getUrl());
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.checkSearchingValueNameInField(searchValue);

    }

}