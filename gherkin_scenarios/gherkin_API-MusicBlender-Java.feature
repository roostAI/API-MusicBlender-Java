Feature: Testing LogController API

Scenario: Verify successful retrieval of all logs
  Given the API base URL 'http://localhost:8080'
  When I send a GET request to '/all'
  Then the response status should be '200'
  And the response should contain a list of logs

Scenario: Verify retrieval of all logs when no logs are available
  Given the API base URL 'http://localhost:8080'
  When I send a GET request to '/all'
  Then the response status should be '200'
  And the response should contain an empty list

Scenario: Verify retrieval of all logs with invalid API endpoint
  Given the API base URL 'http://localhost:8080'
  When I send a GET request to '/all-log'
  Then the response status should be '404'
  And the response should contain the message 'Endpoint not found'

Scenario: Verify retrieval of all logs with unauthorized access
  Given the API base URL 'http://localhost:8080'
  And the user does not provide authorization
  When I send a GET request to '/all'
  Then the response status should be '401'
  And the response should contain the message 'Unauthorized'

Scenario: Verify retrieval of logs with database connection issue
  Given the API base URL 'http://localhost:8080'
  And the database is inaccessible
  When I send a GET request to '/all'
  Then the response status should be '500'
  And the response should contain the message 'Internal Server Error'
