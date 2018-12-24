//Запустить AppConnectTester
//        Заполнить все поля значениями KVP, необходимыми для рабочей конфигурации EmailPlus
//        Нажать на кнопку Save+Send

package lection3;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AppConnectTesterConfiguration {

    static String packageName = "com.mobileiron.android.emailplus";
    //counters for swiping cycle
    static int swipeDownCount = 0;
    static int swipeUpCount = 0;
    //limit for swiping actions
    static int swipeLimit = 3;

    static File appFile = new File("/Users/gsaik/IdeaProjects/workshopauto/app/AppConnectTester.apk");

    //KVPs which should be added to configure Email+
    static Map configs = new HashMap<String, String>();

    static AndroidDriver<MobileElement> driver;


    public static void main(String[] args) throws MalformedURLException {
        configs.put("email_address","gsaik@mobileiron.com");
        configs.put("email_exchange_host","outlook.office365.com");
        configs.put("email_password","Cro55Fit!");
        configs.put("email_exchange_username","gsaik@mobileiron.com");
        configs.put("email_trust_all_certificates","true");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","7.0");
        desiredCapabilities.setCapability("deviceName","ce06160630a80a0c03");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("app",appFile);

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        //fil in package name
        MobileElement packageNameField = driver.findElement(By.id("com.mobileiron.appconnecttester:id/package_name"));
        packageNameField.clear();
        packageNameField.sendKeys(packageName);

        //for each KVP fill in value part
        configs.forEach((key, value) -> {
            addConfig(key.toString(),value.toString());
        });

        //ckick Save and Send button
        MobileElement saveAndSend = driver.findElement(By.id("com.mobileiron.appconnecttester:id/send_config"));
        saveAndSend.click();

        //verify that toast is present and print text of the toast
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        System.out.println("Toast with text:' " + toast.getAttribute("text")+ "' is shown.");

        driver.quit();
    }

    /**
     * Search for Text field with with key set as text. If not found scrolls down limited amount of times (set via
     * swipeLimit). If not found scrolls up.
     * If still not found throws NoSuchElementException.
     *
     * @param  key  key from config
     * @param  value value for the key
     */
    public static void addConfig(String key, String value){
        try {
            String xpathValue = "//android.widget.EditText[@text='" + key + "']/following-sibling::android.widget.EditText";
            MobileElement valueLocation = (MobileElement) driver.findElement(By.xpath(xpathValue));
            valueLocation.clear();
            valueLocation.sendKeys(value.toString());
            System.out.println("Value for key: " + key+ " was added");
            swipeDownCount = 0;
            swipeUpCount = 0;
        } catch (org.openqa.selenium.NoSuchElementException e){
            if (swipeDownCount<swipeLimit) {
                swipe("DOWN");
            } else if (swipeUpCount<swipeLimit){
                swipe ("UP");
            } else{
                throw new NoSuchElementException("Element for field " + key + " can't ne found") ;
            }
            addConfig(key, value);
        }

    }

    /**
     * Swipes the screen UP or DOWN for 45% of the screen's height
     *
     * @param  direction UP or DOWN to determine which direction scrolling is performed
     */
    private static void swipe(String direction) {
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        int startX = width / 2;
        int startY = (int) (height * 0.80);
        int endY = (int) (height * 0.35);
        TouchAction scroll = new TouchAction(driver);
        PointOption startPpoint = new PointOption().withCoordinates(startX, startY);
        PointOption endPpoint = new PointOption().withCoordinates(startX, endY);
        if (direction=="DOWN") {
            scroll.press(startPpoint).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(endPpoint).release().perform();
            swipeDownCount +=1;
        } else if (direction=="UP"){
            scroll.press(endPpoint).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(startPpoint).release().perform();
            swipeUpCount +=1;
        }
    }

}