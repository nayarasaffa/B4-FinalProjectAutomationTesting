package stepdefinitions.webtesting;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Map;
import helper.PageObject;

public class EndToEndSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User telah melakukan login")
    public void end_to_end_user_login() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();

        // Verify user is logged in by checking the URL
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Given("User sudah berada di halaman dashboard")
    public void end_to_end_in_dashboard_page() {
        // Assert the user is on the dashboard page
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("User menekan tombol {string} pada produk {string}")
    public void user_click_add_to_cart_on_product(String button, String product) {
        pageObject.clickAddToCartButton(product);
    }

    @When("User menekan tombol {string}")
    public void end_to_end_click_button(String button) {
        switch (button) {
            case "Cart":
                pageObject.clickCartIcon();
                break;
            case "Checkout":
                pageObject.clickCheckout();
                break;
            case "Continue":
                pageObject.clickContinueButton();
                break;
            case "Finish":
                pageObject.clickFinishButton();
                break;
            default:
                throw new IllegalArgumentException("Unexpected button: " + button);
        }
    }

    @When("User mengisi formulir informasi dengan data yang valid")
    public void end_to_end_fill_checkout_form_with_valid_data(Map<String, String> formData) {
        pageObject.enterFirstName(formData.get("First Name"));
        pageObject.enterLastName(formData.get("Last Name"));
        pageObject.enterPostalCode(formData.get("Postal Code"));
    }

    @Then("Aplikasi menampilkan halaman Completed Checkout")
    public void end_to_end_verify_completed_checkout_page() {
        // Assert that the completed checkout page is displayed
        Assert.assertTrue(pageObject.isOnCompletedCheckoutPage());
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
