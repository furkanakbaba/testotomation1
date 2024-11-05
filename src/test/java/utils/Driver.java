package utils;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    public static AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }
    @Before
    public void initializeDriver()throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Pixel 7 Pro API 33");
        capabilities.setCapability("appium:app", "C:/karaca4/app.apk/app.apk");
        capabilities.setCapability("appium:appPackage", "net.btpro.client.karaca");
        capabilities.setCapability("appium:appActivity", "net.btpro.client.karaca.ui.main.MainNavHostActivity");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:udid","emulator-5554");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4724/"),capabilities);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver kapatıldı.");
        }
    }
}
