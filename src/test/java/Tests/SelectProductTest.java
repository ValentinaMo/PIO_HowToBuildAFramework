package Tests;

import Pages.HomePage;
import Pages.SignInPage;
import Utilities.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelectProductTest extends DriverFactory {

    @Test
    public void userIsAbleToSignIn() {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.clickOnSignInButton();
    }
}
