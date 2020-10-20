package Pages;

import Utilities.Utils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utils {
    Faker faker = new Faker();

    @FindBy (xpath = "//*[@class=\"login\"]")
    private WebElement signInButton;

    public void clickOnSignInButton(){
        clickOnWait(15, signInButton);
    }


}