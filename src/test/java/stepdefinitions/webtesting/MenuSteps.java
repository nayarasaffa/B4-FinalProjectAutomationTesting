package stepdefinitions.webtesting;

import helper.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuSteps {

    WebDriver driver;
    PageObject pageObject;

    @Given("User telah login")
    public void user_login() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", ".\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        pageObject = new PageObject(driver);

        pageObject.enterUsername("standard_user");
        pageObject.enterPassword("secret_sauce");
        pageObject.clickLoginButton();
    }

    @Given("User berada di halaman dashboard")
    public void navigate_in_dashboard_page() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
    }

    @Then("Program menampilkan sidebar Menu di sebelah kiri dan Sidebar Menu memuat:")
    public void MenuDisplay(List<String> expectedMenuOptions) throws InterruptedException {
        Thread.sleep(1000);
        List<String> actualMenuOptions = pageObject.getMenuOptions();
        assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Given("Sidebar Menu telah terbuka")
    public void openMenu() throws InterruptedException {
        pageObject.clickMenuButton();
        Thread.sleep(1000);
    }

    @When("Klik button {string}")
    public void clickButton(String option) throws InterruptedException {
        Thread.sleep(1000);
        if ("X".equals(option)) {
            pageObject.clickXButton();
        } else if ("garis tiga".equals(option)){
            pageObject.clickMenuButton();
        } else if ("Reset App State".equals(option)){
            pageObject.clickResetStateApp();
        }
        Thread.sleep(1000);
    }

    @Then("Sidebar menu ditutup")
    public void closeMenu() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
    }

    @Then("Program menampilkan halaman Dashboard")
    public void navigate_to_dashboard() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", pageObject.isOnDashboardPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
