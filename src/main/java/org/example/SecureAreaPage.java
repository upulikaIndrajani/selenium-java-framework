package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SecureAreaPage {

    private WebDriver driver;

    // Locators
    private By flashMessage = By.id("flash");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getFlashMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(flashMessage)
        );

        return driver.findElement(flashMessage).getText();
    }
}
