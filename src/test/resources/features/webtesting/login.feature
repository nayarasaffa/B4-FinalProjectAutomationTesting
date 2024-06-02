Feature: Login Feature

  Scenario: Login berhasil dengan username dan password valid
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "standard_user" & "secret_sauce"
    And User mengklik button Login
    Then User dinavigasikan ke halaman Dashboard

  Scenario: Login gagal dengan username valid namun password tidak terdaftar
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "standard_user" & "password"
    And User mengklik button Login
    Then User mendapat pesan "Username and password do not match any user in this service"

  Scenario: Login gagal dengan username tidak terdaftar namun password valid
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "user" & "secret_sauce"
    And User mengklik button Login
    Then User mendapat pesan "Username and password do not match any user in this service"

  Scenario: Login gagal dengan username dan password tidak terdaftar
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "user" & "password"
    And User mengklik button Login
    Then User mendapat pesan "Username and password do not match any user in this service"

  Scenario: Login gagal dengan username valid namun password tidak diisi
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "standard_user" & ""
    And User mengklik button Login
    Then User mendapat pesan "You need Password !"

  Scenario: Login gagal dengan username tidak diisi namun password valid
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "" & "secret_sauce"
    And User mengklik button Login
    Then User mendapat pesan "You need Username !"

  Scenario: Login gagal dengan username dan password tidak diisi
    Given User sudah berada di halaman login page pada browser
    When User memasukkan "" & ""
    And User mengklik button Login
    Then User mendapat pesan "You need Username & Password !"