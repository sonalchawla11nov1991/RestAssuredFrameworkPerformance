package studentApiTest;

import apiConfigs.APIPath;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;

public class GetAPITests extends BaseTest {
    @Test
    public void getApiTest() throws IOException {
        /*DurgeshRestAssured*/

        Response response=RestAssured.given().when().headers(apiConfigs.HeaderConfigs.deafultHeaders()).get(APIPath.apiPath.SINGLE_USER);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());
//        System.out.println(response.getHeaders());
//        System.out.println(response.getTime());
//        System.out.println(response.getContentType());
//        Assert.assertEquals(200,response.getStatusCode());

    }
}
