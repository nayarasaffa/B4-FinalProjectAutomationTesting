package stepdefinitions.webtesting;

import helper.PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User melakukan login")
    public void user_have_login() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();
    }

    @Given("User memasukkan barang {string} ke dalam Cart")
    public void add_item_to_cart(String productId){
        pageObject.clickAddToCartProduct(productId);
    }

    @Given("User masuk ke halaman Cart")
    public void navigate_to_cart(){
        pageObject.clickCartIcon();
    }

    @Given("User klik tombol {string}")
    public void user_click_button(String option){
        if ("Checkout".equals(option)) {
            pageObject.clickCheckout();
        }else if("Continue".equals(option)) {
            pageObject.clickContinueButton();
        }else if("Cancel".equals(option)) {
            pageObject.clickCancelButton();
        }else if("Finish".equals(option)) {
            pageObject.clickFinishButton();
        }
    }

    @When("User mengisi formulir informasi")
    public void user_fills_information_form(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("firstName");
        pageObject.enterFirstName(firstName);

        String lastName = data.get(0).get("lastName");
        pageObject.enterLastName(lastName);

        String postalCode = data.get(0).get("postalCode");
        pageObject.enterPostalCode(postalCode);
    }

    @Then("Aplikasi menampilkan halaman {string}")
    public void application_display_page(String page){
        if ("Overview Product".equals(page)){
            Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", pageObject.currentPage());
        }else if ("Cart".equals(page)){
            Assert.assertEquals("https://www.saucedemo.com/cart.html", pageObject.currentPage());
        }else if ("Completed Checkout".equals(page)){
            Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", pageObject.currentPage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
