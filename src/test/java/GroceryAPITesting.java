import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroceryAPITesting {

    @Test
    void getAllProducts(){
        //specify base url
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.GET,"/products?category=coffee");


        //print response
        String responseBody = response.getBody().asPrettyString();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(responseBody);

        //status line verification
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }
}
