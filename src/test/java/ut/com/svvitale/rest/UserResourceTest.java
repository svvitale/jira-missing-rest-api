package ut.com.svvitale.rest;

import com.svvitale.rest.missing.UserResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserResourceTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        UserResource resource = new UserResource();

        //Response response = resource.getMessage();
        //final UserResourceModel message = (UserResourceModel) response.getEntity();

        //assertEquals("wrong message","Hello World",message.getMessage());
    }
}
