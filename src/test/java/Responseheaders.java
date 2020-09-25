package WebApiAutomation;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import java.util.Arrays;
import java.util.List;

public class Responseheaders extends WebApiAutomation.BaseClass {

    public static String getHeader(CloseableHttpResponse response, String headerName) {

        // Get All headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        // Loop over the headers list
        for(Header header : httpHeaders){
            //System.out.println(header);
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader = header.getValue();

            }
        }
        // If no header found - throw an exception
        if(returnHeader.isEmpty()){
            //throw new RuntimeException("Didn't find the header: " + headerName);
            System.out.println("Didn't find the header: " + headerName+ "  - Test Failed");
        }
        // Return the header
        return returnHeader;
    }

    //Test for the Server Header
    @Test
    public void serverIsRyanair() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        String headerValue = getHeader(response, "Server");

        assertEquals(headerValue, "http://localhost:8080");
    }

    //Test for the Content-Type Header
    @Test
    public void headercontenttype() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        String headerValue = getHeader(response, "Content-Type");

        assertEquals(headerValue, "application/json;charset=UTF-8");
    }

}
