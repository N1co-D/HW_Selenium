package fifthlesson.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static fifthlesson.utils.DriverSingleton.MANAGER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Главная страница Steam
 */
public class MainPage {
    private final By categoriesButtonTopMenuDesktop = new By.ByXPath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']");
    private final By cooperativesCategoryButton = new By.ByXPath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']");
    private final By mysteriesAndDetectivesCategoryButton = new By.ByXPath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']");
    private final By inputBox = new By.ByXPath("//input[@id = 'store_nav_search_term']");
    private final By inputBoxConfirm = new By.ByXPath("//a[@id = 'store_search_link']/img");
    private final Actions actions = new Actions(MANAGER.getDriver());
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    public void categoriesButtonTopMenuDesktopClick() {
        try {
            webDriverWait.until(visibilityOfElementLocated(categoriesButtonTopMenuDesktop)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Категории' в верхнем меню не найдена");
            throw noSuchElementException;
        }
    }

    public void cooperativesCategoryButtonClick() {
        try {
            webDriverWait.until(visibilityOfElementLocated(cooperativesCategoryButton)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка с категорией 'Кооперативы' не найдена");
            throw noSuchElementException;
        }
    }

    public void mysteriesAndDetectivesCategoryButtonClick() {
        try {
            webDriverWait.until(visibilityOfElementLocated(mysteriesAndDetectivesCategoryButton)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка с категорией 'Тайны и детективы' не найдена");
            throw noSuchElementException;
        }
    }

    public void inputBoxWriteText(String text) {
        try {
            webDriverWait.until(visibilityOfElementLocated(inputBox)).click();
            actions.sendKeys(text).perform();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Текстовое поле для ввода не найдено");
            throw noSuchElementException;
        }
    }

    public void inputBoxConfirmClick() {
        try {
            webDriverWait.until(visibilityOfElementLocated(inputBoxConfirm)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка для подтверждения запроса в текстовом поле не найдена");
            throw noSuchElementException;
        }
    }
}
