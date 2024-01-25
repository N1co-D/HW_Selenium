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

        WebElement element1 = driver.findElement(By.xpath("//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")); // Кнопка "Категории" в верхней строке
        WebElement element2 = driver.findElement(By.xpath("//span//a[@class = 'pulldown_mobile' and text() = 'Категории']"));
        WebElement element3 = driver.findElement(By.xpath("//div[@class = 'gutter_header pad' and text() = 'Категории']"));
        WebElement element4 = driver.findElement(By.xpath("//div[@class = 'title' and text() = 'Категории']"));

        System.out.println("element1.isDisplayed() = " + element1.isDisplayed());
        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());
        System.out.println("element3.isDisplayed() = " + element3.isDisplayed());
        System.out.println("element4.isDisplayed() = " + element4.isDisplayed());

        driver.quit();
    }
}