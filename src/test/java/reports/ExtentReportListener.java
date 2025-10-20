package reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static String reportPath = "test-output/ExtentReport.html";

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Project", "Your Project Name");
        extent.setSystemInfo("Tester", "Your Name");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        
        // Automatically open the report
        try {
            File htmlFile = new File(reportPath);
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Report file not found to open: " + reportPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
