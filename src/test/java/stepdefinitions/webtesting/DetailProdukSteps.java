package stepdefinitions.webtesting;

import helper.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DetailProdukSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User telah Login")
    public void user_login() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();
    }

    @Given("User berada pada halaman Detail Produk")
    public void navigate_to_detail_produk(){
        pageObject.clickDetailProduct();
    }

    @When("User mengklik tombol {string}")
    public void navigate_to_detail_produk(String option){
        if ("Back to products".equals(option)) {
            pageObject.clickBackToProduct();
        } else if ("Add to cart".equals(option)){
            pageObject.clickAddToCart();
        } else if ("Remove".equals(option)){
            pageObject.clickRemove();
        }
    }

    @Then("User kembali ke halaman Dashboard")
    public void navigate_to_dashboard() {
        // Add assertion to verify if redirected to the dashboard page
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
        driver.quit();
    }

    @Then("Tombol {string} berubah menjadi {string}")
    public void button_change_to(String oldLabel, String newLabel) {
        if ("Add to cart".equals(oldLabel)) {
            Assert.assertEquals(newLabel, pageObject.getRemoveButtonText());
        } else if ("Remove".equals(oldLabel)){
            Assert.assertEquals(newLabel, pageObject.getAddToCartButtonText());
        }
    }

    @Then("Jumlah barang pada cart adalah {int}")
    public void cart_amounts(int expectedCount){
        int actualCount = pageObject.getCartItemCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
