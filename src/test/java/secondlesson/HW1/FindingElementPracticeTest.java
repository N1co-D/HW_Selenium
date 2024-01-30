package secondlesson.HW1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.util.*;

public class FindingElementPracticeTest {
    WebDriver driver;

    @DataProvider(name = "devicesData")
    public static Object[][] devicesData() {
        return new Object[][]{
                {"iPhoneX", 375, 812},
                {"GalaxyS9", 360, 740},
                {"iPad", 768, 1024},
                {"Pixel2", 411, 731},
                {"Nexus5X", 411, 731},
                {"GalaxyS5", 360, 640}
        };
    }

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

    @Test (priority = 1)
    public void categoriesButtonTopMenuDesktopDisplayingTest() {
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//span//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "[Десктопная версия] Кнопка \"Категории\" в верхнем меню страницы не отображается.");
    }

    @Test (priority = 2)
    public void categorySectionSideMenuDisplayingTest() {
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Категории']"));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Заголовок раздела \"Категории\" в боковом меню страницы не отображается.");
    }

    @Test (priority = 3)
    public void categorySectionCenterPageDisplayingTest() {
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//div[@class = 'title' and text() = 'Категории']"));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Заголовок раздела \"Категории\" в центре страницы не отображается.");
    }

    @Test(priority = 4, dataProvider = "devicesData")
    public void categoriesButtonTopMenuMobileDisplayingTest(String deviceName, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement categoriesButtonTopMenuMobile = driver.findElement(By.xpath("//span//a[@class = 'pulldown_mobile' and text() = 'Категории']"));
        Assert.assertTrue(categoriesButtonTopMenuMobile.isDisplayed(), "[Мобильная версия] Кнопка \"Категории\" в верхнем меню страницы не отображается.");
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }

}
