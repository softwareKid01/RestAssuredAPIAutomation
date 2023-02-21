package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroveryGETallProducts {
    @Test
    void getAllProducts() throws ParseException {
        //specify base url
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.GET,"/products");


        //print response
        String responseBody = response.getBody().asPrettyString();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(responseBody);

        //status line verification
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

        Assert.assertTrue(responseBody != null);

        JSONArray jsonArray = (JSONArray) new JSONParser().parse(responseBody);
        int count = jsonArray.size();
        System.out.println("Number of objects: " + count);
        Assert.assertEquals(count,20);

    }
}
