package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import pages.BasketPage;
import pages.CategoryPage;
import pages.FilterPage;
import pages.HomePage;
import utils.Action;
import utils.Driver;

import java.time.Duration;

public class SampleSteps {
   private Driver driverInstance=new Driver();

    Action action =new Action();
   private HomePage homePage;
   private CategoryPage categoryPage;
   private FilterPage filterPage;
   private BasketPage basketPage;
    FluentWait<AndroidDriver> wait=new FluentWait<>(driverInstance.getDriver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1));
    @Given("Kullanıcı Karaca uygulamasını açar")
    public void kullanıcı_karaca_uygulamasını_açar()throws Exception {

        driverInstance.initializeDriver();
        homePage=new HomePage(driverInstance.getDriver());
        categoryPage=new CategoryPage(driverInstance.getDriver());
        filterPage=new FilterPage(driverInstance.getDriver());
        basketPage=new BasketPage(driverInstance.getDriver());


        Thread.sleep(5000);
        homePage.goToHomePage();


        Thread.sleep(5000);
        for (int i=0; i<4;i++){
            action.tab();
            Thread.sleep(5000);
        }



    }

    @When("Kullanıcı rastgele bir kategori ve alt kategori seçer")
    public void kullanıcı_rastgele_bir_kategori_ve_alt_kategori_seçer() throws Exception {
        wait.until(driver->homePage.isLoaded());
        homePage.goToCategory();
        wait.until(driver->categoryPage.isLoaded());
        categoryPage.clickToSubCategory();
        wait.until(driver->categoryPage.isLoadedForSubCategory());
        categoryPage.clickToSubCategory2();


    }
    @When("Kullanıcı {string}  fiyat aralığını seçer")
    public void kullanıcı_fiyat_aralığını_seçer(String string) throws Exception {
        wait.until(driver->filterPage.isLoadedFilterButton());
        filterPage.goToFilterClick();
        wait.until(driver-> filterPage.isLoadedFilterForWhichElement());
        Thread.sleep(1000);
        filterPage.goToFilterForPriceButtonClick();
        wait.until(driver->filterPage.isLoadedPriceFilterElement());
        filterPage.filterPriceButton50100Click();
        Thread.sleep(1000);
        filterPage.applyButtonClick();
        wait.until(driver-> filterPage.isLoadedSeeProductsForFilterElement());
        filterPage.seeProductsForFilterButtonClick();
    }

    @When("Kullanıcı Çok Değerlendirilenler seçeneğini seçer")
    public void kullanıcı_çok_değerlendirilenler_seçeneğini_seçer() {
        wait.until(driver->filterPage.isLoadedSortButton());
        filterPage.sortButtonClick();
        filterPage.mostRatedClick();
    }

    @When("Kullanıcı ilk ürünü sepete ekler")
    public void kullanıcı_ilk_ürünü_sepete_ekler() {
        wait.until(driver->filterPage.isLoadedFirstProductElement());
        filterPage.selectFirstProductForFilterClick();
        wait.until(driver->basketPage.isLoadedAddToBasketButton());
        basketPage.addToBasketButtonClick();

    }
    @When("Kullanıcı sepete gider ve ürün miktarını artırır")
    public void kullanıcı_sepete_gider_ve_ürün_miktarını_artırır() {
        wait.until(driver->basketPage.isLoadedGoToBasketButton());
        basketPage.goToBasketButtonClick();
        wait.until(driver->basketPage.isLoadedAddForProductButton());
        basketPage.addButtonClick();
    }
    @Then("Kullanıcı ürün fiyatını kontrol eder")
    public void kullanıcı_ürün_fiyatını_kontrol_eder() {

        WebElement findElement=driverInstance.getDriver().findElement(By.id("net.btpro.client.karaca:id/tv_value"));
        String actualValue = findElement.getText(); // Örneğin "529.37 TL" şeklinde olabilir

        // Beklenen değer
        String expectedValue = "519,97"; // Beklenen değer (TL kısmı dahil değil)

        // Para birimini ve boşlukları kaldırma
        String actualFormattedValue = actualValue.replace(" TL", "").trim();

        actualFormattedValue = actualFormattedValue.replace(",", ".");

        expectedValue = expectedValue.replace(",", ".");

        if (actualFormattedValue.equals(expectedValue)) {
            System.out.println("Değer doğrulandı: " + actualValue);
        } else {
            System.out.println("Değer doğrulanamadı. Beklenen: " + expectedValue + ", Gerçekleşen: " + actualValue);

        }

    }

    @Then("Kullanıcı Alışverişi Tamamla butonuna tıklar")
    public void kullanıcı_alışverişi_tamamla_butonuna_tıklar() {
        basketPage.goToPaymentButtonClick();
    }

}
