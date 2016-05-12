package com.svvitale.rest.missing;

import com.atlassian.jira.bc.user.search.UserSearchParams;
import com.atlassian.jira.bc.user.search.UserSearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.user.ApplicationUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserResourceModel {

    private ApplicationUser user;

    private UserResourceModel(ApplicationUser user) {
        this.user = user;
    }

    public static List<UserResourceModel> find(String partialUserName) {

        List<UserResourceModel> matchingUsers = new ArrayList<UserResourceModel>();

        // Get the user search service
        UserSearchService userSearchService = ComponentAccessor.getComponent(UserSearchService.class);
        UserSearchParams userSearchParams = new UserSearchParams(true, true, false);

        // Perform the search and turn each user into a serializable result
        for (ApplicationUser user : userSearchService.findUsers(partialUserName, userSearchParams)) {
            matchingUsers.add(new UserResourceModel(user));
        }

        return matchingUsers;
    }

    @XmlElement(name = "id")
    public Long getId() {
        return user.getId();
    }

    @XmlElement(name = "name")
    public String getName() {
        return user.getName();
    }

    @XmlElement(name = "displayName")
    public String getDisplayName() {
        return user.getDisplayName();
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return user.getEmailAddress();
    }

    @XmlElement(name = "key")
    public String getKey() {
        return user.getKey();
    }
}