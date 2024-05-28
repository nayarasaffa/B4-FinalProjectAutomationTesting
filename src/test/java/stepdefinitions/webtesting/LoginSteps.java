package stepdefinitions.webtesting;

import helper.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginSteps {
    WebDriver driver;
    PageObject pageObject;

    @Given("User sudah berada di halaman login page pada browser")
    public void user_is_on_the_login_page() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);
    }

    @When("User memasukkan {string} & {string}")
    public void user_enters_username_and_password(String username, String password) {
        pageObject.enterUsername(username);
        pageObject.enterPassword(password);
    }

    @When("User mengklik button Login")
    public void user_clicks_on_the_login_button() {
        pageObject.clickLoginButton();
    }

    @Then("User dinavigasikan ke halaman Dashboard")
    public void user_should_be_redirected_to_the_dashboard_page() {
        // Add assertion to verify if redirected to the dashboard page
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
        driver.quit();
    }

    @Then("User mendapat pesan {string}")
    public void user_mendapat_pesan(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, pageObject.errorMessageUsernamePasswordInvalid());
    }

    //Logout

    @When("User mengklik icon menu di halaman dashboard")
    public void user_clicks_on_the_menu_icon() {
        pageObject.clickMenuButton();
    }

    @When("User memilih opsi {string}")
    public void user_selects_option(String option) {
        if ("Logout".equals(option)) {
            pageObject.clickLogoutLink();
        }
    }

    @Then("User dinavigasikan ke halaman login page")
    public void user_is_redirected_to_the_login_page() {
        Assert.assertEquals("https://www.saucedemo.com/", pageObject.isOnLoginPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}