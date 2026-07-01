package tests;

import org.example.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.example.SecureAreaPage;


public class LoginTest extends BaseTest {


    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        //LoginPage loginPage = new LoginPage(driver);

        SecureAreaPage secureAreaPage =
                loginPage.login("tomsmith", "SuperSecretPassword!");

        String actualMessage =
                secureAreaPage.getFlashMessage();
        System.out.println(actualMessage);
        String expectedMessage = "You logged into a secure area!";

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void invalidLoginTest()  {

            LoginPage loginPage = new LoginPage(driver);

        SecureAreaPage secureAreaPage =
                loginPage.login("wrongUser", "wrongPassword!");


        String actualMessage = secureAreaPage.getFlashMessage();
            System.out.println(actualMessage);
            String expectedMessage = "Your username is invalid!";

            Assert.assertTrue(actualMessage.contains(expectedMessage));




    }

}