package utilits;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ReportGenerate {
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;

    @BeforeMethod
    public static void createReport(String testName) {
        // Specify the path where the HTML report should be saved
        String reportPath = System.getProperty("user.dir") + "/test-output/" + testName + "_report.html";

        // Create an ExtentSparkReporter and set the path for the report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath).viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR, ViewName.DEVICE }).apply();

        // Create an ExtentReports instance and attach the ExtentSparkReporter
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Create a test instance with the given testName
        extentTest = extentReports.createTest(testName);
    }

    @AfterMethod
    public static void tearDown() {
        // Flush the extent report
        extentReports.flush();
    }
}
