package studentApiTest;

import apiConfigs.APIPath;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteApiYTest extends BaseTest {
    /*DurgeshRestAssured*/
    @Test
    public void deleteApiTest(){

        RequestSpecification given = RestAssured.given();
        given.delete(APIPath.apiPath.DELETE_USER);
    }
}
