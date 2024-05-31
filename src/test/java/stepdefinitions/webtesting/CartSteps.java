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

public class CartSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User sudah melakukan Login")
    public void user_login() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();
    }

//    @Given("User sudah berada pada halaman Dashboard")
//    public void navigate_in_dashboard_page() {
//        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
//    }

    @Given("User sudah menambahkan barang ke cart")
    public void add_to_cart() {
        pageObject.clickSauceLabBackpackAddToCart();
    }

    @Given("User sudah berada pada halaman Cart")
    public void navigate_in_cart_page() {
        pageObject.clickCartIcon();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", pageObject.isOnCartPage());
    }

    @When("User mengklik tombol Checkout")
    public void click_checkout() {
        pageObject.clickCheckout();
    }

    @When("User mengklik tombol Continue Shopping")
    public void click_continue_shopping() {
        pageObject.clickContinueShopping();
    }

    @Then("User dinavigasikan ke halaman checkout")
    public void navigate_in_checkout_page() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", pageObject.isOnCheckoutPage());
    }

    @Then("User dinavigasikan ke halaman dashboard")
    public void navigate_in_dashboard_page() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
    }

    @Then("Ditampilkan pesan kesalahan {string}")
    public void error_message(String expectedMessage) {
        String actualErrorMessage = pageObject.getCheckoutErrorMessage();
        Assert.assertEquals(expectedMessage, actualErrorMessage);
    }

    @Then("User tetap berada di halaman cart")
    public void still_in_cart_page() {
        pageObject.clickCartIcon();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", pageObject.isOnCartPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
