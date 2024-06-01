Feature: Menu Feature

  Background:
    Given User telah login
    And User berada di halaman dashboard

  Scenario: Membuka Menu pada halaman Dashboard
    When Klik button "garis tiga"
    Then Program menampilkan sidebar Menu di sebelah kiri dan Sidebar Menu memuat:
      | All Items      |
      | About          |
      | Logout         |
      | Reset App State |

  Scenario: Menutup Menu pada halaman Dashboard
    Given Sidebar Menu telah terbuka
    When Klik button "X"
    Then Sidebar menu ditutup

  Scenario: Verifikasi navigasi menu Reset App pada halaman Dashboard
    Given Sidebar Menu telah terbuka
    When Klik button "Reset App State"
    Then Program menampilkan halaman Dashboard
