package BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTestDashboard {
    @BeforeClass
    public void baseUrlTest() {
        RestAssured.baseURI = "https://staging-hrms-performancedashboard.peoplestrong.com/";
    }
}
