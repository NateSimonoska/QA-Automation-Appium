package helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.HttpClient;
import pages.BasePageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;


public class AppiumHelpers {

    public static AndroidDriver androidDriver;
    public static Logger logs;
    private final static String REMOTE_HOST = "http://127.0.0.1:4723/";
    URL url = new URL("http://localhost:4723/wd/hub");


    DesiredCapabilities caps = new DesiredCapabilities();

    public AppiumHelpers() throws MalformedURLException {
    }

    public void initializeAndroidDriver () throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(REMOTE_HOST), caps);
    }

    @BeforeMethod
    public AndroidDriver createAndroidDriver() throws MalformedURLException {
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:AutomationName", "uiautomator2");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:deviceName", "Pixel 2");
        caps.setCapability("appium:udid", "357537082049461");
        //caps.setCapability("appium:appPackage", "");
        // caps.setCapability("appium:appActivity", "");
        caps.setCapability("app", "/Users/natashajoncheski/Downloads/app-debug.apk");


        URL url = new URL("http://localhost:4723/wd/hub");
        androidDriver = new AndroidDriver(new URL(REMOTE_HOST), caps);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return androidDriver;
    }

    @AfterMethod
    public void quitDriver () {
        AppiumHelpers.androidDriver.quit();
    }

}
