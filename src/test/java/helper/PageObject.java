package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    private WebDriver driver;
    private WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
    }

    // Web elements locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By errorMessageLogin = By.cssSelector(".error-message-container h3[data-test='error']");

    // Methods to interact with the elements
    // New method using wait
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    public void clickMenuButton() {
        WebElement menuButtonElement = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButtonElement.click();
    }

    public void clickLogoutLink() {
        WebElement logoutLinkElement = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLinkElement.click();
    }

    public String isOnDashboardPage() {
        return driver.getCurrentUrl();
    }

    public String isOnLoginPage() {
        return driver.getCurrentUrl();
    }

    public String errorMessageUsernamePasswordInvalid() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLogin));
        return errorMessageElement.getText();
    }

}
