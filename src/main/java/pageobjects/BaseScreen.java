package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class BaseScreen {
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void back(){
        driver.navigate().back();
    }

    public void printTextForFoundElementsBy(By by){
        List<MobileElement> elements = driver.findElements(by);
            for (MobileElement element : elements) {
            System.out.println(element.getText());
        }
    }
}