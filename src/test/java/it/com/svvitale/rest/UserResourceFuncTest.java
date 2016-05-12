package it.com.svvitale.rest;

import com.svvitale.rest.missing.UserResourceModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserResourceFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/users/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        UserResourceModel message = resource.get(UserResourceModel.class);

        //assertEquals("wrong message","Hello World",message.getMessage());
    }
}
