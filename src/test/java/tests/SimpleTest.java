package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SimplePage;

public class SimpleTest extends TestBase {

    @Test
    public void doTestMagic() {

        SimplePage simplePage = new SimplePage(driver);
        simplePage.clickOnTheBtn();
    }

    @AfterTest
    public void doAfterTest(){


    }
}
