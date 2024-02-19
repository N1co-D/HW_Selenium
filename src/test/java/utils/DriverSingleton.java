package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public enum DriverSingleton {
    MANAGER;
    private WebDriver driver;

    DriverSingleton() {
    }

    public WebDriver getDriver() {
        if (driver == null) {
            ConfigPropertiesProcessing configPropertiesProcessing = new ConfigPropertiesProcessing();
            System.out.println("Определен браузер: " + configPropertiesProcessing.getBrowserFromProperty());
            driver = WebDriverManager.getInstance(configPropertiesProcessing.getBrowserFromProperty()).create();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }
        return driver;
    }
}
