package utilits;

import com.aventstack.extentreports.model.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportListner implements ITestListener {
    protected static ExtentReports reports;
    protected  static ExtentTest test;

    private static String resultPath= getResultPath();
    public static void deleteDirectory(File directory){
        if (directory.exists()){
            File[] files=directory.listFiles();
            if(null!=files){
                for (int i=0;i<files.length;i++){
                    System.out.println(files[i].getName());
                    if (files[i].isDirectory()){
                        deleteDirectory(files[i]);
                    }else{
                        files[i].delete();
                    }
                }
            }
        }
    }
    private static String getResultPath(){
        resultPath="test";
        if (!new File(resultPath).isDirectory()){
            new File(resultPath);
        }
        return resultPath;
    }
    String ReportLocation="test-output/Report/"+resultPath+"/";

    public void onTestStart(ITestResult result){
        test=reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO,result.getMethod().getMethodName());
        System.out.println(result.getTestClass().getTestName());
        System.out.println(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result){
        test.log(LogStatus.PASS,"Test is Pass");
    }
    public void onTestFailure(ITestResult result){
        test.log(LogStatus.FAIL,"Test is fail");
    }
    public void onTestSkip(ITestResult result){
        test.log(LogStatus.SKIP,"Test is skip");
    }
    public void onStart(ITestResult result){
        System.out.println(ReportLocation+"  ReportLocation");
        reports=new ExtentReports(ReportLocation+"ExtentReport.html");
        test=reports.startTest("");
    }
    public void onFinish(ITestResult result){
        reports.endTest(test);
        reports.flush();
    }

}
