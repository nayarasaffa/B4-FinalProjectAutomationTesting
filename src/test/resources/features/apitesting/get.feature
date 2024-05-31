Feature: Get User API Test

  Scenario: Melakukan GET data User tanpa melakukan proses authorization
    Given App id get request ""
    And Id user get request "60d0fe4f5311236168a109ca"
    When Mengirim request GET
    Then Respon status code get request harus 403
    And Respon body get request harus "{\"error\":\"APP_ID_MISSING\"}"

  Scenario: Melakukan GET data User dengan invalid app-id
    Given App id get request "662e5cd6bb70a70ee62595d6 "
    And Id user get request "60d0fe4f5311236168a109ca"
    When Mengirim request GET
    Then Respon status code get request harus 403
    And Respon body get request harus "{\"error\":\"APP_ID_NOT_EXIST\"}"

  Scenario: Melakukan GET User by ID dengan ID User valid (ID ada di sistem)
    Given App id get request "662e5cd6bb70a70ee62595d5"
    And Id user get request "60d0fe4f5311236168a109ca"
    When Mengirim request GET
    Then Respon status code get request harus 200
    And Respon body get request harus sesuai dengan JSONSchema "schema.json"

  Scenario: Melakukan GET User by ID dengan ID User tidak valid (ID tidak pernah ada di sistem dan format ID salah)
    Given App id get request "662e5cd6bb70a70ee62595d5"
    And Id user get request "abc"
    When Mengirim request GET
    Then Respon status code get request harus 400
    And Respon body get request harus "{\"error\":\"PARAMS_NOT_VALID\"}"

  Scenario: Melakukan GET User by ID dengan ID User tidak valid (ID pernah ada di sistem, tetapi sudah di hapus)
    Given App id get request "662e5cd6bb70a70ee62595d5"
    And Id user get request "60d0fe4f5311236168a109cb"
    When Mengirim request GET
    Then Respon status code get request harus 404
    And Respon body get request harus "{\"error\":\"RESOURCE_NOT_FOUND\"}"