package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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
    private By detailProduct = By.id("item_4_title_link");
    private By backToProduct = By.id("back-to-products");
    private By addToCart = By.id("add-to-cart");
    private By addToCartSauceLabBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By remove = By.id("remove");
    private By cartBadge = By.cssSelector(".shopping_cart_badge[data-test='shopping-cart-badge']");
    private By errorMessageLogin = By.cssSelector(".error-message-container h3[data-test='error']");
    private By filterDropdown = By.cssSelector(".product_sort_container");
    private By productNames = By.cssSelector(".inventory_item_name");
    private By productPrices = By.cssSelector(".inventory_item_price");
    private By checkoutButton = By.id("checkout");
    private By cartIcon = By.id("shopping_cart_container");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutErrorMessage = By.cssSelector(".error-message-container h3[data-test='error']");


    // Methods to interact with the elements
    // New method using wait

    // ############## CLICK OBJECT ##############
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

    public void clickDetailProduct(){
        WebElement detailProdukElement = wait.until(ExpectedConditions.elementToBeClickable(detailProduct));
        detailProdukElement.click();
    }

    public void clickBackToProduct(){
        WebElement detailProdukElement = wait.until(ExpectedConditions.elementToBeClickable(backToProduct));
        detailProdukElement.click();
    }

    public void clickAddToCart(){
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCartElement.click();
    }

    public void clickSauceLabBackpackAddToCart() {
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartSauceLabBackpack));
        addToCartElement.click();
    }

    public void clickRemove(){
        WebElement removeElement = wait.until(ExpectedConditions.elementToBeClickable(remove));
        removeElement.click();
    }

    public void clickCheckout(){
        WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutElement.click();
    }

    public void clickCartIcon() {
        WebElement cartIconElement = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIconElement.click();
    }

    public void clickContinueShopping() {
        WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueButtonElement.click();
    }

    // ############## CHECK PAGE POSITION ##############
    public String isOnDashboardPage() {
        return driver.getCurrentUrl();
    }

    public String isOnCartPage() {
        return driver.getCurrentUrl();
    }

    public String isOnLoginPage() {
        return driver.getCurrentUrl();
    }
    public String isOnCheckoutPage() {
        return driver.getCurrentUrl();
    }

    // ############## GET TEXT ##############
    public String getRemoveButtonText(){
        WebElement removeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(remove));
        return removeElement.getText();
    }

    public String getAddToCartButtonText(){
        WebElement addToCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
        return addToCartElement.getText();
    }

    public int getCartItemCount(){
        try {
            WebElement cartBadgeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
            return Integer.parseInt(cartBadgeElement.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    // ############## GET ERROR MESSAGE ##############
    public String errorMessageUsernamePasswordInvalid() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLogin));
        return errorMessageElement.getText();
    }

    public String getCheckoutErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutErrorMessage));
        return errorMessageElement.getText();
    }

    // ############## INTERACT WITH DROPDOWN ##############
    public void clickFilterDropdown() {
        WebElement filterDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(filterDropdown));
        filterDropdownElement.click();
    }

    public void selectFilterOption(String option) {
        WebElement filterDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(filterDropdown));
        Select select = new Select(filterDropdownElement);
        select.selectByVisibleText(option);
    }

    // ############## GET PRODUCT DETAILS ##############
    public List<String> getProductNames() {
        List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
        return productElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices));
        return priceElements.stream().map(e -> Double.parseDouble(e.getText().replace("$", ""))).collect(Collectors.toList());
    }
}
