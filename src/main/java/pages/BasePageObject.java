package pages;

import helpers.AppiumHelpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;


public class BasePageObject {
    static AndroidDriver androidDriver;
    IOSDriver iosDriver;
    AppiumDriver driver;
     Logger log;

    DesiredCapabilities caps = new DesiredCapabilities();
    private final static String REMOTE_HOST = "http://127.0.0.1:4723/";
    URL url = new URL("http://localhost:4723/wd/hub");



//    public BasePageObject(AppiumDriver driver, Logger log) throws MalformedURLException {
//        this.driver = driver;
//        this.log = log;
//    }

    public BasePageObject(AndroidDriver androidDriver, Logger log) throws MalformedURLException {
        this.androidDriver = androidDriver;
        this.log = log;
    }

//    public BasePageObject(IOSDriver iOSDriver, Logger log) throws MalformedURLException {
//        this.iosDriver = iOSDriver;
//        this.log = log;
//    }
    public void initializeAndroidDriver () throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(REMOTE_HOST), caps);
    }

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


    public void quitDriver () {
        BasePageObject.androidDriver.quit();
    }

}

