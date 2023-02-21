package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCarts {

    //ProductsID that you can put in the carts and only single product
    // you can add to the carts, not multiple at the same time.

    //id ->4643,4646,4641,1225,3674,2585,5851,8739,2177
String cartsId = "mBh2XP4nWwlNQ74gK6xmt";
    @Test
    void AddItemToCarts(){
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //request parameters / body
        JSONObject requestParams = new JSONObject();
        requestParams.put("productId","4643");
        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST,"/carts/"+cartsId+"/items");

        int statusCode = response.statusCode();
       // Assert.assertEquals(statusCode,201);


//mBh2XP4nWwlNQ74gK6xmt
    }
}
