package com.svvitale.rest.missing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.*;
import java.lang.*;

import static javax.ws.rs.core.Response.ok;

/**
 * A resource of message.
 */
@Path("/users")
public class UserResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers(@QueryParam("q") String query, @QueryParam("offset") Integer offset,
                             @QueryParam("limit") Integer limit)
    {
        if (offset == null) {
            offset = 0;
        }

        if (limit == null) {
            limit = 50;
        }

        if (query == null) {
            query = "";
        }

        List<UserResourceModel> matchingUsers = UserResourceModel.find(query);

        // Build a response with the paginated data
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("users", matchingUsers.subList(offset, Math.min(offset + limit, matchingUsers.size())));
        response.put("offset", offset);
        response.put("limit", limit);
        response.put("count", matchingUsers.size());

        return ok(response).build();
    }
}
