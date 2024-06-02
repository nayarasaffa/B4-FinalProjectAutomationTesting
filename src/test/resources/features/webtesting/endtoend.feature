Feature: End To End Test

  Scenario: Melakukan E2E login hingga pemesanan sukses
    Given User telah melakukan login
    And User sudah berada di halaman dashboard
    When User menekan tombol "Add to Cart" pada produk "Sauce Lab Backpack"
    And User menekan tombol "Cart"
    And User menekan tombol "Checkout"
    And User mengisi formulir informasi dengan data yang valid
      | Field       | Value   |
      | First Name  | Lebron  |
      | Last Name   | James   |
      | Postal Code | 40121   |
    And User menekan tombol "Continue"
    And User menekan tombol "Finish"
    Then Aplikasi menampilkan halaman Completed Checkout
