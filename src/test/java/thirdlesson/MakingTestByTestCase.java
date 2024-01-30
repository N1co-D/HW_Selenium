package thirdlesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MakingTestByTestCase {
    WebDriver driver;

    @BeforeClass
    public WebDriver browserDefinition() {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();

        try {
            props.load(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла!");
            throw new RuntimeException(e);
        }

        if (props.getProperty("browser").equals("chrome")) {
            System.out.println("Определен браузер: Google Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (props.getProperty("browser").equals("firefox")) {
            System.out.println("Определен браузер: Mozilla Firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("start-maximized");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (props.getProperty("browser").equals("edge")) {
            System.out.println("Определен браузер: Microsoft Edge");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("start-maximized");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else {
            System.err.println("Браузер не определен");
        }

        return driver;
    }

    @Test
    public void checkingCorrectnessOfPriceAndCurrencyTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://store.steampowered.com/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, " + 2250 + ");");
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//img[@alt = 'TEKKEN 8']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']"));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Игра по указанному XPath не найдена.");
        String priceText = categoriesButtonTopMenuDesktop.getText();
        String[] parts = priceText.split(" ");
        Assert.assertEquals(parts[0], "4199", "Указана некорректная цена товара");
        Assert.assertEquals(parts[1], "pуб.", "Указана некорректная валюта в стоимости");
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }

}
