package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
    private final By someUniqueElement = By.id("net.btpro.client.karaca:id/categories_menu");
    AndroidDriver driver;
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="net.btpro.client.karaca:id/categories_menu")
    private WebElement categoryButton;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    private WebElement permissionButton;

    public void goToHomePage() {
        permissionButton.click();
    }

    public void goToCategory(){
        categoryButton.click();
    }
    public boolean isLoaded() {
        try {
            // Elementin görünür olup olmadığını kontrol edin
            WebElement element = driver.findElement(someUniqueElement);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Eğer element bulunamazsa, sayfa henüz yüklenmemiştir
        }
    }
}
