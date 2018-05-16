package tests;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected Config config;

    @BeforeTest
    public void openBrowserAndUrl() throws IOException {

        config = Config.initConfig();



    }

    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
