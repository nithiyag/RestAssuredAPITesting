import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PostsTest {

    @Test (priority = 0)
    void getPostDetails()
    {
        //specify baseURI
        RestAssured.baseURI="http://localhost:3000/posts";

        //specify request object
        RequestSpecification httpRequest=RestAssured.given();

        //specify response object
        Response response=httpRequest.request(Method.GET,"/45");

        //print response in console
        String responseBody=response.getBody().asString();
        System.out.println("response is:"+responseBody);

        // get status code
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is:"+statusCode);

        //status code verification
        Assert.assertEquals(statusCode,200);
        System.out.println("Status Code verified");

        //get status line
        String statusLine=response.getStatusLine();
        System.out.println("Status Line is:"+statusLine);

        //status line verification
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        System.out.println("Status Line verified");
    }
    @Test (priority = 1)
    void getCommentsDetails(){

        RestAssured.baseURI="http://localhost:3000/comments";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/1");
        String responseBody=response.getBody().asString();
        System.out.println("Response is:"+responseBody);
        int statusCode=response.statusCode();
        System.out.println("Status Code is:"+statusCode);
        Assert.assertEquals(statusCode,200);
        String statusLine=response.statusLine();
        System.out.println("Status LIne is:"+statusLine);
    }

}
