package fifthlesson.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public enum DriverSingleton {
    MANAGER;
//    private WebDriver driver;

    DriverSingleton() {
    }

//    public WebDriver getDriver() {
//        if (driver == null) {
//            ConfigPropertiesProcessing configPropertiesProcessing = new ConfigPropertiesProcessing();
//            System.out.println("Определен браузер: " + configPropertiesProcessing.getBrowserFromProperty());
//            driver = WebDriverManager.getInstance(configPropertiesProcessing.getBrowserFromProperty()).create();
//            Configuration.browser = configPropertiesProcessing.getBrowserFromProperty();
//            Configuration.driverManagerEnabled = true;
//            Configuration.clickViaJs = true;
//            Configuration.browserSize = "1920×1080";
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        }
//        return driver;
//    }

    public WebDriver getDriver() {
//        if (WebDriverRunner.getWebDriver() == null) {
        ConfigPropertiesProcessing configPropertiesProcessing = new ConfigPropertiesProcessing();
        System.out.println("Определен браузер: " + configPropertiesProcessing.getBrowserFromProperty());
        Configuration.browser = configPropertiesProcessing.getBrowserFromProperty();
//        Configuration.browserSize = "1920x1080";
//            Configuration.driverManagerEnabled = true;
//            Configuration.clickViaJs = true;
//            Configuration.browserSize = "1920×1080";
//            Selenide.webdriver().driver().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        }
        Configuration.browserSize = configPropertiesProcessing.getSizeOfBrowserFromProperty();
        return WebDriverRunner.getWebDriver();
    }
}

