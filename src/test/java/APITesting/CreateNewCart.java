package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCart {

    @Test
    void CreateNewCarts(){
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //request parameters / body

        Response response = httpRequest.request(Method.POST,"/carts");


        //Validate result
        String responseBody = response.getBody().asPrettyString();
        System.out.println("response body " + responseBody);

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,201);

        Boolean created = response.jsonPath().get("created");
        Assert.assertTrue(created,"Carts created");

//mBh2XP4nWwlNQ74gK6xmt
    }
}
