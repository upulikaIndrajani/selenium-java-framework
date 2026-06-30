package tests;

import org.example.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;


public class LoginTest extends BaseTest {


    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String actualMessage = loginPage.getFlashMessage();
        System.out.println(actualMessage);
        String expectedMessage = "You logged into a secure area!";

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void invalidLoginTest()  {

            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterUsername("wrongUser");
            loginPage.enterPassword("wrongPassword!");
            loginPage.clickLogin();


            String actualMessage = loginPage.getFlashMessage();
            System.out.println(actualMessage);
            String expectedMessage = "Your username is invalid!";

            Assert.assertTrue(actualMessage.contains(expectedMessage));




    }

}