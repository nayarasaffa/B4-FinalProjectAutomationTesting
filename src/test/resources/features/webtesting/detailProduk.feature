Feature: Detail Produk Feature

  Background:
    Given User telah Login
    And User berada pada halaman Detail Produk

  Scenario: Navigasi halaman Detail Product menuju halaman Dashboard
    When User mengklik tombol "Back to products"
    Then User kembali ke halaman Dashboard

  Scenario: Menambahkan 1 produk ke Cart pada halaman Detail product
    When User mengklik tombol "Add to cart"
    Then Tombol "Add to cart" berubah menjadi "Remove"
    And Jumlah barang pada cart adalah 1

  Scenario: Menghaus produk dari Cart pada halaman Detail Product
    Given User mengklik tombol "Add to cart"
    And Tombol "Add to cart" berubah menjadi "Remove"
    Then User mengklik tombol "Remove"
    And Tombol "Remove" berubah menjadi "Add to cart"
    And Jumlah barang pada cart adalah 0