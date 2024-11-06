package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import pages.HomePage;
import pages.LoginPage;
import utils.Action;
import utils.Driver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class LoginSteps {
    private Driver driverInstance=new Driver();
    Action action=new Action();
    private LoginPage loginPage;
    private HomePage homePage;
    FluentWait<AndroidDriver> wait=new FluentWait<>(driverInstance.getDriver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1));


    @Given("Kullanıcı giriş sayfasını açar")
    public void kullanıcı_giriş_sayfasını_açar()throws Exception{
        driverInstance.initializeDriver();
        loginPage=new LoginPage(driverInstance.getDriver());
        homePage=new HomePage(driverInstance.getDriver());

        homePage.goToHomePage();

        Thread.sleep(9000);
        for (int i=0;i<4;i++){
            action.tab();
            Thread.sleep(5000);
        }
        loginPage.myAccountButtonClick();

    }

    @When("Kullanıcı yanlış bir e-posta {string} girer")
    public void kullanıcı_yanlış_bir_e_posta_girer(String yanlışEposta) {

//        wait.until(driver -> loginPage.isLoadedEmailElement());
        loginPage.myEmailFieldSend(yanlışEposta);

    }
    @When("Kullanıcı geçerli bir şifre {string} girer")
    public void kullanıcı_geçerli_bir_şifre_girer(String doğruŞifre) {

        loginPage.myPasswordFieldSend(doğruŞifre);
    }
    @When("Kullanıcı giriş butonuna tıklar")
    public void kullanıcı_giriş_butonuna_tıklar() throws Exception {
        loginPage.loginButtonClick();
        Thread.sleep(3000);
    }
    ////android.widget.TextView[@resource-id="net.btpro.client.karaca:id/tvError"]
    @Then("Kullanıcı yanlış e-posta mesajını kontrol eder")
    public void kullanıcı_yanlış_e_posta_mesajını_kontrol_eder() {
        WebElement errorMessage=driverInstance.getDriver().findElement(By.id("net.btpro.client.karaca:id/tv_dialog_description"));
        assertEquals("yanlış bilgilendirme ",errorMessage.getText(),"Lütfen girdiğiniz bilgileri kontrol ederek tekrar deneyiniz.");
        loginPage.okButtonClick();

    }
    @When("Kullanıcı geçerli bir e-posta {string} girer")
    public void kullanıcı_geçerli_bir_e_posta_girer(String doğruEposta)throws Exception {
        Thread.sleep(3000);
        loginPage.falseMyEmailFieldSend(doğruEposta);
    }
    @When("Kullanıcı yanlış bir şifre {string} girer")
    public void kullanıcı_yanlış_bir_şifre_girer(String yanlışŞifre)throws Exception {
       Thread.sleep(3000);
        loginPage.truePasswordFieldSend(yanlışŞifre);
        loginPage.loginButtonClick();

    }
    @Then("Kullanıcı  yanlış şifre mesajını kontrol eder")
    public void kullanıcı_yanlış_şifre_mesajını_kontrol_eder()throws Exception {
        Thread.sleep(3000);
        WebElement errorMessage=driverInstance.getDriver().findElement(By.id("net.btpro.client.karaca:id/tv_dialog_description"));
        assertEquals("yanlış bilgilendirme ",errorMessage.getText(),"Lütfen girdiğiniz bilgileri kontrol ederek tekrar deneyiniz.");
        loginPage.isLoadedOkElement();
        loginPage.okButtonClick();
    }
    @When("Kullanıcı geçerli bir e-posta {string} girer ve geçerli bir şifre {string} girer")
    public void kullanıcı_geçerli_bir_e_posta_girer_ve_geçerli_bir_şifre_girer(String doğruEposta, String doğruŞifre) {
        loginPage.trueEmailFieldSend(doğruEposta);
        loginPage.falseMyPasswordFieldSend(doğruŞifre);
    }
    @Then("kullanıcı giriş yapar")
    public void kullanıcı_giriş_yapar() throws Exception {
        loginPage.loginButtonClick();
        Thread.sleep(5000);
    }


}
