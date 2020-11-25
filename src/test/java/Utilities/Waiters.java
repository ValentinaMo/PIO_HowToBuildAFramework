package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters extends DriverFactory {
    int timeOut = 10;

    public Waiters clickOnWait(WebElement element){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    public Waiters sendKeysWait(String value, WebElement locator){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.visibilityOf(locator));
        locator.sendKeys(value);
        return this;
    }

    public Waiters visibilityElementsWebElement(WebElement element){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
}

