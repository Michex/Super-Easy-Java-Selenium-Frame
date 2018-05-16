package tests;

import data.TestData;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleSearchPage;

import java.io.IOException;

public class GoogleSearchTest extends TestBase {

    private TestData testData;

    @DataProvider(name = "googleSearchTest")
    public Object[][] createData() throws IOException {
        testData = TestData.initTestData();
        return new Object[][]{{testData.getSearchValue1()}, {testData.getSearchValue2()}, {testData.getSearchValue3()}
        };
    }

    @Test(dataProvider = "googleSearchTest")
    public void doTestMagic(String searchValue) {

        driver = new FirefoxDriver();
        driver.get(config.getUrl());
        
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.checkSearchingValueNameInField(searchValue);

    }

}