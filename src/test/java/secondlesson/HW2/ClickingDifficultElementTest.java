package secondlesson.HW2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClickingDifficultElementTest {
    private WebDriver driver;

    @BeforeClass
    public WebDriver browserDefinition() throws IOException {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));

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
    public void clickingAdventureGameButtonTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        categoriesButtonTopMenuDesktop.click();
        WebElement adventureGameButton = driver.findElement(By.xpath("//a[@class = 'popup_menu_item' and contains(text(), 'Приключенческая игра')]"));
        adventureGameButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/category/adventure/");
        driver.quit();
    }

}

