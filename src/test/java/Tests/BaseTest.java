package Tests;

import Utilities.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest extends DriverFactory{
    @Parameters("browser")
    @BeforeMethod
    public void setDriver(@Optional("Chrome") String browser){
        new DriverFactory().setUpDriver("http://automationpractice.com/index.php", "Firefox");
    }
    @AfterMethod
    public void tearDown() {
        File screenshot=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("./target/"+ Math.random()*6 +"screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        getDriver().quit();
    }
}
