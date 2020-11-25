package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public void setUpDriver(String url, String browser){
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            drivers.set(new ChromeDriver());
            getDriver().get(url);
        }
        else if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            drivers.set(new FirefoxDriver());
            getDriver().get(url);
        }
        else if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            drivers.set(new EdgeDriver());
        }
    }

    public WebDriver getDriver(){
        return drivers.get();
    }
}
