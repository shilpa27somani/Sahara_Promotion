package NewSahara;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class List implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configuration() {
        htmlReporter = new ExtentSparkReporter("ExtentListreport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    public void onTestStart(ITestResult result) {
        if (test == null) {
            configuration();
        }
        System.out.println("On Test Start" + result.getName());
        test = reports.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test success" + result.getName());
        test.log(Status.PASS,
                MarkupHelper.createLabel("Name of pass test case " + result.getName(), ExtentColor.GREEN));
        System.out.println(result.getName() + "Test is success");
        test.info("Additional information: This test passed successfully");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("On Test Failure" + result.getName());
        test.log(Status.FAIL,
                MarkupHelper.createLabel("Name of fail test case " + result.getName(), ExtentColor.RED));
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("On Test Skip" + result.getName());
        test.log(Status.SKIP,
                MarkupHelper.createLabel("Name of skip test case " + result.getName(), ExtentColor.YELLOW));
    }

    public void onStart(ITestContext context) {
        System.out.println("Start");

        
    }

    public void onFinish(ITestContext context) {
        System.out.println("Finish");
        reports.flush();
    }
}

