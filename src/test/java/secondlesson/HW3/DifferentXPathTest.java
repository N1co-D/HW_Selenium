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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DifferentXPathTest {
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

    @Test (priority = 1)
    public void firstLowerSwitchUnderTheSpecialOffersBannerDisplayingTest() {
        driver.get("https://store.steampowered.com/");
        WebElement firstLowerSwitchUnderTheSpecialOffersBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn' and id = 'module_special_offers'] | //div[@class = 'carousel_thumbs' and @data-usability = '2']/div[@class = 'focus']"));
        Assert.assertTrue(firstLowerSwitchUnderTheSpecialOffersBanner.isDisplayed(), "Первый нижний переключатель под баннером \"Специальные предложения\" отображается");
    }

    @Test (priority = 2)
    public void gettingTextFromPopularAndRecommendedSelectionTest() {
        driver.get("https://store.steampowered.com/");
        WebElement popularAndRecommendedSectionUnderMainBanner = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Популярное и рекомендуемое']"));
        Assert.assertEquals(popularAndRecommendedSectionUnderMainBanner.getText(), "ПОПУЛЯРНОЕ И РЕКОМЕНДУЕМОЕ", "Ожидаемое и фактическое значение заголовка под основным баннером не совпадают");
    }

    @Test (priority = 3)
    public void advertisingBannerBetweenSectionsClickingTest() {
        driver.get("https://store.steampowered.com/");
        WebElement advertisingBannerBetweenSections = driver.findElement(By.xpath("//a[@class = 'global_action_link' and text() = 'войти']"));
        advertisingBannerBetweenSections.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://store.steampowered.com/login/"), "Ссылка кнопки \"войти\" осуществляет переход не на ожидаемую страницу");
    }

    @Test (priority = 4)
    public void joinButtonUnderTheCategoriesBannerEnabledTest() {
        driver.get("https://store.steampowered.com/");
        WebElement joinButtonUnderTheCategoriesBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn']//div[@class = 'home_page_sign_in_ctn small']/div[@class='signin_buttons_ctn']/a[text()='присоединитесь']"));
        Assert.assertTrue(joinButtonUnderTheCategoriesBanner.isEnabled(), "Кнопка \"присоединитесь\" под разделом-баннером \"Категории\" недоступна");
    }

    @Test (priority = 5)
    public void newItemsButtonInTheGameListsCheckingFontSizeTest() {
        driver.get("https://store.steampowered.com/");
        WebElement newItemsButtonInTheGameLists = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/explore/new/?snr=1_4_4__tabsmore']/span[text() = 'Новинки']"));
        Assert.assertEquals(newItemsButtonInTheGameLists.getCssValue("font-size"), "12px", "Размер шрифта кнопки \"Новинки\" в списке игр с разделом \"Популярные новинки\" не соответствует ожидаемому");
    }

    @Test (priority = 6)
    public void specialOffersModuleWithAncestorDisplayingTest() {
        driver.get("https://store.steampowered.com/");
        WebElement specialOffersModuleWithAncestor = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Специальные предложения\t\t\t\t\t\t\t\t\t']//ancestor::div[@id= 'module_special_offers']"));
        Assert.assertTrue(specialOffersModuleWithAncestor.isDisplayed(), "Модуль \"Специальные предложения\" не отображается");
    }

    @Test (priority = 7)
    public void specialOffersModuleWithDescendantCheckingSizeTest() {
        driver.get("https://store.steampowered.com/");
        WebElement specialOffersModuleWithDescendant = driver.findElement(By.xpath("//div[@class = 'home_ctn']//descendant::a[@class = 'btn_green_white_innerfade btn_border_2px btn_medium']"));
        Assert.assertEquals(specialOffersModuleWithDescendant.getAttribute("href"), "https://store.steampowered.com/login/?snr=1_4_4__more-content-login", "Значение атрибута \"href\" у модуля \"Специальные предложения\" не соответствует ожидаемому");
    }

    @Test (priority = 8)
    public void allButtonsBottomMenuEnabledTest() {
        driver.get("https://store.steampowered.com/");
        WebElement allButtonsBottomMenu = driver.findElement(By.xpath("//div[@class = 'valve_links']//following::a[@target = '_blank']"));
        Assert.assertTrue(allButtonsBottomMenu.isEnabled(), "Все кнопки в нижней строки страницы недоступны");
    }

    @Test (priority = 9)
    public void genreSearchModuleSideMenuCheckingWidthTest() {
        driver.get("https://store.steampowered.com/");
        WebElement genreSearchModuleSideMenu = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Поиск по жанру']//parent::div[@class = 'home_page_gutter_block']"));
        Assert.assertEquals(genreSearchModuleSideMenu.getCssValue("width"), "210px", "Ширина модуля \"Поиск по жанру\" в боковом меню не соответствует ожидаемой");
    }

    @Test (priority = 10)
    public void headerLogoImageCheckingSrc() {
        driver.get("https://store.steampowered.com/");
        WebElement headerLogoImage = driver.findElement(By.xpath("//div[@class = 'logo']//child::img"));
        Assert.assertTrue(headerLogoImage.getAttribute("src").contains("shared/images/header/logo_steam"), "Значение атрибута \"src\" у картинки логотипа в шапке сайта не соответствует ожидаемому");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
