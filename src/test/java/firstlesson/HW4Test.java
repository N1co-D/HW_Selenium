package firstlesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HW4Test {
    private WebDriver driver;

    @BeforeClass
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void currentUrlTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        String url1 = driver.getCurrentUrl();

        Assert.assertEquals(url1, "https://store.steampowered.com/?l=russian");
    }

    @Test
    public void pageTitleTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        String title1 = driver.getTitle();

        Assert.assertEquals(title1, "Добро пожаловать в Steam");
    }

    @Test
    public void navigateToTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        driver.navigate().to("https://button-one.ru/");

        String url1 = driver.getCurrentUrl();

        Assert.assertEquals(url1, "https://button-one.ru/");
    }

    @Test
    public void navigateBackTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        driver.navigate().to("https://button-one.ru/");
        driver.navigate().back();

        String url1 = driver.getCurrentUrl();

        Assert.assertEquals(url1, "https://store.steampowered.com/?l=russian");
    }

    @Test
    public void navigateForwardTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        driver.navigate().to("https://button-one.ru/");
        driver.navigate().back();
        driver.navigate().forward();

        String url1 = driver.getCurrentUrl();

        Assert.assertEquals(url1, "https://button-one.ru/");
    }

    @Test
    public void findElementTest() {
        driver.get("https://store.steampowered.com/?l=russian");

        WebElement element1 = driver.findElement(By.id("language_pulldown"));

        Assert.assertNotNull(element1);
    }

}
