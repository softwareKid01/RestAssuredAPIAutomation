package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteItemFromCarts {
    @Test
    void deleteItem(){
        String cartsId = "mBh2XP4nWwlNQ74gK6xmt";
        int Id = 313003497;
        //specify base url
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.DELETE,"/carts/:"+cartsId+"/items/:"+Id);


        //print response
        String responseBody = response.getBody().asPrettyString();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);

    }
}
