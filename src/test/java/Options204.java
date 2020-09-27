package webapiautomation;

import org.apache.http.client.methods.HttpOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class Options204 extends webapiautomation.BaseClass {

    @Test
    public void optionsReturnsCorrectMethodsList() throws IOException {

        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        String actualValue = webapiautomation.responseheaders.getHeader(response, header);

        Assert.assertEquals(actualValue, expectedReply);
    }
}
