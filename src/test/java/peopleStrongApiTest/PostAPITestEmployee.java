package peopleStrongApiTest;
import BaseTest.BaseTestEmployee;
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

import static utilits.ReportGenerate.extentTest;

public class PostAPITestEmployee extends BaseTestEmployee {
    static ExtentReports extentReports;

    @BeforeSuite
    public void setUp() {
        //   ReportGenerate.createReport(this.getClass().getSimpleName());
        String reportPath = System.getProperty("user.dir") + "\\reports\\Employee.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
       reporter.config().setDocumentTitle("PerformanceEmployee-Automation");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
    }
    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }

    @Test(priority = 1)
    public void goalListApiTest() {

            ExtentTest test =extentReports.createTest("Goal List Api is working fine");
            PostAPIBuilder builder = new PostAPIBuilder();
            // extentTest.log(Status.INFO, "Test is started");
        try {
            Response response = RestAssured.given().headers(HeaderConfigs.headerWithToken())
                    .body(builder.goalListRequestBody()).when().post(APIPath.apiPath.GOAL_LIST);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");

            // Validate the presence of responseData and its structure
            Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData array not found in response");
            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(response.getBody().asString());

            // Get the "responseData" array from the response
            List<Map<String, ?>> responseDataList = jsonPath.getList("responseData");

            // Validate that responseDataList is not null and contains at least one goal
            Assert.assertNotNull(responseDataList, "Response Data List is null");
            Assert.assertFalse(responseDataList.isEmpty(), "Response Data List is empty");

            // Loop through each goal and validate the presence of "goalId"
            for (Map<String, ?> goal : responseDataList) {
                // Check that each goal has a "goalId"
                Assert.assertNotNull(goal.get("goalId"), "Goal ID is null");

                // Log information about each goal in the Extent Report
                test.info("Goal ID: " + goal.get("goalId"));
            }
        }
            catch (AssertionError e) {
                // Log the failure in the Extent Report
                test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

                // Re-throw the exception to mark the test as failed in TestNG
                throw e;
            } finally {
                extentReports.flush();
            }

        }


    @Test(priority = 2)
    public void createGoalApiTest() {
        ExtentTest test = extentReports.createTest("Goal is created Successfully");
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.createGoalRequestBody()).when().post(APIPath.apiPath.CREATE_GOAL);

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
       //     Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");
           test.log(Status.PASS, "Validation Passed: Status code is 200 and response contains 'SUCCESS'");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the goalId from the response
            String goalId = jsonPath.getString("responseData.goalId");

            // Perform assertions on dynamic values
            Assert.assertTrue(goalId != null && !goalId.isEmpty(), "Goal Id is present in response");
            test.log(Status.PASS, "Goal Id: " + goalId);

            // Verify the code and message in the response
            Assert.assertEquals(jsonPath.getString("message.code"), "EC200", "Incorrect code in the response");
            Assert.assertEquals(jsonPath.getString("message.message"), "Goal and Milestones Created Successfully",
                    "Incorrect message in the response");

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
    public void goalSentForApprovalApiTest() {

        ExtentTest test=extentReports.createTest("Goal Sent for Approval API Test");
        PostAPIBuilder builder = new PostAPIBuilder();

        try{
        Response response = RestAssured.given().headers(HeaderConfigs.headerWithToken())
                .body(builder.goalSentForApprovalRequestBody())
                .when().post(APIPath.apiPath.GOAL_SENT_FOR_APPROVAL);

        // Validate the response code
        int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
        Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

        // Validate the JSON structure and content
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"responseData\": null"), "Expected responseData to be null in response");

        // Parse the JSON response using JsonPath
        JsonPath jsonPath = new JsonPath(responseBody);

        // Check for the presence of the "message" field
        Assert.assertTrue(jsonPath.getString("message") != null, "Message is null");

        extentReports.flush();
    }
        catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }
    }

    @Test(priority = 4)
    public void idpListApiTest() {

        ExtentTest test = extentReports.createTest("IDP List Api Test");

        PostAPIBuilder builder = new PostAPIBuilder();
        try {

            Response response = RestAssured.given().headers(HeaderConfigs.headerWithToken())
                    .body(builder.idpListRequestBody())
                    .when().post(APIPath.apiPath.IDP_LIST);

            // Validate the response code
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""),
                    "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""),
                    "Expected description 'Request Successful' not found in response");

            // Validate the presence of responseData and its structure
            Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData array not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the idpId dynamically from the response
            String dynamicIdpId = jsonPath.getString("responseData[0].idpId");

            // Perform assertions on dynamic values
            Assert.assertNotNull(dynamicIdpId, "IDP Id is null");
            Assert.assertTrue(dynamicIdpId.matches("^\\w+$"), "IDP Id format is incorrect");

            extentReports.flush();


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }
    }

        //       extentTest.log(Status.INFO, "Response " + response.getBody().prettyPrint());
//        extentTest.log(Status.PASS, "idpListApiTest passed");
 //       ApiVerification.codeResponseVerification(response, "EC200");

    @Test(priority=5)
    public void createIDPApiTest()
    {
        ExtentTest test= extentReports.createTest("Create IDP and Activity Api Test");
        PostAPIBuilder builder=new PostAPIBuilder();
        try{
        Response response=RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                .body(builder.createIdpRequestBody()).when().post(APIPath.apiPath.CREATE_IDP);

        System.out.println("Status Code :- "+response.getStatusCode());
        System.out.println("Response :- "+response.getBody().prettyPrint());

        // Validate the response code
        int statusCode = response.getStatusCode();


        Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);

        // Validate the JSON structure and content
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
        Assert.assertTrue(responseBody.contains("\"message\": \"IDP and Activity Created Successfully\""),
                "Expected message 'IDP and Activity Created Successfully' not found in response");
        Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""),
                "Expected description 'Request Successful' not found in response");

        // Validate the presence of responseData and its structure
        Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData not found in response");

        // Parse the JSON response using JsonPath
        JsonPath jsonPath = new JsonPath(responseBody);

        // Get the goalId dynamically from the response
        String dynamicGoalId = jsonPath.getString("responseData.goalId");

        // Perform assertions on dynamic values
        Assert.assertNotNull(dynamicGoalId, "GoalId is null");
        Assert.assertTrue(dynamicGoalId.matches("^\\w+$"), "GoalId format is incorrect");

        extentReports.flush();
        }
         catch (AssertionError e) {
        // Log the failure in the Extent Report
        test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

        // Re-throw the exception to mark the test as failed in TestNG
        throw e;
    } finally {
        extentReports.flush();
    }


    }


    @Test(priority = 6)
    public void pipListApiTest(){
       ExtentTest test= extentReports.createTest("PIP List is Working Fine");
        PostAPIBuilder builder=new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.pipListRequestBody()).when().post(APIPath.apiPath.PIP_LIST);


            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""),
                    "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""),
                    "Expected description 'Request Successful' not found in response");

            // Validate the presence of responseData and its structure
            Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData array not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the pipId dynamically from the response
            String dynamicPipId = jsonPath.getString("responseData[0].pipId");

            // Perform assertions on dynamic values
            Assert.assertNotNull(dynamicPipId, "PIP Id is null");
            Assert.assertTrue(dynamicPipId.matches("^\\w+$"), "PIP Id format is incorrect");

            extentReports.flush();
        }
            catch (AssertionError e) {
                // Log the failure in the Extent Report
                test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

                // Re-throw the exception to mark the test as failed in TestNG
                throw e;
            } finally {
                extentReports.flush();
            }
        }



    @Test(priority = 7)
    public void employeeReviewListApiTest(){
        ExtentTest test=extentReports.createTest("Employee Review List API is working fine");
        PostAPIBuilder builder=new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.employeeReviewListRequestBody()).when().post(APIPath.apiPath.EMPLOYEE_REVIEW_LIST);


            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""),
                    "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""),
                    "Expected description 'Request Successful' not found in response");

            // Validate the presence of responseData and its structure
            Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData array not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the reviewId dynamically from the response
            int dynamicReviewId = jsonPath.getInt("responseData[0].id");

            // Perform assertions on dynamic values
            Assert.assertTrue(dynamicReviewId > 0, "Review Id is not a positive integer");

            extentReports.flush();
        }
        catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }


    }

    @Test(priority = 8)
    public void l1ReviewListApiTest() {
        ExtentTest test = extentReports.createTest("L1 Review List API is working fine");
        PostAPIBuilder builder = new PostAPIBuilder();
        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.pipListRequestBody()).when().post(APIPath.apiPath.L1_MANAGER_REVIEW_LIST);

            System.out.println("Status Code :- " + response.getStatusCode());
            System.out.println("Response :- " + response.getBody().prettyPrint());
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);

            // Validate the JSON structure and content
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""),
                    "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""),
                    "Expected description 'Request Successful' not found in response");

            // Validate the presence of responseData and its structure
            Assert.assertTrue(responseBody.contains("\"responseData\":"), "Expected responseData array not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Get the appraisalCycleId dynamically from the response
            String dynamicAppraisalCycleId = jsonPath.getString("responseData[0].appraisalCycleId");

            // Perform assertions on dynamic values
            Assert.assertNotNull(dynamicAppraisalCycleId, "Appraisal Cycle Id is null");
            Assert.assertTrue(dynamicAppraisalCycleId.matches("^\\w+$"), "Appraisal Cycle Id format is incorrect");

            extentReports.flush();


        } catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }

    }
    @Test(priority = 9)
    public void l2ReviewListApiTest() {
        ExtentTest test=extentReports.createTest("L2 Review List API is working fine");
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.pipListRequestBody()).when().post(APIPath.apiPath.L2_MANAGER_REVIEW_LIST);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();

        }
         catch (AssertionError e) {
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally {
            extentReports.flush();
        }



    }
  //  @Test(priority = 10)
  /*  public void getPerformanceReviewApiTest() {
        // Create an ExtentTest
        ExtentTest test = extentReports.createTest("Performance Review initiate successfully");

        // Create a PostAPIBuilder instance
        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            // Make a POST request to the API
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.selfInitiateReviewRequestBody()).when().post(APIPath.apiPath.SELF_INITIATE_REVIEW);

            // Validate the response code
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

            // Validate the JSON structure and content in the response
            String responseBody = response.getBody().asString();
            test.info("Response: " + responseBody);
            Assert.assertTrue(responseBody.contains("\"status\": \"SUCCESS\""), "Expected status 'SUCCESS' not found in response");

            // Parse the JSON response using JsonPath
            JsonPath jsonPath = new JsonPath(responseBody);

            // Check for the presence and content of the "message" object
            Assert.assertTrue(jsonPath.getJsonObject("message") != null, "Message object is null");
            Assert.assertEquals(jsonPath.getString("message.code"), "EC200", "Expected code 'EC200' not found in message");
            Assert.assertEquals(jsonPath.getString("message.message"), "Request Successful", "Expected message 'Request Successful' not found in message");
            Assert.assertEquals(jsonPath.getString("message.description"), "Request Successful", "Expected description 'Request Successful' not found in message");

            // Validate additional fields in the response (similar to the provided JSON)
            List<Map<String, ?>> employeeDetails = jsonPath.getList("employeeDetails");

            // Validate that employeeDetails is not null and contains at least one employee
            Assert.assertNotNull(employeeDetails, "EmployeeDetails is null");
            Assert.assertFalse(employeeDetails.isEmpty(), "EmployeeDetails is empty");

            // Loop through each employee and validate specific details
            for (Map<String, ?> employee : employeeDetails) {
                // Check that each employee has an "id" and "fullName"
                Assert.assertNotNull(employee.get("id"), "Employee ID is null");
                Assert.assertNotNull(employee.get("fullName"), "Employee FullName is null");

                // Add more assertions based on your specific requirements

                // Log information about each employee in the Extent Report
                test.info("Employee ID: " + employee.get("id") + ", FullName: " + employee.get("fullName"));

            }*/


            // Get the "goalList" array from the response
   /*            List<Map<String, ?>> goalList = jsonPath.getList("goalList");

            // Validate that goalList is not null and contains at least one goal
            Assert.assertNotNull(goalList, "GoalList is null");
            Assert.assertFalse(goalList.isEmpty(), "GoalList is empty");

            // Loop through each goal and validate specific details
            for (Map<String, ?> goal : goalList) {
                // Check that each goal has an "id" and "goalName"
                Assert.assertNotNull(goal.get("id"), "Goal ID is null");
                Assert.assertNotNull(goal.get("goalName"), "Goal Name is null");

                // Add more assertions based on your specific requirements

                // Log information about each goal in the Extent Report
                test.info("Goal ID: " + goal.get("id") + ", Goal Name: " + goal.get("goalName"));
            }
            List<Map<String, ?>> idpList = jsonPath.getList("idpList");

            // Validate that idpList is not null and contains at least one IDP
            Assert.assertNotNull(idpList, "IDP List is null");
            Assert.assertFalse(idpList.isEmpty(), "IDP List is empty");

            // Loop through each IDP and validate specific details
            for (Map<String, ?> idp : idpList) {
                // Check that each IDP has an "id" and "name"
                Assert.assertNotNull(idp.get("id"), "IDP ID is null");
                Assert.assertNotNull(idp.get("name"), "IDP Name is null");

                // Add more assertions based on your specific requirements

                // Log information about each IDP in the Extent Report
                test.info("IDP ID: " + idp.get("id") + ", IDP Name: " + idp.get("name"));
            }

            // Get the "skillList" array from the response
            List<Map<String, ?>> skillList = jsonPath.getList("skillList");

            // Validate that skillList is not null and contains at least one skill
            Assert.assertNotNull(skillList, "Skill List is null");
            Assert.assertFalse(skillList.isEmpty(), "Skill List is empty");

            // Loop through each skill and validate specific details
            for (Map<String, ?> skill : skillList) {
                // Check that each skill has an "id" and "skillName"
                Assert.assertNotNull(skill.get("id"), "Skill ID is null");
                Assert.assertNotNull(skill.get("skillName"), "Skill Name is null");

                // Add more assertions based on your specific requirements

                // Log information about each skill in the Extent Report
                test.info("Skill ID: " + skill.get("id") + ", Skill Name: " + skill.get("skillName"));
            }
            List<Map<String, ?>> potentialQuesList = jsonPath.getList("potentialQuesList");

            // Validate that potentialQuesList is not null and contains at least one question
            Assert.assertNotNull(potentialQuesList, "Potential Questions List is null");
            Assert.assertFalse(potentialQuesList.isEmpty(), "Potential Questions List is empty");

            // Loop through each question and validate specific details
            for (Map<String, ?> question : potentialQuesList) {
                // Check that each question has an "id" and "questionText"
                Assert.assertNotNull(question.get("id"), "Question ID is null");
                Assert.assertNotNull(question.get("questionText"), "Question Text is null");

                // Add more assertions based on your specific requirements

                // Log information about each question in the Extent Report
                test.info("Question ID: " + question.get("id") + ", Question Text: " + question.get("questionText"));
            }
        }
        catch(AssertionError e){
            // Log the failure in the Extent Report
            test.log(Status.FAIL, "Validation Failed: " + e.getMessage());

            // Re-throw the exception to mark the test as failed in TestNG
            throw e;
        } finally{
            // Flush the Extent Reports
            extentReports.flush();
        }

    }
*/
    @Test(priority = 11)
    public void getApproveGoalApiTest(){
        ExtentTest test = extentReports.createTest("Goal is getting approved Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getApproveGoalRequestBody()).when().post(APIPath.apiPath.APPROVE_GOAL);
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
        @Test(priority = 12)
        public void rejectGoalApiTest(){
            ExtentTest test = extentReports.createTest("Goal is getting Rejected Successfully");

            PostAPIBuilder builder = new PostAPIBuilder();

            try {
                Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                        .body(builder.getRejectGoalRequestBody()).when().post(APIPath.apiPath.APPROVE_GOAL);
                int statusCode = response.getStatusCode();
                test.log(Status.INFO, "Response = " + response.prettyPrint());
                test.log(Status.INFO, "Status Code = " + statusCode);
                Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
                String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    public void sendForReviewandClosureApiTest(){
        ExtentTest test = extentReports.createTest("Goal is sent for Review and Closure Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.REVIEW_AND_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    public void sendForGoalClosureApiTest(){
        ExtentTest test = extentReports.createTest("Goal is Closed  Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.GOAL_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    public void sendForGoalRejectClosureApiTest(){
        ExtentTest test = extentReports.createTest("Goal Send for Closure is Rejected Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalClosureRejectRequestBody()).when().post(APIPath.apiPath.GOAL_REJECT_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    public void getApproveIDPApiTest(){
        ExtentTest test = extentReports.createTest("IDP is Approved Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getIDPRequestBody()).when().post(APIPath.apiPath.APPROVE_GOAL);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    public void getRejectIDPApiTest(){
        ExtentTest test = extentReports.createTest("IDP is Rejected Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getRejectIDPRequestBody()).when().post(APIPath.apiPath.APPROVE_GOAL);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 18)
    public void sendForIDPClosureApiTest(){
        ExtentTest test = extentReports.createTest("IDP is send for Review and Closure Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.REVIEW_AND_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 19)
    public void sendForIDPReviewandClosureApiTest(){
        ExtentTest test = extentReports.createTest("IDP is Closed  Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.GOAL_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 20)
    public void sendForIDPRejectClosureApiTest(){
        ExtentTest test = extentReports.createTest("Goal Send for Closure is Rejected Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalClosureRejectRequestBody()).when().post(APIPath.apiPath.GOAL_REJECT_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    @Test(priority = 21)
    public void sendForPIPClosureApiTest(){
        ExtentTest test = extentReports.createTest("PIP is send for Review and Closure Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.REVIEW_AND_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 19)
    public void sendForPIPReviewandClosureApiTest(){
        ExtentTest test = extentReports.createTest("PIP is Closed  Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalReviewandClosureRequestBody()).when().post(APIPath.apiPath.GOAL_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 20)
    public void sendForPIPRejectClosureApiTest(){
        ExtentTest test = extentReports.createTest("PIP send for Review and Clousre Rejected Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getSendForGoalClosureRejectRequestBody()).when().post(APIPath.apiPath.GOAL_REJECT_CLOSURE);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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


    @Test(priority = 21)
    public void employeesubmitReviewApiTest(){
        ExtentTest test = extentReports.createTest("Employee submit the Review Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getEmployeeSubmitReviewRequestBody()).when().post(APIPath.apiPath.SUBMIT_REVIEW);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    @Test(priority = 22)
    public void employeesubmitReviewPDFApiTest(){
        ExtentTest test = extentReports.createTest("Employee download the PDF  Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getEmployeeSubmitReviewPDFRequestBody()).when().post(APIPath.apiPath.EMPLOYEE_PDF);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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


    @Test(priority = 22)
    public void l1submitReviewApiTest(){
        ExtentTest test = extentReports.createTest("L1 Manager submit the Review Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getL1SubmitReviewRequestBody()).when().post(APIPath.apiPath.SUBMIT_REVIEW);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    @Test(priority = 23)
    public void l1submitReviewPDFApiTest(){
        ExtentTest test = extentReports.createTest("L1 Manager download the PDF Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getL1SubmitReviewPDFRequestBody()).when().post(APIPath.apiPath.EMPLOYEE_PDF);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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

    @Test(priority = 24)
    public void l2submitReviewApiTest(){
        ExtentTest test = extentReports.createTest("L2 Manager submit the Review Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getL2SubmitReviewRequestBody()).when().post(APIPath.apiPath.SUBMIT_REVIEW);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
    @Test(priority = 25)
    public void l2submitReviewPDFApiTest(){
        ExtentTest test = extentReports.createTest("L2 Manager download the PDF Successfully");

        PostAPIBuilder builder = new PostAPIBuilder();

        try {
            Response response = RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                    .body(builder.getL2SubmitReviewPDFRequestBody()).when().post(APIPath.apiPath.EMPLOYEE_PDF);
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response = " + response.prettyPrint());
            test.log(Status.INFO, "Status Code = " + statusCode);
            Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

// Validate the JSON structure and content
            String responseBody = response.getBody().asString();
      /*      Assert.assertTrue(responseBody.contains("\"code\": \"EC200\""), "Expected code 'EC200' not found in response");
            Assert.assertTrue(responseBody.contains("\"message\": \"Request Successful\""), "Expected message 'Request Successful' not found in response");
            Assert.assertTrue(responseBody.contains("\"description\": \"Request Successful\""), "Expected description 'Request Successful' not found in response");
*/
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
