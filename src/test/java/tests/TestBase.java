package tests;

import config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;
    protected ConfigFileReader config;

    @BeforeTest
    public void openBrowserAndUrl() {

        config = new ConfigFileReader();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(config.getURL());

    }

    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
