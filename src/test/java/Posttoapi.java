package webapiautomation;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Posttoapi extends webapiautomation.BaseClass {

    @Test
    public void postnewuser() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user");

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"liamkelly\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }

}
