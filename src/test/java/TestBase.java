import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void openBrowserAndUrl() {
        driver = new FirefoxDriver();

        driver.get("http://www.xsolve.pl");

    }

    @AfterTest
    public void closeTest() {

        driver.quit();

    }
}
