package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private By app = MobileBy.AccessibilityId("App");
    private By accessibility = MobileBy.AccessibilityId("Accessibility");
    private By animation = MobileBy.AccessibilityId("Animation");
    private By content = MobileBy.AccessibilityId("Content");
    private By graphics = MobileBy.AccessibilityId("Graphics");
    private By media = MobileBy.AccessibilityId("Media");
    private By text1 = By.id("android:id/text1");

    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

//    public MainScreen(AndroidDriver driver) {
//        this.driver = driver;
//    }

    public void clickOnAppItem() {
        driver.findElement(app).click();
    }

    public void clickOnAnimationItem(){
        driver.findElement(animation).click();
    }

    public void printTextOfItemsApp(){
        printTextForFoundElementsBy(app);
    }

    public void printTextOfItemsText1(){
        printTextForFoundElementsBy(text1);
    }
}