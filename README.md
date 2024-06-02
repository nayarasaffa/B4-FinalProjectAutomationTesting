### Deskripsi ###
Proyek ini merupakan bagian dari Praktikum Mata Kuliah Pengujian Perangkat Lunak yang bertujuan untuk mempelajari API Testing dan Web Testing dengan pendekatan otomatisasi yang dilakukan pada dua software under test yaitu Program User Controller DummyAPI (https://dummyapi.io/docs) untuk API Testing dan Aplikasi E-Commerce SWAG Labs (https://www.saucedemo.com/) untuk Web Testing.  

### Tujuan ###
- Memahami konsep dasar API Testing
- Menggunakan data dummy dari Dummy API untuk pengujian
- Melakukan pengujian pada data user menggunakan method POST, PUT, DELETE, dan GET.
- Memahami konsep BDD
- Memahami konsep pengujian website secara otomatis
- Memahami penggunaan library selenium dan cucumber, termasuk feature file, step definition, runner test, dan page object model


### Build with / Teknologi ###
Proyek pengujian Web otomatis ini dibangun dengan melibatkan beberapa teknologi, seperti : 
- JUnit
- REST Assured
- Cucumber
- Selenium
- Apache Maven 


### Prerequisite ###
Untuk menjalankan proyek pengujian ini, diperlukan beberapa equipment sebagai persiapan environment proyek :
- Bahasa pemrograman : JDK versi 11
- Build Tool : Apache Maven
- Web Browser : Microsoft Edge Version 125.0
- IDE : Intellij IDEA

### Installation ###
1. Clone repository dengan menjalankan perintah
```
git clone https://github.com/nayarasaffa/B4-FinalProjectAutomationTesting.git`
```
2. Buka proyek menggunakan IDE pemrograman. Kami menyarankan menggunakan IntelliJ
3. Proses instalasi JavaBuild akan dilakukan secara otomatis ketika proyek dibuka dan tunggu hingga proses instalasi selesai.

### Konfigurasi ### 
Proses konfigurasi project menggunakan build automation pada file pom.xml. Semua dependency yang dibutuhkan ditambahkan di dalam dependencies, seperti: 
1. Dependency untuk melakukan pengujian API menggunakan Rest Assured
   ```
   <dependency>
         <groupId>io.rest-assured</groupId>
         <artifactId>rest-assured</artifactId>
         <version>5.4.0</version>
         <scope>test</scope>
   </dependency>
   ```
2. Dependency untuk melakukan validasi skema JSON
   ```
   <dependency>
         <groupId>io.rest-assured</groupId>
         <artifactId>json-schema-validator</artifactId>
         <version>5.3.0</version>
   </dependency>
   ```
3. Dependency untuk menulis step definitions dalam bahasa Java 
    ```
      <dependency>
          <groupId>io.cucumber</groupId>
          <artifactId>cucumber-java</artifactId>
          <version>7.17.0</version>
          <scope>test</scope>
      </dependency>
    ```
    
4. Dependency untuk menjalankan skenario Cucumber dengan JUnit
    ```
    <dependency>
          <groupId>io.cucumber</groupId>
          <artifactId>cucumber-junit</artifactId>
          <version>7.17.0</version>
          <scope>test</scope>
    </dependency>
    ```

5. Dependency untuk mengotomatisasi dalam berinteraksi dengan browser
    ```
    <dependency>
          <groupId>org.seleniumhq.selenium</groupId>
          <artifactId>selenium-java</artifactId>
          <version>4.20.0</version>
    </dependency>
    ```

6. Dependency untuk mengotomatisasi pengujian di browser Microsoft Edge
    ```
     <dependency>
          <groupId>org.seleniumhq.selenium</groupId>
          <artifactId>selenium-edge-driver</artifactId>
          <version>4.20.0</version>
    </dependency>
    ```

### Struktur Proyek ###
Tujuan proyek ini adalah untuk melakukan pengujian API otomatis pada dummy API dan pengujian web otomatis pada website Swag Labs. Kode program untuk melakukan pengujian tersimpan dalam direktori `test`. Berikut adalah struktur proyek secara keseluruhan.
```
edgedriver_win64
src
 ┗ test
 ┃ ┣ java
 ┃ ┃ ┣ helper
 ┃ ┃ ┃ ┗ PageObject.java
 ┃ ┃ ┣ runner
 ┃ ┃ ┃ ┗ TestRunner.java
 ┃ ┃ ┗ stepdefinitions
 ┃ ┃ ┃ ┣ apitesting
 ┃ ┃ ┃ ┃ ┣ CreateSteps.java
 ┃ ┃ ┃ ┃ ┣ DeleteSteps.java
 ┃ ┃ ┃ ┃ ┣ GetSteps.java
 ┃ ┃ ┃ ┃ ┗ UpdateSteps.java
 ┃ ┃ ┃ ┗ webtesting
 ┃ ┃ ┃ ┃ ┣ CartSteps.java
 ┃ ┃ ┃ ┃ ┣ CheckoutSteps.java
 ┃ ┃ ┃ ┃ ┣ DashboardSteps.java
 ┃ ┃ ┃ ┃ ┣ DetailProdukSteps.java
 ┃ ┃ ┃ ┃ ┣ EndToEndSteps.java
 ┃ ┃ ┃ ┃ ┣ LoginSteps.java
 ┃ ┃ ┃ ┃ ┗ MenuSteps.java
 ┃ ┗ resources
 ┃ ┃ ┣ features
 ┃ ┃ ┃ ┣ apitesting
 ┃ ┃ ┃ ┃ ┣ create.feature
 ┃ ┃ ┃ ┃ ┣ delete.feature
 ┃ ┃ ┃ ┃ ┣ get.feature
 ┃ ┃ ┃ ┃ ┗ update.feature
 ┃ ┃ ┃ ┗ webtesting
 ┃ ┃ ┃ ┃ ┣ cart.feature
 ┃ ┃ ┃ ┃ ┣ checkout.feature
 ┃ ┃ ┃ ┃ ┣ dashboard.feature
 ┃ ┃ ┃ ┃ ┣ detailProduk.feature
 ┃ ┃ ┃ ┃ ┣ endtoend.feature
 ┃ ┃ ┃ ┃ ┣ login.feature
 ┃ ┃ ┃ ┃ ┣ logout.feature
 ┃ ┃ ┃ ┃ ┗ menu.feature
 ┃ ┃ ┗ JSONSchemaData
 ┃ ┃ ┃ ┣ create-schema.json
 ┃ ┃ ┃ ┣ schema.json
 ┃ ┃ ┃ ┗ schema_id_only.json

```
- Folder `edgedriver_win64’ berisi file WebDriver untuk menjalankan tes Selenium
- `PageObject.java` pada folder helper berisi kumpulan metode untuk mengotomatisasi interaksi dengan elemen-elemen pada halaman web menggunakan Selenium WebDriver, dengan mengimplementasikan pola desain Page Object Model (POM).
- `TestRunner.java` pada folder runner berisi kode yang digunakan untuk mengonfigurasi dan menjalankan tes otomatis menggunakan Cucumber dan JUnit.
- Semua file yang terdapat pada folder `stepdefinition` merupakan definisi langkah-langkah (step definitions) untuk berbagai skenario pengujian baik untuk API (apitesting) maupun untuk aplikasi web (webtesting). Langkah-langkah ini digunakan oleh Cucumber untuk mencocokkan skenario yang didefinisikan dalam file fitur (.feature) dan menjalankan pengujian sesuai dengan tindakan yang dijelaskan dalam langkah-langkah tersebut.
- Semua file yang terdapat pada folder `features` merupaakan file-file .feature yang mendefinisikan skenario pengujian menggunakan bahasa Gherkin. Setiap file .feature mencakup satu atau lebih skenario yang menggambarkan bagaimana aplikasi seharusnya berperilaku dalam berbagai kondisi.
- Semua file yag terdapat pada folder `JSONSchemaData` digunakan untuk memvalidasi data yang dikirim atau diterima dalam pengujian API.


### How to Run ###
Untuk melakukan eksekusi pengujian web otomatis ini, terdapat dua cara yang dapat dilakukan yaitu menggunakan terminal dan Class Test Runner. 

#### Terminal ####
Langkah-langkah melakukan proses eksekusi web testing menggunakan terminal : 
1. Pastikan terminal berada dalam direktori `/B4-FinalProjectAutomationTesting`
2. Ketik perintah berikut dalam terminal untuk menjalankan program:
    ```
    mvn test
    ```

#### Class Test Runner  ####
Untuk melakukan proses eksekusi API testing melalui class Test Runner cukup dengan melakukan running test dengan menekan icon run pada class file `src/test/java/runner/TestRunner.java` yang ada pada IDE. 

![Runner](https://drive.google.com/uc?export=view&id=1poDelViChW_VPiVPfLYtLwdDDy66UwHV)

### Persiapan data ###
Sebelum melakukan eksekusi program dan menjalankan test case, data test perlu dipersiapkan terlebih dahulu
1. Untuk API Testing
   - Pastikan memiliki app-id yang didapatkan dari website https://dummyapi.io/account
   - Pastikan app-id yang digunakan valid
   - Pastikan id user yang digunakan valid saat menguji GET, UPDATE, dan DELETE
     
2. Untuk Web Testing
   - Username valid (standard_user) dan username invalid
   - Password valid (secret_sauce) dan password invalid

### Fitur software under test ###
1. Untuk API Testing
   Pengujian dilakukan pada program User Controller pada tautan (https://dummyapi.io/docs/user) untuk pengujian :
   - Hit API Get User by id (GET)
   - Hit API Create User (POST)
   - Hit API Update User (PUT)
   - Hit API Delete User by id (DELETE)
     
2. Untuk Web Testing
   Pengujian dilakukan pada aplikasi website Swag Labs (https://www.saucedemo.com/) untuk pengujian :
   - Login
   - Logout
   - Dashboard
   - Detail Produk
   - Menu
   - Cart
   - Checkout
   - End to End 


### Test case ###
1. Untuk API Testing
   Pada proyek ini dibuat lima buah test script untuk setiap jenis pengujian (GET, POST, PUT, DELETE) dari keseluruhan test case, sehingga terdapat 20 test case yang diuji secara otomatis dalam proyek ini, diantaranya :
   - Test Case Get User by id
     - Pengujian get data user tanpa authorization (app-id)
     - Pengujian get data user dengan invalid authorization
     - Pengujian get data user dengan id user valid
     - Pengujian get data user dengan id user invalid (format salah)
     - Pengujian get data user dengan id user valid tetapi tidak ada di sistem
    - Test Case Create User
      - Pengujian create data user dengan input field firstName, lastName, dan email yang valid
      - Pengujian create data user dengan hanya input firstName yang valid
      - Pengujian create data user dengan input seluruh field data user yang valid
      - Pengujian create data user dengan input seluruh field data user yang valid, namun data tersebut sudah ada di sistem sebelumnya (email sudah terdaftar)
      - Pengujian create data user dengan input field timezone invalid (string namun format bukan berupa timezone)
    - Test Case Update User
      - Pengujian update data user dengan id user valid tetapi tidak ada di sistem
      - Pengujian update data user pada field firstName dengan nilai yang valid
      - Pengujian update data user pada field firstName dengan nilai yang invalid (bukan string)
      - Pengujian update data user pada field firstName dengan jumlah karakter kurang dari 2
      - Pengujian update data user pada field email dengan value kosong (“”)
     - Test Case Delete User by id
       - Pengujian delete data user tanpa authorization (app-id)
       - Pengujian delete data user dengan id user valid
       - Pengujian delete data user dengan id user invalid (format salah)
       - Pengujian delete data user dengan id user valid tetapi tidak ada di sistem (sudah dihapus)
       - Pengujian delete data user tanpa id user

2. Untuk Web Testing
   Pada proyek ini, dibuat tujuh skenario pengujian otomatis untuk fitur login, satu skenario untuk logout dan tiga skenario untuk masing-masing fitur dashboard, detail produk, menu, cart dan checkout berdasarkan test case yang telah dibuat sebelumnya serta satu testcase untuk melakukan pengujian end to end yaitu alur dari login sampai pemesanan sukses. Rincian skenario pengujian tersebut adalah sebagai berikut:
   - Login
     - Scenario login berhasil dengan username dan password valid
     - Scenario login gagal dengan username valid namun password invalid (tidak terdaftar)
     - Scenario login gagal dengan username invalid (tidak terdaftar) namun password valid
     - Scenario login gagal dengan username dan password invalid (tidak terdaftar)
     - Scenario login gagal dengan username valid namun password tidak diisi
     - Scenario login gagal dengan username tidak diisi namun password valid
     - Scenario login gagal dengan username dan password tidak diisi
    - Logout
      - Scenario logout berhasil
     - Dashboard
       - Scenario Menambahkan satu barang ke cart
       - Scenario Melakukan sorting berdasarkan Nama (Z to A)
       - Scenario Melakukan sorting berdasarkan Price (Low to High)
      - Detail Produk
        - Scenario Navigasi halaman Detail Product menuju halaman Dashboard
        - Scenario Menambahkan 1 produk ke Cart pada halaman Detail product
        - Scenario Menghapus produk dari Cart pada halaman Detail Product
      - Menu
        - Scenario Membuka Menu pada halaman Dashboard
        - Scenario Menutup Menu pada halaman Dashboard
        - Scenario Verifikasi navigasi menu Reset App pada halaman Dashboard
      - Cart
        - Scenario Melakukan checkout (terdapat item pada cart)
        - Scenario Melakukan continue shipping (terdapat item pada cart)
        - Scenario Melakukan checkout (tidak terdapat item pada cart)
      - Checkout
        - Scenario Melanjutkan proses checkout dengan pengisian informasi customer yang valid
        - Scenario Membatalkan proses checkout saat di halaman Overview Product
        - Scenario Menyelesaikan proses checkout
      - End to End
        - Scenario Melakukan E2E login hingga pemesanan sukses

Untuk lebih lengkapnya seluruh test case dapat dilihat pada tautan berikut :
- [API Testing - Test Cases Design](https://drive.google.com/drive/folders/1FAWxpyWXQ2nQN_xVmBsMS6QIuY95a0ed?usp=drive_link)
- [Web Testing - Test Cases Design](https://drive.google.com/drive/folders/1ggmCwB02qhHpQwwkMn9x1i3nSuYvLodi?usp=drive_link)

### Mengakses Test Report ###
Untuk melihat test report hasil pengujian dapat diakses melalui direktori : `\reports\cucumber.html`


### Anggota ###
1. Aini Nurul Azizah (211524034)
2. Amelia Nathasa (211524036)
3. Nayara Saffa (211524052)

D4 - Teknik Informatika '21

### Referensi ###
- [Maven](https://maven.apache.org/guides/index.html)
- [TestNG](https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html)
- [Rest Assured](https://rest-assured.io/)
- [Rest Assured Tutor](https://www.toolsqa.com/rest-assured-tutorial)
- [Rest Assured Video Tutorial](https://www.youtube.com/watch?v=Orn8cP1yRJc)
- [Cucumber](https://cucumber.io/docs/cucumber/)
- [Cucumber Guides](https://cucumber.io/docs/guides/)
- [Cucumber Course](https://school.cucumber.io/ )
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Selenium Guide](https://www.browserstack.com/guide/selenium-with-java-for-automated-test)

