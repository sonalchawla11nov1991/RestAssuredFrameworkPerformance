package baseTest;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilits.ExtentReportListner;
import utilits.FIleAndEnv;
import java.io.IOException;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner{
    @BeforeClass
    public void baseTest() throws IOException {
        RestAssured.baseURI="http://localhost:3000/";
      //  System.out.println(FIleAndEnv.envAndFile().get("ServerUrl"));
        //  RestAssured.baseURI=FIleAndEnv.envAndFile().get("ServerUrl");
    }
}
