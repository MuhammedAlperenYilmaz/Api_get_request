import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_GetRequest {
    @Test
    private void get01() {
        //1 . Create Request URL and Body
        String url = "https://jsonplaceholder.typicode.com/posts/1";
//2. Create expected data
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("userId", 1);
        expectedBody.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
//3. Save a Respose
        Response response = given().when().get(url);
//4. Assertion
        response.
                then().
                contentType(ContentType.JSON)
                .statusCode(200);
        JsonPath actualBody = response.jsonPath();
        Assert.assertEquals(actualBody.get("userId"), expectedBody.get("userId"));
        Assert.assertEquals(actualBody.get("title"), expectedBody.get("title"));


    }
}