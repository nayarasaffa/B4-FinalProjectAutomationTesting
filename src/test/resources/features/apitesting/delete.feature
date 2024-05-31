Feature: Delete User API Test

  Scenario: Melakukan DELETE data User tanpa melakukan proses authorization
    Given App id delete request ""
    And Id user delete request "60d0fe4f5311236168a10a01"
    When Mengirim request DELETE
    Then Respon status code delete request harus 403
    And Respon body delete request harus "{\"error\":\"APP_ID_MISSING\"}"

  Scenario: Melakukan DELETE User by ID dengan ID User valid (ID ada di sistem)
    Given App id delete request "662e5cd6bb70a70ee62595d5"
    And Id user delete request "60d0fe4f5311236168a10a01"
    When Mengirim request DELETE
    Then Respon status code delete request harus 200
    And Respon body delete request harus sesuai dengan JSONSchema "schema_id_only.json"

  Scenario: Melakukan DELETE User by ID dengan ID User tidak valid (ID tidak pernah ada di sistem dan format ID tidak sesuai UUID)
    Given App id delete request "662e5cd6bb70a70ee62595d5"
    And Id user delete request "abc"
    When Mengirim request DELETE
    Then Respon status code delete request harus 400
    And Respon body delete request harus "{\"error\":\"PARAMS_NOT_VALID\"}"

  Scenario: Melakukan DELETE User by ID dengan ID User tidak valid (ID pernah ada di sistem, tetapi sudah di hapus)
    Given App id delete request "662e5cd6bb70a70ee62595d5"
    And Id user delete request "60d0fe4f5311236168a109cb"
    When Mengirim request DELETE
    Then Respon status code delete request harus 404
    And Respon body delete request harus "{\"error\":\"RESOURCE_NOT_FOUND\"}"

  Scenario: Melakukan DELETE User by ID dengan ID User tidak valid (ID user kosong)
    Given App id delete request "662e5cd6bb70a70ee62595d5"
    And Id user delete request ""
    When Mengirim request DELETE
    Then Respon status code delete request harus 404
    And Respon body delete request harus "{\"error\":\"PATH_NOT_FOUND\"}"