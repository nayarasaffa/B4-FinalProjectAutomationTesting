package stepdefinitions.webtesting;

import helper.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User telah melakukan Login")
    public void user_login() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();
    }

    @Given("User berada pada halaman Dashboard")
    public void navigate_in_dashboard_page() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
    }

    @When("User mengklik tombol {string} pada salah satu barang")
    public void user_mengklik_tombol_pada_salah_satu_barang(String option) {
        if ("Add to Cart".equals(option)) {
            pageObject.clickSauceLabBackpackAddToCart();
        }
    }

    @When("User mengklik dropdown filter")
    public void user_mengklik_dropdown_filter() {
        pageObject.clickFilterDropdown();
    }

    @When("User memilih opsi filter {string}")
    public void user_memilih_opsi_filter(String option) {
        pageObject.selectFilterOption(option);
    }

    @Then("Tombol {string} berubah menjadi tombol {string}")
    public void button_change_to(String oldLabel, String newLabel) {
        if ("Add to cart".equals(oldLabel)) {
            Assert.assertEquals(newLabel, pageObject.getRemoveButtonText());
        } else if ("Remove".equals(oldLabel)){
            Assert.assertEquals(newLabel, pageObject.getAddToCartButtonText());
        }
    }

    @Then("Notifikasi jumlah barang menjadi {int} pada icon cart")
    public void cart_amounts(int expectedCount){
        int actualCount = pageObject.getCartItemCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Then("Katalog barang disusun descending berdasarkan nama barang")
    public void katalog_barang_disusun_descending_berdasarkan_nama_barang() {
        List<String> productNames = pageObject.getProductNames();
        List<String> sortedNames = productNames.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        Assert.assertEquals(sortedNames, productNames);
    }

    @Then("Katalog barang disusun ascending berdasarkan harga barang")
    public void katalog_barang_disusun_ascending_berdasarkan_harga_barang() {
        List<Double> productPrices = pageObject.getProductPrices();
        List<Double> sortedPrices = productPrices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedPrices, productPrices);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
