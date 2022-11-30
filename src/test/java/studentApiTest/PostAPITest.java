package studentApiTest;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerification.ApiVerification;
import baseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import utilits.JavaUtillRandom;

public class PostAPITest extends BaseTest {
    @Test(priority = 1)
    public void postApiTest(){
        /*DurgeshRestAssured*/
        test.log(LogStatus.INFO,"Test is started");
        Response response = RestAssured.given().when().headers(HeaderConfigs.deafultHeaders())
                .body(PostAPIBuilder.postRequestBody(JavaUtillRandom.randomNumbr(),JavaUtillRandom.randomStrngTitle(),JavaUtillRandom.randomStrngAuthor()))
                .when()
                .post(APIPath.apiPath.CREATE_USER);
        ApiVerification.codeResponseVerification(response,201);
        ApiVerification.responseKeyValidationFromJsonObject(response,"title");
        ApiVerification.timeResponseValidation(response);
    }

    @Test(priority = 2)
    public void postValidationApiTest(){

        PostAPIBuilder builder=new PostAPIBuilder();

        Response response=RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                .body(builder.postValidationBody()).when().post(APIPath.apiPath.CREATE_USER);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());

    }
}
