Feature: API Testing for User Authentication and Security

Background:
  Given the API base URL 'http://localhost:3000'
  And the authorization header is set
  And the content type is 'application/json'

Scenario: User Login with Valid Credentials
  Given a user account exists in the database
  When I send a POST request to '/login' with the following payload:
    | username | validUsername |
    | password | validPassword |
  Then the response status should be 200
  And the response should contain a success message
  And the user is redirected to their dashboard

Scenario: User Login with Invalid Credentials
  Given a user account exists in the database
  When I send a POST request to '/login' with the following payload:
    | username | invalidUsername |
    | password | invalidPassword |
  Then the response status should be 401
  And the response should contain an error message
  And the user remains on the login page

Scenario: Password Reset Request
  Given a user account exists in the database
  When I send a POST request to '/password-reset' with the following payload:
    | email | registeredEmail@example.com |
  Then the response status should be 200
  And the response should contain a message indicating that password reset instructions have been sent

Scenario: Login Page Load Time
  Given a stable internet connection
  When I clear the browser cache
  And I navigate to the login page
  Then the page should load completely within 2 seconds

Scenario: System Security for Login Attempts
  Given a user account exists in the database
  When I send multiple POST requests to '/login' with the following payload:
    | username | validUsername |
    | password | incorrectPassword |
  And I repeat this process multiple times
  Then the system should either temporarily lock the account or trigger a security alert after a predefined number of failed attempts
