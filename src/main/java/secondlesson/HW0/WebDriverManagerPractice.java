package secondlesson.HW0;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverManagerPractice {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        WebDriver driver = null;

        if (props.getProperty("browser").equals("chrome")) {
            System.out.println("Определен браузер: Google Chrome");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
//            driver = WebDriverManager.chromedriver().create(); // Логика также работает без двух предыдущих строк
        } else if (props.getProperty("browser").equals("firefox")) {
            System.out.println("Определен браузер: Mozilla Firefox");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
//            driver = WebDriverManager.firefoxdriver().create(); // Логика также работает без двух предыдущих строк
        } else if (props.getProperty("browser").equals("edge")) {
            System.out.println("Определен браузер: Microsoft Edge");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
//            driver = WebDriverManager.edgedriver().create(); // Логика также работает без двух предыдущих строк
        } else {
            System.out.println("Браузер не определен");
        }

        driver.get("https://button-one.ru/");
        driver.quit();

    }
}
