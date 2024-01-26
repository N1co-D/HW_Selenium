package secondlesson.HW1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FindingElementPractice {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/?l=russian");

        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")); // Кнопка "Категории" в верхней строке
        WebElement categoriesButtonTopMenuMobile = driver.findElement(By.xpath("//span//a[@class = 'pulldown_mobile' and text() = 'Категории']"));  // Кнопка "Категории" в верхней строке (мобильная версия)
        WebElement CategorySectionSideMenu = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Категории']")); // Раздел "Категория" в боковом меню
        WebElement CategorySectionCenterPage = driver.findElement(By.xpath("//div[@class = 'title' and text() = 'Категории']")); // Раздел "Категория" в середине страницы

        System.out.println("categoriesButtonTopMenuDesktop.isDisplayed() = " + categoriesButtonTopMenuDesktop.isDisplayed());
        System.out.println("categoriesButtonTopMenuMobile.isDisplayed() = " + categoriesButtonTopMenuMobile.isDisplayed());
        System.out.println("CategorySectionSideMenu.isDisplayed() = " + CategorySectionSideMenu.isDisplayed());
        System.out.println("CategorySectionCenterPage.isDisplayed() = " + CategorySectionCenterPage.isDisplayed());

        driver.quit();

    }
}