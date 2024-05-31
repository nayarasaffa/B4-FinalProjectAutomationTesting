Feature: Dashboard Feature

  Background:
    Given User telah melakukan Login
    And User berada pada halaman Dashboard

  Scenario: Menambahkan satu barang ke cart
    When User mengklik tombol "Add to Cart" pada salah satu barang
    Then Tombol "Add to Cart" berubah menjadi tombol "Remove"
    And Notifikasi jumlah barang menjadi 1 pada icon cart

  Scenario: Melakukan sorting berdasarkan Nama (Z to A)
    When User mengklik dropdown filter
    And User memilih opsi filter "Name (Z to A)"
    Then  Katalog barang disusun descending berdasarkan nama barang

  Scenario: Melakukan sorting berdasarkan Price (Low to High)
    When User mengklik dropdown filter
    And User memilih opsi filter "Price (low to high)"
    Then  Katalog barang disusun ascending berdasarkan harga barang
