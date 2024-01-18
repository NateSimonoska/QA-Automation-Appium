import helpers.AppiumHelpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.BasePageObject;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class TestClass extends AppiumHelpers {

    public TestClass() throws MalformedURLException {
    }

    @Test
    public void testTest () throws MalformedURLException {
        AppiumHelpers appium = new AppiumHelpers();
        TestClass test = new TestClass();



    }

}
