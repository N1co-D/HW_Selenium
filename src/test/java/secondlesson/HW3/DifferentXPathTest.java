package secondlesson.HW3;

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

public class DifferentXPathTest {
    WebDriver driver;

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

    @Test (priority = 1)
    public void firstLowerSwitchUnderTheSpecialOffersBannerDisplayingTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement firstLowerSwitchUnderTheSpecialOffersBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn' and id = 'module_special_offers'] | //div[@class = 'carousel_thumbs' and @data-usability = '2']/div[@class = 'focus']")); // Первый нижний переключатель под баннером "Специальные предложения"
        Assert.assertTrue(firstLowerSwitchUnderTheSpecialOffersBanner.isDisplayed());
        driver.quit();
    }

    @Test (priority = 2)
    public void gettingTextFromPopularAndRecommendedSelectionTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement popularAndRecommendedSectionUnderMainBanner = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Популярное и рекомендуемое']")); // Раздел "Популярное и рекомендуемое" под основным баннером
        Assert.assertEquals(popularAndRecommendedSectionUnderMainBanner.getText(), "ПОПУЛЯРНОЕ И РЕКОМЕНДУЕМОЕ");
        driver.quit();
    }

    @Test (priority = 3)
    public void advertisingBannerBetweenSectionsClickingTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement advertisingBannerBetweenSections = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/category/pirates_ninjas?snr=1_4_4__promo-takeunder' and @class = 'home_page_takeunder']")); // Рекламный баннер между разделами
        advertisingBannerBetweenSections.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/category/pirates_ninjas");
        driver.quit();
    }

    @Test (priority = 4)
    public void joinButtonUnderTheCategoriesBannerEnabledTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement joinButtonUnderTheCategoriesBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn']//div[@class = 'home_page_sign_in_ctn small']/div[@class='signin_buttons_ctn']/a[text()='присоединитесь']")); // Кнопка "присоединитесь" под разделом-баннером "Категории"
        Assert.assertTrue(joinButtonUnderTheCategoriesBanner.isEnabled());
        driver.quit();
    }

    @Test (priority = 5)
    public void newItemsButtonInTheGameListsCheckingFontSizeTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement newItemsButtonInTheGameLists = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/explore/new/?snr=1_4_4__tabsmore']/span[text() = 'Новинки']")); // Кнопка "Новинки" в списки игр с разделом "Популярные новинки"
        Assert.assertEquals(newItemsButtonInTheGameLists.getCssValue("font-size"), "12px");
        driver.quit();
    }

    @Test (priority = 6)
    public void specialOffersModuleWithAncestorDisplayingTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement specialOffersModuleWithAncestor = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Специальные предложения\t\t\t\t\t\t\t\t\t']//ancestor::div[@id= 'module_special_offers']")); // Модуль "Специальные предложения"
        Assert.assertTrue(specialOffersModuleWithAncestor.isDisplayed());
        driver.quit();
    }

    @Test (priority = 7)
    public void specialOffersModuleWithDescendantCheckingSizeTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement specialOffersModuleWithDescendant = driver.findElement(By.xpath("//div[@class = 'home_ctn']//descendant::a[@class = 'btn_green_white_innerfade btn_border_2px btn_medium']")); // Модуль "Специальные предложения"
        Assert.assertEquals(specialOffersModuleWithDescendant.getAttribute("href"), "https://store.steampowered.com/login/?snr=1_4_4__more-content-login");
        driver.quit();
    }

    @Test (priority = 8)
    public void allButtonsBottomMenuEnabledTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement allButtonsBottomMenu = driver.findElement(By.xpath("//div[@class = 'valve_links']//following::a[@target = '_blank']")); // Все кнопки в нижней строки страницы
        Assert.assertTrue(allButtonsBottomMenu.isEnabled());
        driver.quit();
    }

    @Test (priority = 9)
    public void genreSearchModuleSideMenuCheckingWidthTest() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement genreSearchModuleSideMenu = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Поиск по жанру']//parent::div[@class = 'home_page_gutter_block']")); // Модуль "Поиск по жанру" в боковом меню
        Assert.assertEquals(genreSearchModuleSideMenu.getCssValue("width"), "210px");
        driver.quit();
    }

    @Test (priority = 10)
    public void headerLogoImageCheckingSrc() throws IOException {
        WebDriver driver = browserDefinition();
        driver.get("https://store.steampowered.com/");
        WebElement headerLogoImage = driver.findElement(By.xpath("//div[@class = 'logo']//child::img")); // Картинка логотипа в шапке сайта
        Assert.assertEquals(headerLogoImage.getAttribute("src"), "https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016");
        driver.quit();
    }
}
