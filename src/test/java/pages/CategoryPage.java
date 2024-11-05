package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    AndroidDriver driver;
    private final By categoryElement = By.xpath("//android.widget.GridView[@resource-id=\"net.btpro.client.karaca:id/rv_categories\"]/android.widget.LinearLayout[1]");
    private final By subCategoryElement = By.xpath("(//android.widget.ImageView[@resource-id=\"net.btpro.client.karaca:id/shapeableImageView\"])[1]");
    public CategoryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    @AndroidFindBy(xpath="//android.widget.GridView[@resource-id=\"net.btpro.client.karaca:id/rv_categories\"]/android.widget.LinearLayout[1]")
    WebElement clickSubCategory;
    @AndroidFindBy(xpath="(//android.widget.ImageView[@resource-id=\"net.btpro.client.karaca:id/shapeableImageView\"])[1]")
    WebElement clickSubCategory2;


    public void clickToSubCategory() {
        clickSubCategory.click();
    }

    public void clickToSubCategory2() {
        clickSubCategory2.click();
    }
    public boolean isLoaded() {
        try {
            // Elementin görünür olup olmadığını kontrol edin
            WebElement element = driver.findElement(categoryElement);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Eğer element bulunamazsa, sayfa henüz yüklenmemiştir
        }
    }
    public boolean isLoadedForSubCategory() {
        try {
            // Elementin görünür olup olmadığını kontrol edin
            WebElement element = driver.findElement(subCategoryElement);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Eğer element bulunamazsa, sayfa henüz yüklenmemiştir
        }
    }
}
