package Pages;

import Utilities.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Waiters {

    @FindBy(xpath = "//*[@class=\"info-account\"]")
    private WebElement newAccountMessage;
    @FindBy(xpath = "//*[@class=\"home\"]")
    private WebElement homeButton;

    public String getNewAccountVerificationMessage(){
        visibilityElementsWebElement(newAccountMessage);
        return newAccountMessage.getText();
    }

    public void goBackHomePage()
    {
        clickOnWait(homeButton);
    }
}
