import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HW4Test {
    private WebDriver driver1;
    private WebDriver driver2;

    @BeforeClass
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
    }

    @Test
    public void currentUrlTest() {
        driver1.get("https://button-one.ru/");
        driver2.get("https://store.steampowered.com/?l=russian");

        String url1 = driver1.getCurrentUrl();
        String url2 = driver2.getCurrentUrl();

        Assert.assertEquals(url1, "https://button-one.ru/");
        Assert.assertEquals(url2, "https://store.steampowered.com/?l=russian");
    }

    @Test
    public void pageTitleTest() {
        driver1.get("https://button-one.ru/");
        driver2.get("https://store.steampowered.com/?l=russian");

        String title1 = driver1.getTitle();
        String title2 = driver2.getTitle();

        Assert.assertEquals(title1, "Компания Button One");
        Assert.assertEquals(title2, "Добро пожаловать в Steam");
    }

    @Test
    public void navigateToTest() {
        driver1.get("https://button-one.ru/");

        driver1.navigate().to("https://store.steampowered.com/?l=russian");

        String url1 = driver1.getCurrentUrl();

        Assert.assertEquals(url1, "https://store.steampowered.com/?l=russian");
    }

    @Test
    public void navigateBackTest() {
        driver1.get("https://button-one.ru/");

        driver1.navigate().to("https://store.steampowered.com/?l=russian");
        driver1.navigate().back();

        String url1 = driver1.getCurrentUrl();

        Assert.assertEquals(url1, "https://button-one.ru/");
    }

    @Test
    public void navigateForwardTest() {
        driver1.get("https://button-one.ru/");

        driver1.navigate().to("https://store.steampowered.com/?l=russian");
        driver1.navigate().back();
        driver1.navigate().forward();

        String url1 = driver1.getCurrentUrl();

        Assert.assertEquals(url1, "https://store.steampowered.com/?l=russian");
    }

    @Test
    public void findElementTest() {
        driver2.get("https://store.steampowered.com/?l=russian");

        WebElement element2 = driver2.findElement(By.id("language_pulldown"));

        Assert.assertNotNull(element2);
    }

}
