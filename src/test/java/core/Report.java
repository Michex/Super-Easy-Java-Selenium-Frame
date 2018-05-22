package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.lang.reflect.Method;

public class Report {

    static ExtentReports reports;
    static ExtentTest testInfo;
    static ExtentHtmlReporter htmlReporter;

    @BeforeTest
    public void setup(){
        htmlReporter = new ExtentHtmlReporter(new File("src/test/java/output/AutomationReports.html"));
        htmlReporter.loadXMLConfig(new File("Extent-Config.xml"));
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void register(Method method){
        String testName = method.getName();
        testInfo = reports.createTest(testName);
    }

    @AfterMethod
    public void captureStatus(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS) {
            testInfo.log(Status.PASS, "Test: " + result.getName() + " is passed");
        }else if(result.getStatus() == ITestResult.FAILURE){
            testInfo.log(Status.FAIL, "Test: " + result.getName() + " is failed");
            testInfo.log(Status.FAIL, "Test failure: " + result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
        testInfo.log(Status.PASS, "Test: " + result.getName() + " is skiped");
     }
    }

    @AfterTest
    public void cleanUp(){
       reports.flush();
    }

}
