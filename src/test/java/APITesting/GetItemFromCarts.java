package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GetItemFromCarts {

    @Test
    void getSingleProduct(){
        String cartsId = "mBh2XP4nWwlNQ74gK6xmt";
        int productId = 4643;
        //specify base url
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.GET,"/carts/"+cartsId+"/items");


        //print response
        String responseBody = response.getBody().asPrettyString();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(responseBody);

        Assert.assertTrue(responseBody != null);
        ArrayList productResponseID = response.jsonPath().get("productId");

        Assert.assertEquals(productResponseID,productId);


    }
}
