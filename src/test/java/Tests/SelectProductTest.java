package Tests;

import CustomAssertions.MyAccountPageAssertions;
import CustomAssertions.SignInPageAssertions;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.SignInPage;
import Utilities.DataRandomGenerate;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelectProductTest extends BaseTest {
    DataRandomGenerate dataRandom = new DataRandomGenerate();

    @Test
    public void UserIsNotRegisterAndAuthenticationFailed() {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);

        homePage.
                clickOnSignInButton();
        signInPage
                .sendKeyEmailSignIn()
                .sendKeyPassword()
                .clickOnLogInButton();
        SignInPageAssertions.AssertUserIsNotRegister(signInPage.clickOnLogInButton());
    }

    @Test
    public void VerifyAnInvalidEmailAddressCreatingAnAccount(){
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);

        homePage.clickOnSignInButton();
        signInPage.sendKeyEmailCreateAccount(dataRandom.invalidEmail());
        SignInPageAssertions.AssertInvalidEmailAddress(signInPage.clickOnCreateAccountButton());
    }

    @Test(groups = {"Coverage"}, description = "Correctly fill in all the form fields and validate them to " +
            "create a new account")
    public void FillTheFormWihValidValuesToCreateAnAccount(){
        MyAccountPage myAccountPage = PageFactory.initElements(getDriver(), MyAccountPage.class);
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
        CreateAnAccountPage createAnAccountPage = PageFactory.initElements(getDriver(), CreateAnAccountPage.class);

        homePage.clickOnSignInButton();
        signInPage.sendKeyEmailCreateAccount();
        createAnAccountPage.completeMandatoryFieldsWithCorrectValues();
        MyAccountPageAssertions.AssertCreateANewAccount(myAccountPage.getNewAccountVerificationMessage());
    }

    @Test(groups = {"Coverage"}, description = "\n" + "When a new account is created validate if the customer account" +
            "appear in the homepage and validate if the account is created successful with the correct name")
    public void ValidateIfTheCostumerIsLoggedInAfterCreatingAnAccount(){
        MyAccountPage myAccountPage = PageFactory.initElements(getDriver(), MyAccountPage.class);
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
        CreateAnAccountPage createAnAccountPage = PageFactory.initElements(getDriver(), CreateAnAccountPage.class);

        homePage.clickOnSignInButton();
        signInPage.sendKeyEmailCreateAccount();
        createAnAccountPage.completeMandatoryFieldsWithCorrectValues();
        myAccountPage.goBackHomePage();
        Assert.assertEquals(homePage.getCostumerName(), createAnAccountPage.getCostumerNameCreatingAccount());
    }
}
