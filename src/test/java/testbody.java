package webapiautomation;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

//import static ps.webapi.automation.entities.User.ID;
//import static ps.webapi.automation.entities.User.LOGIN;

public class testbody extends webapiautomation.BaseClass {

    @Test
    public void returnsCorrectId() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/all");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        //System.out.println(jsonBody);
        String jsonBody2 = jsonBody.substring(1);
        //System.out.println(jsonBody2);
        String jsonBody3 = jsonBody2.substring(0, jsonBody2.length() - 1);
        //System.out.println(jsonBody3);

        JSONObject jsonObject = new JSONObject(jsonBody3);

        //System.out.println(jsonObject);

        String userID = (String) getValueFor(jsonObject, "id");

        System.out.println(userID);

        Assert.assertEquals(userID, "pepe@pepe.pe1-0.1");
    }


    @Test
    public void returnsCorrectemail() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/all");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        //System.out.println(jsonBody);
        String jsonBody2 = jsonBody.substring(1);
        //System.out.println(jsonBody2);
        String jsonBody3 = jsonBody2.substring(0, jsonBody2.length() - 1);
        //System.out.println(jsonBody3);

        JSONObject jsonObject = new JSONObject(jsonBody3);

        //System.out.println(jsonObject);

        String userID = (String) getValueFor(jsonObject, "email");

        System.out.println(userID);

        Assert.assertEquals(userID, "pepe@pepe.pe1");
    }




    private Object getValueFor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}

