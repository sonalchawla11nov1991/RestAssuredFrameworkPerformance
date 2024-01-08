package peopleStrongApiTest;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostAPITest {
    @BeforeTest
    public void baseTest() throws IOException {
        RestAssured.baseURI="https://staging-goalserver.peoplestrong.com/";
    }

    @Test(priority = 1)
    public void createGoalApiTest(){

        PostAPIBuilder builder=new PostAPIBuilder();
        Response response=RestAssured.given().headers(apiConfigs.HeaderConfigs.headerWithToken())
                .body(builder.createGoalRequestBody()).when().post(APIPath.apiPath.CREATE_GOAL);

        System.out.println("Status Code :- "+response.getStatusCode());
        System.out.println("Response :- "+response.getBody().prettyPrint());

    }
}
