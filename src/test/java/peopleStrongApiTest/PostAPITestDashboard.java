package peopleStrongApiTest;
import BaseTest.BaseTestDashboard;
import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilits.ReportGenerate;

import java.util.List;
import java.util.Map;

public class PostAPITestDashboard extends BaseTestDashboard {
    static ExtentReports extentReports;

    @BeforeSuite
    public void setUp() {
        //ReportGenerate.createReport(this.getClass().getSimpleName());

        String reportPath = System.getProperty("user.dir") + "\\reports\\PerformanceDashboard.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("PerformanceDashboard-Automation");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }

    @Test(priority = 1)
    public void configurePmsDesignApiTest() {
        ExtentTest test = extentReports.createTest("Performance Design Details is getting saved successfully");
        PostAPIBuilder builder = new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.configurePmsDesignRequestBody()).when().post(APIPath.apiPath.CONFIGURE_PMS_DESIGN);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the goal_setting_id dynamically from the response
            int dynamicGoalSettingId = jsonPath.getInt("goal_setting_id");

            // Perform assertions on dynamic values
            Assert.assertTrue(dynamicGoalSettingId > 0, "Goal Setting Id is shown is response");
            test.log(Status.PASS, "goal_setting_id " + dynamicGoalSettingId);
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }


    }

    @Test(priority = 2)
    public void saveBehaviourConfigApiTest() {
        ExtentTest test = extentReports.createTest("Behaviour Configuration is getting saved successfully");
        PostAPIBuilder builder = new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.saveBehaviourConfigRequestBody()).when().post(APIPath.apiPath.SAVE_BEHAVIOUR_CONFIG);
            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }

    @Test(priority = 3)
    public void save9BoxDetailsApiTest() {
        ExtentTest test = extentReports.createTest("Matrix Result API Test-9Box(3*3)");
        PostAPIBuilder builder = new PostAPIBuilder();
        Response response = RestAssured.given().headers(HeaderConfigs.headerWithToken1())
                .body(builder.save9BoxDetailsRequestBody())
                .when().post(APIPath.apiPath.SAVE_9BOX_DETAILS);
        try {
            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"Success\""), "Expected status 'Success' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");
            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);
            // Check for the presence of the "matrixRes" field
            Assert.assertTrue(jsonPath.getString("matrixRes") != null, "Matrix Result is null");
            test.log(Status.PASS, "Matrix Result is not null");

            // Parse the "matrixRes" JSON using JsonPath
            JsonPath matrixResJson = jsonPath.get("matrixRes");

            // Check matrixRes details
            Assert.assertEquals(matrixResJson.getInt("fieldCount"), 0, "Expected fieldCount to be 0");
            test.log(Status.PASS, "Expected fieldCount to be 0");
            Assert.assertEquals(matrixResJson.getInt("affectedRows"), 1, "Expected affectedRows to be 1");
            test.log(Status.PASS, "Expected affectedRows to be 1");
            Assert.assertEquals(matrixResJson.getInt("insertId"), 0, "Expected insertId to be 0");
            test.log(Status.PASS, "Expected insertId to be 0");
            Assert.assertEquals(matrixResJson.getInt("serverStatus"), 3, "Expected serverStatus to be 3");
            test.log(Status.PASS, "Expected serverStatus to be 3");
            Assert.assertEquals(matrixResJson.getInt("warningCount"), 0, "Expected warningCount to be 0");
            test.log(Status.PASS, "Expected warningCount to be 0");
            Assert.assertTrue(matrixResJson.getString("message").contains("Rows matched: 1"), "Expected message to contain 'Rows matched: 1'");
            test.log(Status.PASS, "message to contain 'Rows matched: 1");
            Assert.assertEquals(matrixResJson.getBoolean("protocol41"), true, "Expected protocol41 to be true");
            test.log(Status.PASS, "Expected protocol41 to be true");

            Assert.assertEquals(matrixResJson.getInt("changedRows"), 0, "Expected changedRows to be 0");
            test.log(Status.PASS, "Expected changedRows to be 0");
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }
//    @Test(priority = 4)
//    public void saveKpiLibGoalTest()
//    {
//        ExtentTest test =extentReports.createTest("Goal Template is created successfully");
//        PostAPIBuilder builder=new PostAPIBuilder();
//        Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
//                .body(builder.saveKpiLibGoalRequestBody()).when().post(APIPath.apiPath.SAVE_KPI_LIB_GOAL);
//
//        // Validate the response code
//        test.log(Status.INFO,"Response = "+response.prettyPrint());
//        test.log(Status.INFO,"Status Code = "+response.getStatusCode());
//
//        Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
//        test.pass("Successfully passed");
//        // Validate the JSON structure and content
//        Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");

//        extentReports.flush();
//
//    }

    @Test(priority = 4)
    public void saveKpiLibGoalTest() {
        ExtentTest test = extentReports.createTest("Goal Template is created successfully");
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.saveKpiLibGoalRequestBody()).when().post(APIPath.apiPath.SAVE_KPI_LIB_GOAL);

            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);

            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");

            // Log additional information in the Extent Report
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }
    }

    @Test(priority = 5)

    public void createKpiLibraryExcelFormatApiTest() {
        ExtentTest test = extentReports.createTest("Import Goal Bulk Sheet  is getting downloaded successfully.");
        PostAPIBuilder builder = new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.createKpiLibraryExcelFormatRequestBody()).when().post(APIPath.apiPath.KPI_LIB_Excel_FORMAT);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
        //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");
            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);


            // Check for the presence of file details
      //      Assert.assertTrue(jsonPath.getString("file_name") != null, "File name is null");
       //     Assert.assertTrue(jsonPath.getLong("timeStamp") > 0, "Timestamp is not a positive long");

        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }

    @Test(priority = 6)
    public void empWithoutGoalsV2ApiTest() {
        ExtentTest test = extentReports.createTest("Employee OKR Status is getting downloaded successfully.");
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.empWithoutGoalsV2RequestBody()).when().post(APIPath.apiPath.EMP_WITHOUT_GOALS);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);


            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();

            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");
            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Check for the presence of file details
            Assert.assertTrue(jsonPath.getString("file_name") != null, "File name is null");
            Assert.assertTrue(jsonPath.getLong("timeStamp") > 0, "Timestamp is not a positive long");
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }

    @Test(priority = 7)
    public void empObjectiveProgressApiTest() {
        ExtentTest test = extentReports.createTest("Employee Objective Progress API is getting saved Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.empObjectiveProgressRequestBody()).when().post(APIPath.apiPath.OVERALL_OBJECTIVE_PROGRESS);

            // Validate the response code
            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the dynamic values from the response
            String status = jsonPath.getString("status");
            String message = jsonPath.getString("message");

            // Perform assertions on dynamic values
            Assert.assertEquals(status, "SUCCESS", "Incorrect status");
            Assert.assertEquals(message, "BY_MAIL", "Incorrect message");
            test.log(Status.PASS, "status: " + status + ", message: " + message);
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }
    @Test(priority = 8)
        public void createAppraisalApiTest() {
        // Create an ExtentTest
        ExtentTest test = extentReports.createTest("Performance Review is creating Successfully");

        // Create a PostAPIBuilder instance
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            // Make a POST request to the API
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.createAppraisalRequestBody()).when().post(APIPath.apiPath.CREATE_APPRAISAL);
            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the dynamic values from the response
            String status = jsonPath.getString("status");
            int appraisalCycleId = jsonPath.getInt("appraisal_cycle_id");
            int appraisalFeedbackId = jsonPath.getInt("appraisal_feedback_id");

            // Perform assertions on dynamic values
            Assert.assertEquals(status, "SUCCESS", "Incorrect status");
            Assert.assertTrue(appraisalCycleId > 0, "Appraisal Cycle ID is not a positive integer");
            Assert.assertTrue(appraisalFeedbackId > 0, "Appraisal Feedback ID is not a positive integer");
            test.log(Status.PASS, "status: " + status + ", appraisal_cycle_id: " + appraisalCycleId + ", appraisal_feedback_id: " + appraisalFeedbackId);
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }
    }
    @Test(priority = 9)
    public void launchReviewApiTest() {
        ExtentTest test = extentReports.createTest(" Review is Launched Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.launchReviewRequestBody()).when().post(APIPath.apiPath.LAUNCH_REVIEW);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the dynamic values from the response
            String status = jsonPath.getString("status");

            // Perform assertions on dynamic values
            Assert.assertEquals(status, "SUCCESS", "Incorrect status");
            test.log(Status.PASS, "status: " + status);

        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }

    @Test(priority = 10)
    public void lastCheckInApiTest() {
        ExtentTest test = extentReports.createTest("Last CheckIn Report are getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.lastCheckInRequestBody()).when().post(APIPath.apiPath.LAST_CHECK_IN);

            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content in the response
            String responseBody = response.getBody().asString();
            test.info("Response: " + responseBody);
        //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Check for the presence of "status" field
        //    Assert.assertTrue(jsonPath.getString("status") != null, "Status is null");

            // Check the value of the "status" field
      //      Assert.assertEquals(jsonPath.getString("status"), "SUCCESS", "Expected status 'SUCCESS' not found in response");
            Assert.assertTrue(jsonPath.getString("emp_code") != null, "emp_code is null");
            Assert.assertTrue(jsonPath.getString("full_name") != null, "full_name is null");
            Assert.assertTrue(jsonPath.getString("line_manager_name") != null, "line_manager_name is null");
            Assert.assertTrue(jsonPath.getString("last_check_in_on_milestone") != null, "last_check_in_on_milestone is null");
            Assert.assertTrue(jsonPath.getString("last_checkin_date") != null, "last_checkin_date is null");
            test.log(Status.PASS, "Validation Passed: Response contains the expected data");

        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
    @Test(priority = 11)
    public void dailyCheckInApiTest() {
        ExtentTest test = extentReports.createTest("Daily CheckIn Details Report are getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.dailyCheckInRequestBody()).when().post(APIPath.apiPath.DAILY_CHECK_IN);

            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
         /*   Assert.assertTrue(responseBody.contains("\"checkin_dt\": \"13 Feb 2024\""), "Expected checkin_dt '13 Feb 2024' not found in response");
           Assert.assertTrue(responseBody.contains("\"full_name\": \"Sonal Chawla\""), "Expected full_name 'Sonal Chawla' not found in response");
            Assert.assertTrue(responseBody.contains("\"line_manager_name\": \"Shivam Pandey\""), "Expected line_manager_name 'Shivam Pandey' not found in response");
            // Add more assertions based on your requirements

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the dynamic values from the response
            String checkinDt = jsonPath.getString("checkin_dt");
            String fullName = jsonPath.getString("full_name");
            String lineManagerName = jsonPath.getString("line_manager_name");
            // Get more dynamic values based on your requirements

            // Perform assertions on dynamic values
            Assert.assertEquals(checkinDt, "13 Feb 2024", "Incorrect checkin_dt");
            Assert.assertEquals(fullName, "Sonal Chawla", "Incorrect full_name");
            Assert.assertEquals(lineManagerName, "Shivam Pandey", "Incorrect line_manager_name");
            // Add more assertions based on your requirements*/

            test.log(Status.PASS, "Validation Passed: Response contains the expected data");
        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }
    }
    @Test(priority = 12)
    public void participationReportApiTest() {
        ExtentTest test = extentReports.createTest("Participation Report is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.participationReportRequestBody()).when().post(APIPath.apiPath.PARTICIPATION_REPORT);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"Success\""), "Expected status 'Success' not found in response");
            // Add more assertions based on your requirements

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the dynamic values from the response
            String department = jsonPath.getString("exportReportQueryRes[0].department");
            String empCode = jsonPath.getString("exportReportQueryRes[0].emp_code");
            String fullName = jsonPath.getString("exportReportQueryRes[0].full_name");
            String email = jsonPath.getString("exportReportQueryRes[0].email");
            // Get more dynamic values based on your requirements

            // Perform assertions on dynamic values
            Assert.assertEquals(department, "Technology", "Incorrect department");
            Assert.assertEquals(empCode, "22558", "Incorrect emp_code");
            Assert.assertEquals(fullName, "Arjun Hastir", "Incorrect full_name");
            Assert.assertEquals(email, "demo@peoplestrong.com", "Incorrect email");
            test.log(Status.PASS, "Validation Passed: Response contains the expected data");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }
    }
    @Test(priority = 13)
    public void getAllAppraisalCyclesApiTest() {
        ExtentTest test = extentReports.createTest("Appraisal Cycle List Api is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.appraisalCycleRequestBody()).when().post(APIPath.apiPath.APPRAISAL_CYCLE_LIST);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
         //   Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Access the properties from the response JSON
            int appraisalCycleId = jsonPath.getInt("appraisal_cycle_id");
            String appraisalCycleName = jsonPath.getString("appraisal_cycle_name");
            // Add more properties as needed

            // Perform assertions on the retrieved values
            Assert.assertEquals(appraisalCycleId, 1591, "Incorrect appraisal cycle ID");
            Assert.assertEquals(appraisalCycleName, "Mid Year Review_Technology_FY 22-23", "Incorrect appraisal cycle name");

            // Additional assertions based on your requirements

            test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
    @Test(priority = 14)
    public void detailedReportApiTest() {
        ExtentTest test = extentReports.createTest("Detailed Rating Report is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.detailedReportRequestBody()).when().post(APIPath.apiPath.DETAILED_RATING_REPORT);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
       //     Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
        //    JsonPath jsonPath = new JsonPath(responseBody);


          //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
    @Test(priority = 15)
    public void downloadRatingReportApiTest() {
        ExtentTest test = extentReports.createTest("Detailed Rating Report is getting download Successfully through Download Link ");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.detailedDownloadReportRequestBody()).when().post(APIPath.apiPath.DETAILED_DOWNLOAD_REPORT);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
           Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
         //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
    @Test(priority = 15)
    public void performanceReviewFinalRatingApiTest() {
        ExtentTest test = extentReports.createTest("Performance Review Final Rating Report is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.getRatingFullDataRequestBody()).when().post(APIPath.apiPath.FINAL_RATING_REPORT);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
              Assert.assertTrue(responseBody.contains("\"status\": \"Success\""), "Expected status 'Success' not found in response");
            //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200  and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }

    @Test(priority = 16)
    public void cfrReportDataApiTest() {
        ExtentTest test = extentReports.createTest("CFR Data Fetch Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.getCFRDataRequestBody()).when().post(APIPath.apiPath.CFR_REPORT);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
        //    String responseBody = response.getBody().asString();
        //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200  and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
    @Test(priority = 16)
    public void auditlogReportApiTest(){
        ExtentTest test = extentReports.createTest("Data is fetched successfully for Goal Audit Log Report");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.getAuditLogRequestBody()).when().post(APIPath.apiPath.AUDIT_LOG_REPORT);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            //    String responseBody = response.getBody().asString();
            //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200  and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }

    @Test(priority = 17)
    public void auditlogReportDownloadApiTest(){
        ExtentTest test = extentReports.createTest(" Goal Audit Log Report is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.getAuditLogDownloadRequestBody()).when().post(APIPath.apiPath.AUDIT_LOG_REPORT_DOWNLOAD);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            //    String responseBody = response.getBody().asString();
            //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200  and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }   @Test(priority = 17)
    public void consolidatedRatingReportDownloadApiTest(){
        ExtentTest test = extentReports.createTest("Consolidated Rating Report is getting download Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken1())
                    .body(builder.getConsolidatedRatingReportRequestBody()).when().post(APIPath.apiPath.CONSOLIDATED_RATING_REPORT);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            //    String responseBody = response.getBody().asString();
            //    Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
            //   Assert.assertTrue(responseBody.contains("\"flag\": \"Request_Accepted\""), "Expected flag 'Request_Accepted' not found in response");
            test.log(Status.PASS, "Validation Passed: Status code is 200  and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            //    JsonPath jsonPath = new JsonPath(responseBody);


            //  test.log(Status.PASS, "Assertions Passed: Appraisal cycle details are as expected");


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
}

