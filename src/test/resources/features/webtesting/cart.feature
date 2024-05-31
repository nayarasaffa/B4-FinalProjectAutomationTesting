Feature: Cart Feature

  Background:
    Given User sudah melakukan Login

  Scenario: Melakukan checkout (terdapat item pada cart)
    Given User sudah menambahkan barang ke cart
    And User sudah berada pada halaman Cart
    When User mengklik tombol Checkout
    Then User dinavigasikan ke halaman checkout

  Scenario: Melakukan continue shipping (terdapat item pada cart)
    Given User sudah menambahkan barang ke cart
    And User sudah berada pada halaman Cart
    When User mengklik tombol Continue Shopping
    Then User dinavigasikan ke halaman dashboard

  Scenario: Melakukan checkout (tidak terdapat item pada cart)
    Given User sudah berada pada halaman Cart
    When User mengklik tombol Checkout
    Then User tetap berada di halaman cart
    And Ditampilkan pesan kesalahan "You Need Item In Cart To Proceed Checkout Process"
