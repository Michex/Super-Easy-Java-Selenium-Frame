package tests;

import data.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected Data data;

    @BeforeTest
    public void openBrowserAndUrl() throws IOException {

        data = Data.get();
        driver = new FirefoxDriver();
        driver.get(data.getUrl());

    }

    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
