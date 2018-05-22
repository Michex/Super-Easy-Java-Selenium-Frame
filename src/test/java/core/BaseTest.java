package core;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Report {

    public static RemoteWebDriver driver;
    public static Config config;
    public DesiredCapabilities capability;
    public String browser;

    @BeforeTest
    public void setupTest() throws Exception {

        this.setTestConfig();
        this.setSelenium();
        this.setWindowSize();
        this.setImplicitlyWait();

    }

    private void setTestConfig() throws IOException {
        config = Config.initConfig();
    }

    private void setSelenium() throws MalformedURLException {
        String browser = config.getBrowser();
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName(browser);

        String seleniumServer = "http://" + config.getSeleniumUrl() + ":" + config.getSeleniumPort() + "/wd/hub";
        driver = new RemoteWebDriver(new URL(seleniumServer), capability);

    }

    private void setWindowSize() throws Exception {
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
    }

    private void setImplicitlyWait() {
        int waitTime = config.getWaitTime();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/java/output/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".png"));
        }
    }


    @AfterTest
    public void closeTest() {
        driver.quit();

    }
}
