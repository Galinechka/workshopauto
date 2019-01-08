package lection3;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class OurFirtsTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File appFile = new File("/Users/gsaik/IdeaProjects/workshopauto/app/ApiDemos-debug.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","6.0.1");
        desiredCapabilities.setCapability("deviceName","08a07cdd0de8730a");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("app",appFile);

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        MobileElement elementAccessibility = driver.findElement(By.id("android:id/text1"));
        elementAccessibility.click();
        driver.navigate().back();

        MobileElement elementAnimation = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Animation']"));
        elementAnimation.click();

        List<MobileElement> elementsText1 = driver.findElements(By.xpath("android.widget.ListView[]/android.widget.TextView"));
        for (MobileElement element : elementsText1) {
            System.out.println(element.getText());
        }



    }
}
