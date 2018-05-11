package tests;

import config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected ConfigFileReader config;
    protected WebDriver driver;

    @BeforeTest
    public void openBrowserAndUrl() {

        config = new ConfigFileReader();
        driver = new FirefoxDriver();
        driver.get(config.getURL());


    }

    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
