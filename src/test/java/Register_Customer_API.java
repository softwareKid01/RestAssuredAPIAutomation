import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Register_Customer_API {
    @Test
void RegisterSuccessful(){
    RestAssured.baseURI = "http://demoqa.com/customer";

    //request object
    RequestSpecification httpRequest = RestAssured.given();

    //request parameters / body
    JSONObject requestParams = new JSONObject();
    requestParams.put("FirstName","Hakala");
    requestParams.put("LastName","Hakalovic");
    requestParams.put("UserName","Lolly");
    requestParams.put("Password","Password!");
    requestParams.put("Email","Hakala@yahoo.com");

    httpRequest.header("Content-Type","application/json");

    httpRequest.body(requestParams.toJSONString());

    Response response = httpRequest.request(Method.POST,"/register");


//Validate result
    String responseBody = response.getBody().asString();
    System.out.println("response body " + responseBody);

    int statusCode = response.statusCode();
    Assert.assertEquals(statusCode,201);

    String successCode = response.jsonPath().get("SuccessCode");
    Assert.assertEquals(successCode,"OPERATION_SUCCESS");


}

String [][] getData(){
        String data [][] = {{"tarik","70000","40"},{"tarik","70000","40"},{"tarik","70000","40"}};
        return data;
}
}
