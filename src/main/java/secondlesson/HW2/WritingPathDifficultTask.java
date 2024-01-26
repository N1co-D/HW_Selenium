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

public class WritingPathDifficultTask {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/?l=russian");

        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        categoriesButtonTopMenuDesktop.click();
        WebElement adventureGameButton = driver.findElement(By.xpath("//div[@class = 'popup_menu_subheader popup_genre_expand_header responsive_hidden' and @data-genre-group = 'adventure']/descendant::a"));
        adventureGameButton.click();

//        WebElement adventureRolePlayingGameButton = driver.findElement(By.xpath("//div[@class = 'popup_menu popup_menu_browse leftborder']//div[@class = 'popup_genre_expand_content responsive_hidden'] //a[@class = 'popup_menu_item' and text() = 'Приключенческая ролевая игра']"));

        driver.quit();

    }
}
