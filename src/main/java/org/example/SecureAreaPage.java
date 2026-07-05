package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.WaitUtils;

public class SecureAreaPage extends BasePage{



    // Locators
    private By flashMessage = By.id("flash");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }
    public String getFlashMessage() {

        WaitUtils.waitForVisibility(driver, flashMessage);

        return driver.findElement(flashMessage).getText();
    }

    public LoginPage clickLogout() {
        driver.findElement(logoutButton).click();

        return new LoginPage(driver);
    }
}
