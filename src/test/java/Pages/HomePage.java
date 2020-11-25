package Pages;

import Utilities.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Waiters {

    @FindBy (xpath = "//*[@class=\"login\"]")
    private WebElement signInButton;
    @FindBy (xpath = "//*[@class=\"account\"]//span")
    private WebElement costumerName;

    public void clickOnSignInButton(){
        clickOnWait(signInButton);
    }

    public String getCostumerName(){
        return costumerName.getText();
    }

}