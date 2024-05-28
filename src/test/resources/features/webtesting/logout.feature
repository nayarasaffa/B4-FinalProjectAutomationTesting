Feature: Logout Feature
  Scenario: Logout berhasil
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "standard_user" & "secret_sauce"
    And User mengklik button Login
    And User mengklik icon menu di halaman dashboard
    And User memilih opsi "Logout"
    Then User dinavigasikan ke halaman login page