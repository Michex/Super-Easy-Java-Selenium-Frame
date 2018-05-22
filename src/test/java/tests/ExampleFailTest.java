package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class ExampleFailTest extends BaseTest {

    @Test
    public void superCrazyFail(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.goToPage(config.getUrl());
        Assert.assertTrue(false);
    }
}
