package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class FilterPage {

    AndroidDriver driver;
    private final By filterElement=By.xpath("//android.widget.TextView[@resource-id=\"net.btpro.client.karaca:id/textFilter2\"]");
    private final By whichForFilterElement= By.xpath("(//android.widget.LinearLayout[@resource-id=\"net.btpro.client.karaca:id/ll3\"])[5]");
    private final By priceFilterElement=By.xpath("//android.widget.CheckBox[@resource-id=\"net.btpro.client.karaca:id/checkbox\" and @text=\"100TL - 500TL (927)\"]");
    private final By seeProductsForFilterElement=By.id("net.btpro.client.karaca:id/buttonApply");
    private final By sortButtonForFilterElement=By.id("net.btpro.client.karaca:id/textSort");
    private final By firstProductElement=By.xpath("(//android.widget.FrameLayout[@resource-id=\"net.btpro.client.karaca:id/cv_image\"])[1]/android.widget.ImageView");
    public FilterPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id ="net.btpro.client.karaca:id/textFilter2")
    private WebElement click;
    @AndroidFindBy(xpath ="(//android.widget.LinearLayout[@resource-id=\"net.btpro.client.karaca:id/ll3\"])[5]")
    private   WebElement goToPriceButton;
    @AndroidFindBy(xpath ="//android.widget.CheckBox[@resource-id=\"net.btpro.client.karaca:id/checkbox\" and @text=\"100TL - 500TL (927)\"]")
    private  WebElement filterPriceButton50100;
    @AndroidFindBy(id ="net.btpro.client.karaca:id/applybtn")
    private WebElement applyButton;
    @AndroidFindBy(id="net.btpro.client.karaca:id/buttonApply")
    private  WebElement seeProductsForFilterButton;
    @AndroidFindBy(id="net.btpro.client.karaca:id/textSort")
    private WebElement sortButton;
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"En Çok Değerlendirilenler\"]")
    private  WebElement mostRated;
    @AndroidFindBy(xpath ="(//android.widget.FrameLayout[@resource-id=\"net.btpro.client.karaca:id/cv_image\"])[1]/android.widget.ImageView")
    private WebElement selectFirstProductForFilter;

public void goToFilterClick() {
    click.click();
}
public void goToFilterForPriceButtonClick() {
    goToPriceButton.click();

}
public void filterPriceButton50100Click() {
    filterPriceButton50100.click();
}
public void applyButtonClick() {
    applyButton.click();
}
public void seeProductsForFilterButtonClick() {
    seeProductsForFilterButton.click();
}
public void sortButtonClick() {
    sortButton.click();
}
public void mostRatedClick() {
    mostRated.click();
}
public void selectFirstProductForFilterClick() {

    selectFirstProductForFilter.click();
}
public boolean isLoadedFilterButton(){
    try {
      WebElement element=driver.findElement(filterElement);
      return element.isDisplayed();
    }
    catch (Exception e) {
        return false; // Eğer element bulunamazsa, sayfa henüz yüklenmemiştir
    }
}
public boolean isLoadedFilterForWhichElement(){
    try{
        WebElement element=driver.findElement(whichForFilterElement);
        return element.isDisplayed();
    }
    catch (Exception e) {
        return false;
    }
}
    public boolean isLoadedPriceFilterElement(){
        try{
            WebElement element=driver.findElement(priceFilterElement);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }


    }
    public boolean isLoadedSeeProductsForFilterElement(){
        try{
            WebElement element=driver.findElement(seeProductsForFilterElement);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }

    }
    public boolean isLoadedSortButton(){
        try{
            WebElement element=driver.findElement(sortButtonForFilterElement);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }

    }
    public boolean isLoadedFirstProductElement(){
        try{
            WebElement element=driver.findElement(firstProductElement);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }
}
