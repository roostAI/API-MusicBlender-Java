Feature: LogController API Integration Testing

  Background:
    Given the API base URL 'http://localhost:8080'

  Scenario: Successfully retrieve all logs
    When I send a GET request to '/all'
    Then the response status should be 200
    And the response should contain a list of logs

  Scenario: Attempt to retrieve logs when none exist
    Given the log repository is empty
    When I send a GET request to '/all'
    Then the response status should be 200
    And the response should contain an empty list
