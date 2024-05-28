Feature: Create User API Test

  Scenario: Create a new user with required fields only
    Given I have user data
      | firstName | lastName | email                          |
      | Adipati   | Dolken   | aipati_dolken123@gmail.com    |
    When I send a POST request to create the user
    Then the response status code should be 200
    And the response should match with JSONSchema "create-schema.json"

  Scenario: Create a new user with first name only
    Given I have user data
      | firstName |
      | Adipati   |
    When I send a POST request to create the user
    Then the response status code should be 400
    And the response body should be "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"lastName\":\"Path `lastName` is required.\",\"email\":\"Path `email` is required.\"}}"