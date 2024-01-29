package secondlesson.HW2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XPathDifficultElement {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/?l=russian");

        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        categoriesButtonTopMenuDesktop.click();
        WebElement adventureGameButton = driver.findElement(By.xpath("//a[@class = 'popup_menu_item' and contains(text(), 'Приключенческая игра')]"));
        adventureGameButton.click();

        driver.quit();

    }
}
