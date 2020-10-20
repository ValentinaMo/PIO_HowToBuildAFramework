package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setDriver(@Optional("Chrome") String browser){
        new DriverFactory().setUpDriver("http://automationpractice.com/index.php", browser);
    }

    public void setUpDriver(String url, String browser){
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            drivers.set(new ChromeDriver());
            getDriver().get(url);
        }
        else if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            drivers.set(new FirefoxDriver());
        }
        else if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            drivers.set(new EdgeDriver());
        }
    }

    public WebDriver getDriver(){
        return drivers.get();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}
