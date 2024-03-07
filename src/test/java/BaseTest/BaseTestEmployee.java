package BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTestEmployee {

    @BeforeClass
    public void baseUrlTest()  {
        RestAssured.baseURI="https://staging-goalserver.peoplestrong.com/";



    }
}
