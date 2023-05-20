package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private Driver(){
    }
    public synchronized static WebDriver getDriver(){
        if(driverPool.get() == null){
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    //Since we don't want to mess with ads, we used ad blocker extension.
                    chromeOptions.addExtensions(new File("./extension_5_6_0_0.crx"));
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if (driverPool != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
