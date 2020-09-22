package ps.webapi.automation;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends ps.webapi.automation.BaseClass {

    //test the API is active
    @Test
    public void APIReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    //test the GET user request exists
    @Test
    public void getuserReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user45controller/getUserUsingGET");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    //test the GET userS request exists
    @Test
    public void getusersReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user45controller/getUsersUsingGET");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }



}
