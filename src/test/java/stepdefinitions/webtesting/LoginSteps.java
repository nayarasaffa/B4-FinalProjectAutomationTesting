package stepdefinitions.webtesting;

import helper.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User sudah berada di halaman login page pada browser")
    public void user_is_on_the_login_page() {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("User memasukkan {string} & {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User mengklik button Login")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User dinavigasikan ke halaman Dashboard")
    public void user_should_be_redirected_to_the_dashboard_page() {
        // Add assertion to verify if redirected to the dashboard page
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.isOnDashboardPage());
        driver.quit();
    }

    @Then("User mendapat pesan {string}")
    public void user_mendapat_pesan(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPage.errorMessageUsernamePasswordInvalid());
    }

    //Logout

    @When("User mengklik icon menu di halaman dashboard")
    public void user_clicks_on_the_menu_icon() {
        loginPage.clickMenuButton();
    }

    @When("User memilih opsi {string}")
    public void user_selects_option(String option) {
        if ("Logout".equals(option)) {
            loginPage.clickLogoutLink();
        }
    }

    @Then("User dinavigasikan ke halaman login page")
    public void user_is_redirected_to_the_login_page() {
        Assert.assertEquals("https://www.saucedemo.com/", loginPage.isOnLoginPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
