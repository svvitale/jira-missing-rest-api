Very simple JIRA plugin built to address the lack of a way to query for all users in a JIRA instance.  Original
impetus here: https://jira.atlassian.com/browse/JRA-29069

# Example Usage

After installation, all REST endpoints provided by this plugin are accessible at:

```
http://<your jira server>/<your jira context>/rest/missing/latest/
```

## Users (/users)

### GET

Returns a paginated list of matching users.

Parameter | Usage | Default
--- | --- | ---
q | Query for users matching this string. Empty returns all users | ""
offset | User index to start from | 0
limit | Maximum number of users to return | 50

Example Request:
`GET /jira/rest/missing/latest/users?q=username&offset=0&limit=50`

Example Response:
```
{
  "offset": 0,
  "limit": 50,
  "count": 1000,
  "users": [
    {
      "name": "user143",
      "key": "user143",
      "id": 10242,
      "displayName": "Test User 143",
      "email": "user143@bogus.com"
    },
    {
      "name": "user144",
      "key": "user144",
      "id": 10243,
      "displayName": "Test User 144",
      "email": "user144@bogus.com"
    }
    ...
  ]
}
```

# Housekeeping

Still need to add tests and better icons :)

Pull requests welcome.
