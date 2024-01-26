package secondlesson;

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

        WebElement element1 = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Популярное и рекомендуемое']")); // Раздел "Популярное и рекомендуемое" под основным баннером
        WebElement element2 = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/category/pirates_ninjas?snr=1_4_4__promo-takeunder' and @class = 'home_page_takeunder']")); // Рекламный баннер с фестивалем пиратов
        WebElement element3 = driver.findElement(By.xpath("//div[@class = 'home_ctn' and id = 'module_special_offers'] | //div[@class = 'carousel_thumbs' and @data-usability = '2']/div[@class = 'focus']")); // Первый нижний переключатель под баннером "Специальные предложения"
        WebElement element4 = driver.findElement(By.xpath("//div[@class = 'home_ctn']//div[@class = 'home_page_sign_in_ctn small']/div[@class='signin_buttons_ctn']/a[text()='присоединитесь']")); // Кнопка "присоединитесь" под разделом-баннером "Категории"
        WebElement element5 = driver.findElement(By.xpath("//a[@href = 'https://store.steampowered.com/explore/new/?snr=1_4_4__tabsmore']/span[text() = 'Новинки']")); // Кнопка "Новинки" в списки игр с разделом "Популярные новинки

        System.out.println("element1.getText() = " + element1.getText());
        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());
        System.out.println("element3.isSelected() = " + element3.isSelected());
        System.out.println("element4.isEnabled() = " + element4.isEnabled());
        System.out.println("element5.getLocation() = " + element5.getLocation());

        System.out.println();

        WebElement element6 = driver.findElement(By.xpath("//h2[@class = 'home_page_content_title' and text() = 'Специальные предложения\t\t\t\t\t\t\t\t\t']//ancestor::div[@id= 'module_special_offers']")); // Модуль "Специальные предложения"
        WebElement element7 = driver.findElement(By.xpath("//div[@class = 'home_ctn']//descendant::a[@class = 'btn_green_white_innerfade btn_border_2px btn_medium']")); // Модуль "Специальные предложения"
        WebElement element8 = driver.findElement(By.xpath("//div[@class = 'valve_links']//following::a[@target = '_blank']")); // Все кнопки в нижней строки страницы
        WebElement element9 = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Поиск по жанру']//parent::div[@class = 'home_page_gutter_block']")); // Модуль "Поиск по жанру" в боковом меню
        WebElement element10 = driver.findElement(By.xpath("//div[@class = 'searchbox']/child::input")); // Поле для поиска
        WebElement element11 = driver.findElement(By.xpath("//div[@class = 'logo']//child::img")); // Картинка логотипа в шапке сайта

//        List<WebElement> elements = driver.findElements(By.xpath("//div[@id = 'home_maincap_v7']//div[@class = 'carousel_thumbs']/div//attribute::class")); // Все переключатели под баннером "Популярное и рекомендуемое"

        System.out.println("element6.isDisplayed() = " + element6.isDisplayed());
        System.out.println("element7.getSize() = " + element7.getSize());
        System.out.println("element8.isEnabled() = " + element8.isEnabled());
        System.out.println("element9.getCssValue(\"width\") = " + element9.getCssValue("width"));
        element10.clear();
        System.out.println("element11.getAttribute(\"src\") = " + element11.getAttribute("src"));

//        for (int i = 0; i < elements.size(); i++) {
//            System.out.print(elements.get(i).getCssValue("color") + " ");
//        }

        driver.quit();

    }
}
