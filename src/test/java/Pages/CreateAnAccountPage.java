package Pages;

import Utilities.DataRandomGenerate;
import Utilities.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends Waiters {
    DataRandomGenerate dataRandom = new DataRandomGenerate();

    private String customerName;
    private String customerLastName;

    @FindBy(id = "id_gender1")
    private WebElement mrGenderBox;
    @FindBy(id = "id_gender2")
    private WebElement mrsGenderBox;
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameField;
    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameField;
    @FindBy(id = "email")
    private WebElement customerEmailField;
    @FindBy(id = "passwd")
    private WebElement customerPasswordField;
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(xpath = "//*[@id=\"id_state\"]//option[@value=\"3\"]")
    private WebElement selectCountryField;
    @FindBy(id = "postcode")
    private WebElement postalCodeField;
    @FindBy(id = "phone_mobile")
    private WebElement mobileNumberField;
    @FindBy(id = "alias")
    private WebElement aliasAddressField;
    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;


    public void completeMandatoryFieldsWithCorrectValues(){
        clickOnWait(mrsGenderBox);
        customerName = dataRandom.validName();
        customerLastName = dataRandom.validLastName();

        sendKeysWait(customerName, customerFirstNameField);
        sendKeysWait(customerLastName, customerLastNameField);
        sendKeysWait(dataRandom.validPassword(), customerPasswordField);
        sendKeysWait(customerName, firstNameField);
        sendKeysWait(customerLastName, lastNameField);
        sendKeysWait(dataRandom.validAddress(), addressField);
        sendKeysWait(dataRandom.validCity(), cityField);
        clickOnWait(selectCountryField);
        sendKeysWait(dataRandom.validPostalCode(), postalCodeField);
        sendKeysWait(dataRandom.validPhoneNumber(), mobileNumberField);
        sendKeysWait(dataRandom.validAddress(), aliasAddressField);
        clickOnWait(submitAccountButton);
    }

    public String getCostumerNameCreatingAccount(){
        return customerName;
    }
}
