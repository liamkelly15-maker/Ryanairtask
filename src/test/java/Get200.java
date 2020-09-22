package ps.webapi.automation;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends ps.webapi.automation.BaseClass {

    //test the GET user request exists
    @Test
    public void getuserReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user?id=pepe%40pepe.pe1-0.1");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    //test the GET userS request exists
    @Test
    public void getusersReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/all");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }



}
