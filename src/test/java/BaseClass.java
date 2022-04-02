package webapiautomation;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

    public class BaseClass {

        // note that interface and abstract class are not instantiated with keyword new ... see note beow
        // on how to set the Interface variable
        CloseableHttpClient client;
        CloseableHttpResponse response;

        protected static final String BASE_ENDPOINT = "http://ip.jsontest.com/";

        @BeforeMethod
        // so now set the Interface variable by calling the concrete method in the class HttpClientBuilder
        // this is very common .. importing an interface ..this is just a door wth nothing behind ..now you must find the
        // concrete class method to fill in the desired house you want behind door
        public void setup(){
            client  = HttpClientBuilder.create().build();
        }

        @AfterMethod
        public void closeResources() throws IOException {
            client.close();
            response.close();
        }

    }

