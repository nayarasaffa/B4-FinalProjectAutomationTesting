Feature: Create User API Test

  Scenario: Create user baru hanya dengan mengisi field yang diperlukan
    Given Saya memiliki data user
      | firstName | lastName | email                          |
      | Adipati   | Dolken   | adipatidolken@mail.cc         |
    When Saya mengirim permintaan POST untuk create user
    Then Kode respons adalah 200
    And Responnya harus sesuai dengan JSONSchema "create-schema.json"

  Scenario: Create user baru hanya dengan mengisi field firstName
    Given Saya memiliki data user
      | firstName |
      | Adipati   |
    When Saya mengirim permintaan POST untuk create user
    Then Kode respons adalah 400
    And Isi respons body adalah "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"lastName\":\"Path `lastName` is required.\",\"email\":\"Path `email` is required.\"}}"

  Scenario: Create user baru dengan mengisi semua field
    Given Saya memiliki data user
      | title | firstName | lastName | picture                                        | gender | email                  | dateOfBirth | phone         | street         | city    | state     | country  | timezone |
      | mr    | Ten       | Lee      | https://randomuser.me/api/portraits/men/61.jpg | male   | tenlee@mail.cc        | 1996-02-27  | +613372837823 | Wutthakad Road | Bangkok | Chomthong | Thailand | GMT+7    |
    When Saya mengirim permintaan POST untuk create user
    Then Kode respons adalah 200
    And Responnya harus sesuai dengan JSONSchema "create-schema.json"

  Scenario: Create user baru dengan data yang sudah ada
    Given Saya memiliki data user
      | title | firstName | lastName | picture                                        | gender | email                  | dateOfBirth | phone         | street         | city    | state     | country  | timezone |
      | mr    | Ten       | Lee      | https://randomuser.me/api/portraits/men/61.jpg | male   | tenlee@mail.cc        | 1996-02-27  | +613372837823 | Wutthakad Road | Bangkok | Chomthong | Thailand | GMT+7    |
    When Saya mengirim permintaan POST untuk create user
    Then Kode respons adalah 400
    And Isi respons body adalah "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"email\":\"Email already used\"}}"

  Scenario: Create user baru dengan mengisi field Timezone invalid
    Given Saya memiliki data user
      | title | firstName | lastName | picture                                          | gender | email                       | dateOfBirth               | phone        | street          | city        | state    | country                  | timezone |
      | mrs   | Angelina  | Jolie    | https://randomuser.me/api/portraits/women/60.jpg | female | angelinajolie456@mail.cc   | 1975-06-04T08:26:49.610Z  | +91091212292 | S. Roberts Road | Palos Hills | Illinois | United States of America | 4        |
    When Saya mengirim permintaan POST untuk create user
    Then Kode respons adalah 400
    And Isi respons body adalah "{\"error\":\"BODY_NOT_VALID\"}"