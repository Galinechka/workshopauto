package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.MainScreen;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class OurFirstTest {

    private static AndroidDriver<MobileElement> driver;
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    // @BeforeSuite
    // @BeforeTest
    // @BeforeClass
    // @BeforeMethod

    // @ittest

    // @After....

    @BeforeTest
    public void setEnv(){
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.1");
        desiredCapabilities.setCapability("deviceName", "HT79N1A00736");
                desiredCapabilities.setCapability("automationName", "UiAutomator2");

                        String userDir = System.getProperty("user.dir");
        Properties properties = System.getProperties();
        // mvn install
        File file = new File(userDir + "/app/ApiDemos-debug.apk");
        desiredCapabilities.setCapability("app", file);
    }

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException{
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    @Test(description = "Our first test", groups = {"Smoke", "Regression"})
    public void testApp() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.clickOnAppItem();
        mainScreen.back();

        mainScreen.clickOnAnimationItem();
        mainScreen.back();

        mainScreen.printTextOfItemsApp();
        mainScreen.printTextOfItemsText1();

    }
}
