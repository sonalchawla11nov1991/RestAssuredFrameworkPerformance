package apiVerification;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.Assert;
import utilits.ExtentReportListner;

public class ApiVerification extends ExtentReportListner {
    public static void codeResponseVerification(Response response, int statusCode){
        try {
            Assert.assertEquals(statusCode,response.getStatusCode());
            test.log(LogStatus.PASS,"Successfully verify response code:: "+response.getStatusCode());
        } catch (AssertionError | Exception e) {
            test.log(LogStatus.FAIL,e.fillInStackTrace());
        }
    }

    public static void responseKeyValidationFromJsonObject(Response response,String key){
        try {
            String s = response.getBody().asString();
            if (s.equals(key)) {
                test.log(LogStatus.PASS, "Sucessfully validate value of " + key);
            }
            else {
                test.log(LogStatus.FAIL,"Key is not available");
            }
        }catch (Exception e){
            test.log(LogStatus.FAIL,e.fillInStackTrace());
        }
    }

    public static void timeResponseValidation(Response response){
        try {
            long time = response.time();
            test.log(LogStatus.INFO,"API Response time is = " +time);
        } catch (Exception e) {
            test.log(LogStatus.FAIL,e.fillInStackTrace());
        }
    }
}