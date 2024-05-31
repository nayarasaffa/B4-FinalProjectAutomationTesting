Feature: Update User API Test

  Scenario: Update user dengan id user invalid
    Given telah dilakukan authorization dengan app-id valid
    And memiliki id user yaitu "60d0fe4f5311236168a109dc"
    When mengirimkan request PUT
    Then status code harus 404
    And response body harus "{\"error\":\"RESOURCE_NOT_FOUND\"}"
    And response harus sesuai skema JSON "schema.json"

  Scenario: Update firstname user dengan data valid
    Given telah dilakukan authorization dengan app-id valid
    And memiliki id user yaitu "60d0fe4f5311236168a109cc"
    When mengirimkan request PUT
    And data firstname baru yaitu "Rachel"
    Then status code harus 200
    And response harus sesuai skema JSON "schema.json"

  Scenario: Update firstname user dengan data invalid
    Given telah dilakukan authorization dengan app-id valid
    And memiliki id user yaitu "60d0fe4f5311236168a109cc"
    When mengirimkan request PUT
    And data firstname baru yaitu 123
    Then status code harus 200
    And response harus sesuai skema JSON "schema.json"

  Scenario: Update firstname user kurang dari 2 karakter
    Given telah dilakukan authorization dengan app-id valid
    And memiliki id user yaitu "60d0fe4f5311236168a109cc"
    When mengirimkan request PUT
    And data firstname baru yaitu "a"
    Then status code harus 200
    And response harus sesuai skema JSON "schema.json"

  Scenario: Update email user dengan data kosong
    Given telah dilakukan authorization dengan app-id valid
    And memiliki id user yaitu "60d0fe4f5311236168a109cc"
    When mengirimkan request PUT
    And data email baru yaitu " "
    Then status code harus 200
    And response harus sesuai skema JSON "schema.json"
