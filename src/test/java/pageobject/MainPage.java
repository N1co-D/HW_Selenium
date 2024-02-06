package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.DriverSingleton;
import static utils.DriverSingleton.*;

/**
 * Главная страница Steam
 */
public class MainPage {
    private By categoriesButtonTopMenuDesktop = By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']");
    private static By cooperativesCategoryButton = By.xpath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']");
    private static By mysteriesAndDetectivesCategoryButton = By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']");
    private static By inputBox = By.xpath("//input[@id = 'store_nav_search_term']");
    private static By inputBoxConfirm = By.xpath("//a[@id = 'store_search_link']/img");



//    public static By getCategoriesButtonTopMenuDesktop() {
//        return categoriesButtonTopMenuDesktop;
//    }

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
        DriverSingleton.getDriver().get("https://store.steampowered.com/");
    }

    public static WebElement getWebElement(By xpath) {
        return DriverSingleton.getDriver().findElement(xpath);
    }

    public void categoriesButtonTopMenuDesktopClick(){
        WebElement categoriesButtonTopMenuDesktop = DRIVER.getDriver().findElement(By.xpath(""));
        categoriesButtonTopMenuDesktop.click();
    }

    public static void clickByJs(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }
}
