package apiVerification;

import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import utilits.ReportGenerate;

public class ApiVerification {
    public static void codeResponseVerification(Response response, String expectedCode) {
        try {
            String actualCode = response.jsonPath().getString("message.code");
            Assert.assertEquals(actualCode, expectedCode);

            if (ReportGenerate.extentTest != null) {
                ReportGenerate.extentTest.log(Status.PASS, "Successfully verify response code: " + actualCode);
            }
        } catch (AssertionError | Exception e) {
            if (ReportGenerate.extentTest != null) {
                ReportGenerate.extentTest.log(Status.FAIL, e.fillInStackTrace());
            }
        }
    }

    public static void responseKeyValidationFromJsonObject(Response response, String key) {
        try {
            String responseBody = response.getBody().asString();
            if (responseBody.equals(key)) {
                if (ReportGenerate.extentTest != null) {
                    ReportGenerate.extentTest.log(Status.PASS, "Successfully validate value of " + key);
                }
            } else {
                if (ReportGenerate.extentTest != null) {
                    ReportGenerate.extentTest.log(Status.FAIL, "Key is not available");
                }
            }
        } catch (Exception e) {
            if (ReportGenerate.extentTest != null) {
                ReportGenerate.extentTest.log(Status.FAIL, e.fillInStackTrace());
            }
        }
    }

    public static void timeResponseValidation(Response response) {
        try {
            long time = response.time();
            if (ReportGenerate.extentTest != null) {
                ReportGenerate.extentTest.log(Status.INFO, "API Response time is = " + time);
            }
        } catch (Exception e) {
            if (ReportGenerate.extentTest != null) {
                ReportGenerate.extentTest.log(Status.FAIL, e.fillInStackTrace());
            }
        }
    }
}
