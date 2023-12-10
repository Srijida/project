package generalTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testcase.BaseTest;
import utilities.ExtentUtility;

public class ListenerTestNG extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentUtility.createextentreport();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        test.pass(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
        test.skip("Test Skipped");
    }

    public void onTestFinish(ITestContext context) {
        extent.flush();
    }
}
