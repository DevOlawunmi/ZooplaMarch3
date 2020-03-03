package co.uk.zoopla.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browsers extends DriverLib
{
    //I'm writing a method to initialize my browsers. It's a method that returns a Webdriver therefore it is not void
private WebDriver initChrome()
{
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
}
    private WebDriver initHeadlessChrome()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--headless");
        return new ChromeDriver();
    }
    private WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    public void launchBrowser(String browser)
    {switch (browser)
    {
        case "Chrome":
            driver = initChrome();
            break;
        //default:
        // driver = initHeadlessChrome();
    }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }
    public void closeBrowser(){
    driver.manage().deleteAllCookies();
    driver.quit();

    }
}
