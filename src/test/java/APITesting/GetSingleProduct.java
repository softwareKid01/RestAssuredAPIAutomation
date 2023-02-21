package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleProduct {
    @Test
    void getSingleProduct(){

        int productId = 4643;
        //specify base url
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.GET,"/products/"+productId);


        //print response
        String responseBody = response.getBody().asPrettyString();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(responseBody);

        Assert.assertTrue(responseBody != null);
        int productResponseID = response.jsonPath().get("id");

        Assert.assertEquals(productResponseID,productId);



    }
}
