import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Get_API_Test extends govno{
    @Test
    void getWeathereData(){
        //specify base url
//        RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
//
//        //request object
//        RequestSpecification httpRequest = RestAssured.given();
//
//        //response object
//        Response response = httpRequest.request(Method.GET,"/Sarajevo");
//
//        //print response
//        String responseBody = response.getBody().asString();
//
//        int statusCode = response.statusCode();
//        Assert.assertEquals(statusCode,200);
//        System.out.println(responseBody);
//
//        //status line verification
//        String statusLine = response.getStatusLine();
//        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

        System.out.println(apple);

    }
}
