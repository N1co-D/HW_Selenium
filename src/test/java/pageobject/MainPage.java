package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

/**
 * Главная страница Steam
 */
public class MainPage {
    private static By categoriesButtonTopMenuDesktop = By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']");
    private static By cooperativesCategoryButton = By.xpath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']");
    private static By mysteriesAndDetectivesCategoryButton = By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']");
    private static By inputBox = By.xpath("//input[@id = 'store_nav_search_term']");
    private static By inputBoxConfirm = By.xpath("//a[@id = 'store_search_link']/img");

    public static By getCategoriesButtonTopMenuDesktop() {
        return categoriesButtonTopMenuDesktop;
    }

    public static By getCooperativesCategoryButton() {
        return cooperativesCategoryButton;
    }

    public static By getMysteriesAndDetectivesCategoryButton() {
        return mysteriesAndDetectivesCategoryButton;
    }

    public static By getInputBox() {
        return inputBox;
    }

    public static By getInputBoxConfirm() {
        return inputBoxConfirm;
    }

    public static void getToMainPage() {
        Driver.getDriver().get("https://store.steampowered.com/");
    }

    public static WebElement getWebElement(By xpath) {
        return Driver.getDriver().findElement(xpath);
    }

    public static void clickByJs(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }
}
