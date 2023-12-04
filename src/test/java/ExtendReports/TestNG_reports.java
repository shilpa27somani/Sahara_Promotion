package ExtendReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestNG_reports {

	private static ExtentReports extent;
    private static ExtentTest test;

    @Test
    public void setUp() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent.attachReporter(spark);
       // extent.flush();
        
       // Desktop.getDesktop().browse(new File("report.html").toURI());
        test = extent.createTest("MyTest", "This is a sample test.");

        // Log information
        test.log(Status.INFO, "Starting the test...");

        // Your test logic goes here
        extent.flush();

        // Log a pass status
        test.log(Status.PASS, "Test passed successfully!");
        Desktop.getDesktop().browse(new File("report.html").toURI());
        extent.flush();
    }
    
 
}
