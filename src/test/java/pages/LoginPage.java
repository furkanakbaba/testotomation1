package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final By myEmailElement=By.xpath("//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"E-Posta*\"]");
    private final By okElement=By.id("net.btpro.client.karaca:id/btn_dialog_right");
     AndroidDriver driver;
     public LoginPage(AndroidDriver driver) {
         this.driver = driver;
         PageFactory.initElements(new AppiumFieldDecorator(driver), this);
     }
     @AndroidFindBy(id = "net.btpro.client.karaca:id/account_menu")
     private WebElement myAccountButton;
     @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"E-Posta*\"]")
     private WebElement myEmailField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"furkanakbabadev@gmail.com\"]")
    private WebElement trueEmailField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"472722.Aq\"]")
    private WebElement truePasswordField;
     @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"furkanakbaba123321@gmail.com\"]")
     private WebElement falseMyEmailField;
     @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"furkanakbaba123321.a\"]")
     private WebElement falseMyPasswordField;
     @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.btpro.client.karaca:id/etInput\" and @text=\"Şifre*\"]")
     private WebElement  myPasswordField;
     @AndroidFindBy(id = "net.btpro.client.karaca:id/login")
     private WebElement loginButton;
     @AndroidFindBy(id="net.btpro.client.karaca:id/btn_dialog_right")
     private WebElement okButton;


     public void myAccountButtonClick() {
         myAccountButton.click();
     }
     public void myEmailFieldSend(String email) {
         myEmailField.sendKeys(email);

     }
     public void trueEmailFieldSend(String email) {
         trueEmailField.sendKeys(email);
     }
     public void truePasswordFieldSend(String password) {
         truePasswordField.sendKeys(password);
     }
     public void falseMyEmailFieldSend(String email) {
         falseMyEmailField.sendKeys(email);
     }
     public void falseMyPasswordFieldSend(String password) {
         falseMyPasswordField.sendKeys(password);
     }
     public void myPasswordFieldSend(String password) {
         myPasswordField.sendKeys(password);
     }
     public void loginButtonClick() {
         loginButton.click();
     }
     public void okButtonClick() {
         okButton.click();
     }

    public boolean isLoadedOkElement(){
        try{
            WebElement element = driver.findElement(okElement);
            return element.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }
//     public boolean isLoadedEmailElement(){
//         try{
//             WebElement element = driver.findElement(myEmailElement);
//             return element.isDisplayed();
//         }
//         catch(Exception e){
//             return false;
//         }
//     }


     //furkanakbabadev@gmail.com doğru email
     //Furkan123.a doğru şifre





}
