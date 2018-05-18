package tests;

import config.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public Config config;

    @BeforeTest
    public void setup() throws Exception {

        config = Config.initConfig();
        String browser = config.getBrowser();

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName(browser);

        String seleniumServer = "http://" + config.getSeleniumUrl() + ":" + config.getSeleniumPort() + "/wd/hub";
        driver = new RemoteWebDriver(new URL(seleniumServer), capability);

        String windowSize = config.getWindowSize();

        if (windowSize.equalsIgnoreCase("maximize")) {
            driver.manage().window().maximize();
        } else if (windowSize.contains("x")) {
            String numbers[] = windowSize.split("x");
            int width = Integer.parseInt(numbers[0]);
            int height = Integer.parseInt(numbers[1]);
            Dimension dim = new Dimension(width, height);
            driver.manage().window().setSize(dim);
        } else {
            this.closeTest();
            throw new Exception("Window size is not correct");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
