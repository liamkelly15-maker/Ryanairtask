package webapiautomation;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Posttoapi extends webapiautomation.BaseClass {

    //add a new user record and assert on a status code of 201
    @Test
    public void postnewuser() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user");

        // Define Json to Post and set as Entity
        String json = "{\"name\":\"liam\",\"id\":\"1\",\"bookings\":[],\"email\":\"liam@gmail.com\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }

    //add the same user record and assert on a status code of 403
    @Test
    public void postsameuser() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user");

        // Define Json to Post and set as Entity
        String json = "{\"name\":\"liam\",\"id\":\"1\",\"bookings\":[],\"email\":\"liam@gmail.com\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 409);
    }

}
