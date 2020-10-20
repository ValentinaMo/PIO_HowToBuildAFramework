package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends DriverFactory{

    public void sendKeysWait(int timeOut, String value, WebElement locator){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.visibilityOf(locator));
        locator.sendKeys(value);
    }
    public void clickOnWait(int timeOut, WebElement element){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void visibilityElements(int timeOut, String element){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void visibilityElementsWebElement(int timeOut, WebElement element){
        new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void Wait(){
    }
}