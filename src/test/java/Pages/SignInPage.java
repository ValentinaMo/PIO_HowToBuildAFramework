package Pages;

import Utilities.DataRandomGenerate;
import Utilities.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Waiters {
    DataRandomGenerate dataRandom = new DataRandomGenerate();

    @FindBy (id = "email")
    private WebElement emailFieldSignIn;
    @FindBy (id = "email_create")
    private WebElement emailFieldCreateAccount;
    @FindBy (id = "passwd")
    private WebElement passwordField;
    @FindBy (id = "SubmitLogin")
    private WebElement submitLoginButton;
    @FindBy (id = "SubmitCreate")
    private WebElement createAccountButton;
    @FindBy (xpath = "//*[@class=\"alert alert-danger\"]")
    private WebElement signInErrorMessage;
    @FindBy (id = "create_account_error")
    private WebElement createAccountErrorMessage;


    public SignInPage sendKeyEmailSignIn(String email)
    {
        sendKeysWait(dataRandom.validEmail(), emailFieldSignIn);
        return this;
    }
    public SignInPage sendKeyEmailSignIn()
    {
        sendKeysWait(dataRandom.validEmail(), emailFieldSignIn);
        return this;
    }
    public SignInPage sendKeyEmailCreateAccount(String email)
    {
        sendKeysWait(email, emailFieldCreateAccount).clickOnWait(createAccountButton);
        clickOnWait(createAccountButton);
        return this;
    }
    public SignInPage sendKeyEmailCreateAccount()
    {
        sendKeysWait(dataRandom.validEmail(), emailFieldCreateAccount).clickOnWait(createAccountButton);
        return this;
    }
    public SignInPage sendKeyPassword()
    {
        sendKeysWait(dataRandom.validPassword(), passwordField);
        return this;
    }
    public String clickOnLogInButton()
    {
        clickOnWait(submitLoginButton);
        visibilityElementsWebElement(signInErrorMessage);
        return signInErrorMessage.getText();
    }

    public String clickOnCreateAccountButton()
    {
        clickOnWait(createAccountButton);
        visibilityElementsWebElement(createAccountErrorMessage);
        return createAccountErrorMessage.getText();
    }

}