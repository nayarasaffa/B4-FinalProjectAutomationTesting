Feature: Checkout Feature

  Background:
    Given User melakukan login
    And User memasukkan barang "sauce-labs-backpack" ke dalam Cart
    And User masuk ke halaman Cart
    And User klik tombol "Checkout"

  Scenario: Melanjutkan proses checkout dengan pengisian informasi customer yang valid
    When User mengisi formulir informasi
      | firstName | lastName | postalCode |
      | Lebron    | James    | 40121      |
    And User klik tombol "Continue"
    Then Aplikasi menampilkan halaman "Overview Product"

  Scenario: Membatalkan proses checkout saat di halaman Overview Product
    Given User mengisi formulir informasi
      | firstName | lastName | postalCode |
      | Lebron    | James    | 40121      |
    And User klik tombol "Continue"
    When User klik tombol "Cancel"
    Then Aplikasi menampilkan halaman "Cart"

  Scenario: Menyelesaikan proses checkout
    Given User mengisi formulir informasi
      | firstName | lastName | postalCode |
      | Lebron    | James    | 40121      |
    And User klik tombol "Continue"
    When User klik tombol "Finish"
    Then Aplikasi menampilkan halaman "Completed Checkout"