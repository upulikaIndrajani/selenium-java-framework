package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");



    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public SecureAreaPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return new SecureAreaPage(driver);
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }



}