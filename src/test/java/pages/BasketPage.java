package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    private final By addToBasketElement=By.id("net.btpro.client.karaca:id/buttonAddToBasket");
    private final By goToBasketElement=By.id("net.btpro.client.karaca:id/tv_basket");
    private final By addForProductElement=By.id("net.btpro.client.karaca:id/btn_add");
    AndroidDriver driver;
    public BasketPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }
    @AndroidFindBy(id="net.btpro.client.karaca:id/buttonAddToBasket")
    private WebElement addToBasketButton;
    @AndroidFindBy(id="net.btpro.client.karaca:id/tv_basket")
    private WebElement goToBasketButton;
    @AndroidFindBy(id="net.btpro.client.karaca:id/btn_add")
    private WebElement addButton;
    @AndroidFindBy(id="net.btpro.client.karaca:id/btn_continue")
    private WebElement goToPaymentButton;

    public void addToBasketButtonClick(){
        addToBasketButton.click();
    }

    public void goToBasketButtonClick(){
        goToBasketButton.click();
    }

    public void addButtonClick(){
        addButton.click();
    }
    
    public void goToPaymentButtonClick(){
        goToPaymentButton.click();
    }
    public boolean isLoadedAddToBasketButton(){
        try{
            WebElement element = driver.findElement(addToBasketElement);
            return element.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean isLoadedGoToBasketButton(){
        try{
            WebElement element = driver.findElement(goToBasketElement);
            return element.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean isLoadedAddForProductButton(){
        try{
            WebElement element = driver.findElement(addForProductElement);
            return element.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }
}
