Feature: API Testing for User Management System

Background:
  Given the API base URL 'http://localhost:3000'
  And the authorization header is set
  And the content type is 'application/json'

Scenario: User Registration with Valid Details
  Given the registration endpoint '/api/register'
  When I send a POST request to the endpoint with the following payload:
    | username | email          | password  | confirmPassword |
    | testuser | test@example.com | password123 | password123     |
  Then the response status should be 201
  And the response body should contain a confirmation message
  And the user should be redirected to the login page

Scenario: Password Reset with Registered Email
  Given the password reset endpoint '/api/password-reset'
  When I send a POST request to the endpoint with the following payload:
    | email          |
    | test@example.com |
  Then the response status should be 200
  And the response body should contain a message indicating a password reset email has been sent

Scenario: Registration Page Load Performance
  Given the registration page URL '/register'
  When I measure the time taken for the page to load
  Then the page should load within 2 seconds

Scenario: Security - SQL Injection on Login Form
  Given the login endpoint '/api/login'
  When I send a POST request to the endpoint with the following payload:
    | username | password |
    | ' OR 1=1; -- | ' OR 1=1; -- |
  Then the response status should not be 200
  And the response body should contain an error message
  And the application should not reveal any database information
