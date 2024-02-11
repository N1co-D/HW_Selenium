package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Главная страница Steam
 */
public class MainPage {
    private By categoriesButtonTopMenuDesktop = new By.ByXPath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']");
    private By cooperativesCategoryButton = new By.ByXPath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']");
    private By mysteriesAndDetectivesCategoryButton = new By.ByXPath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']");
    private By inputBox = new By.ByXPath("//input[@id = 'store_nav_search_term']");
    private By inputBoxConfirm = new By.ByXPath("//a[@id = 'store_search_link']/img");
    private Actions actions = new Actions(DRIVER.getDriver());
    private WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));

    public static void getToMainPage() {
        DRIVER.getDriver().get("https://store.steampowered.com/");
    }

    public void categoriesButtonTopMenuDesktopClick() {
        webDriverWait.until(visibilityOfElementLocated(categoriesButtonTopMenuDesktop));
        DRIVER.getDriver().findElement(categoriesButtonTopMenuDesktop).click();
    }

    public void cooperativesCategoryButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(cooperativesCategoryButton));
        DRIVER.getDriver().findElement(cooperativesCategoryButton).click();
    }

    public void mysteriesAndDetectivesCategoryButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(mysteriesAndDetectivesCategoryButton));
        DRIVER.getDriver().findElement(mysteriesAndDetectivesCategoryButton).click();
    }

    public void inputBoxWriteText(String text) {
        webDriverWait.until(visibilityOfElementLocated(inputBox));
        DRIVER.getDriver().findElement(inputBox).click();
        actions.sendKeys(text).perform();
    }

    public void inputBoxConfirmClick() {
        webDriverWait.until(visibilityOfElementLocated(inputBoxConfirm));
        DRIVER.getDriver().findElement(inputBoxConfirm).click();
    }
}
