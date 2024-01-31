package secondlesson.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XPathPractice {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/?l=russian");

        WebElement popularAndRecommendedSectionUnderMainBanner = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Популярное и рекомендуемое']")); // Раздел "Популярное и рекомендуемое" под основным баннером
        WebElement advertisingBannerBetweenSections = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/category/pirates_ninjas?snr=1_4_4__promo-takeunder' and @class = 'home_page_takeunder']")); // Рекламный баннер между разделами
        WebElement firstLowerSwitchUnderTheSpecialOffersBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn' and id = 'module_special_offers'] | //div[@class = 'carousel_thumbs' and @data-usability = '2']/div[@class = 'focus']")); // Первый нижний переключатель под баннером "Специальные предложения"
        WebElement joinButtonUnderTheCategoriesBanner = driver.findElement(By.xpath("//div[@class = 'home_ctn']//div[@class = 'home_page_sign_in_ctn small']/div[@class='signin_buttons_ctn']/a[text()='присоединитесь']")); // Кнопка "присоединитесь" под разделом-баннером "Категории"
        WebElement newItemsButtonInTheGameListsWithThePopularNewItemsSection = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/explore/new/?snr=1_4_4__tabsmore']/span[text() = 'Новинки']")); // Кнопка "Новинки" в списки игр с разделом "Популярные новинки"

        System.out.println("popularAndRecommendedSectionUnderMainBanner.getText() = " + popularAndRecommendedSectionUnderMainBanner.getText());
        System.out.println("advertisingBannerBetweenSections.isDisplayed() = " + advertisingBannerBetweenSections.isDisplayed());
        System.out.println("firstLowerSwitchUnderTheSpecialOffersBanner.isSelected() = " + firstLowerSwitchUnderTheSpecialOffersBanner.isSelected());
        System.out.println("joinButtonUnderTheCategoriesBanner.isEnabled() = " + joinButtonUnderTheCategoriesBanner.isEnabled());
        System.out.println("newItemsButtonInTheGameListsWithThePopularNewItemsSection.getLocation() = " + newItemsButtonInTheGameListsWithThePopularNewItemsSection.getLocation());

        System.out.println();

        WebElement specialOffersModuleWithAncestor = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Специальные предложения\t\t\t\t\t\t\t\t\t']//ancestor::div[@id= 'module_special_offers']")); // Модуль "Специальные предложения"
        WebElement specialOffersModuleWithDescendant = driver.findElement(By.xpath("//div[@class = 'home_ctn']//descendant::a[@class = 'btn_green_white_innerfade btn_border_2px btn_medium']")); // Модуль "Специальные предложения"
        WebElement allButtonsBottomMenu = driver.findElement(By.xpath("//div[@class = 'valve_links']//following::a[@target = '_blank']")); // Все кнопки в нижней строки страницы
        WebElement genreSearchModuleSideMenu = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Поиск по жанру']//parent::div[@class = 'home_page_gutter_block']")); // Модуль "Поиск по жанру" в боковом меню
        WebElement searchField = driver.findElement(By.xpath("//div[@class = 'searchbox']/child::input")); // Поле для поиска
        WebElement headerLogoImage = driver.findElement(By.xpath("//div[@class = 'logo']//child::img")); // Картинка логотипа в шапке сайта

//        List<WebElement> allSwitchesUnderPopularAndRecommendedBanner = driver.findElements(By.xpath("//div[@id = 'home_maincap_v7']//div[@class = 'carousel_thumbs']/div//attribute::class")); // Все переключатели под баннером "Популярное и рекомендуемое"

        System.out.println("specialOffersModuleWithAncestor.isDisplayed() = " + specialOffersModuleWithAncestor.isDisplayed());
        System.out.println("specialOffersModuleWithDescendant.getSize() = " + specialOffersModuleWithDescendant.getSize());
        System.out.println("allButtonsBottomMenu.isEnabled() = " + allButtonsBottomMenu.isEnabled());
        System.out.println("genreSearchModuleSideMenu.getCssValue(\"width\") = " + genreSearchModuleSideMenu.getCssValue("width"));
        searchField.clear();
        System.out.println("headerLogoImage.getAttribute(\"src\") = " + headerLogoImage.getAttribute("src"));

//        for (int i = 0; i < allSwitchesUnderPopularAndRecommendedBanner.size(); i++) {
//            System.out.print(allSwitchesUnderPopularAndRecommendedBanner.get(i).getCssValue("color") + " ");
//        }

        driver.quit();

    }
}
