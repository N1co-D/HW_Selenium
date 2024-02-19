package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница с фильтром игр в Steam
 */
public class FilterPage {
    private final By sortingParameters = new By.ById("sort_by_trigger");
    private final By releasingDateParameter = new By.ByXPath("//a[text() = 'дате выхода']");
    private final By releasingDateParameterChecking = new By.ByXPath("//div[@id = 'sort_by_dselect_container']/a[text() = 'дате выхода']");
    private final By removeFreeGamesCheckbox = new By.ByXPath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']");
    private final By removeFreeGamesCheckboxActiveStatus = new By.ByXPath("//div[contains(@class, 'checked') and @data-loc = 'Скрыть бесплатные игры']");
    private final By priceIncreaseParameter = new By.ByXPath("//a[@id = 'Price_ASC']");
    private final By priceIncreaseParameterChecking = new By.ByXPath("//div[@id = 'sort_by_dselect_container']/a[text() = 'возрастанию цены']");
    private final By specialOffersCheckbox = new By.ByXPath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']");
    private final By specialOffersCheckboxActiveStatus = new By.ByXPath("//div[contains(@class, 'checked') and @data-loc = 'Специальные предложения']");
    private final By windowsOperatingSystemCheckbox = new By.ByXPath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']");
    private final By windowsOperatingSystemCheckboxActiveStatus = new By.ByXPath("//div[contains(@class, 'checked') and @data-loc = 'Windows']");
    private final By allGames = new By.ByXPath("//div[@id = 'search_resultsRows']/a");
    private final By currentGame = new By.ByXPath(".//span[@class = 'title']");
    private final By gameReleaseDate = new By.ByXPath(".//div[contains(@class, 'search_released')]");
    private final By gamePrice = new By.ByXPath(".//div[@class = 'discount_final_price']");
    JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public void sortingParametersClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(sortingParameters));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(sortingParameters));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел сортировки не найден");
        }
    }

    public void releasingDateParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(releasingDateParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(releasingDateParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'дате выхода' не найден");
        }
    }

    public boolean releasingDateParameterSortingChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(releasingDateParameterChecking));
            return DRIVER.getDriver().findElement(releasingDateParameterChecking).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'дате выхода' не найден");
        }
        return false;
    }

    public void priceIncreaseParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(priceIncreaseParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'возрастанию цены' не найден");
        }
    }

    public boolean priceIncreaseParameterSortingChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameterChecking));
            return DRIVER.getDriver().findElement(priceIncreaseParameterChecking).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'возрастанию цены' не найден");
        }
        return false;
    }

    public void removeFreeGamesCheckboxClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckbox));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(removeFreeGamesCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Скрыть бесплатные игры' не найден");
        }
    }

    public boolean removeFreeGamesCheckboxActiveStatusChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckboxActiveStatus));
            return DRIVER.getDriver().findElement(removeFreeGamesCheckboxActiveStatus).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Скрыть бесплатные игры' не найден");
        }
        return false;
    }

    public void specialOffersCheckboxClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(specialOffersCheckbox));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(specialOffersCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Специальные предложения' не найден");
        }
    }

    public boolean specialOffersCheckboxActiveStatusChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(specialOffersCheckboxActiveStatus));
            return DRIVER.getDriver().findElement(specialOffersCheckboxActiveStatus).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Специальные предложения' не найден");
        }
        return false;
    }

    public void windowsOperatingSystemParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckbox));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(windowsOperatingSystemCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Windows' не найден");
        }
    }

    public boolean windowsOperatingSystemParameterActiveStatusChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckboxActiveStatus));
            return DRIVER.getDriver().findElement(windowsOperatingSystemCheckboxActiveStatus)
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Windows' не найден");
        }
        return false;
    }

    public List<WebElement> getAllGamesWithFilterParameters() {
        try {
            return webDriverWait.until(visibilityOfAllElementsLocatedBy(allGames));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игры по заданным параметрам фильтра не найдены");
        }
        return Collections.emptyList();
    }

    public WebElement getCurrentGame(WebElement game) {
        try {
            webDriverWait.until(visibilityOfElementLocated(currentGame));
            return game.findElement(currentGame);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игра не найдена");
        }
        return game;
    }

    public String getGameReleaseDate(WebElement game) {
        try {
            webDriverWait.until(visibilityOfElementLocated(gameReleaseDate));
            return game.findElement(gameReleaseDate).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Дата выхода игры  не найдена");
        }
        return "Дата выхода игры  не найдена";
    }

    public String getGamePrice(WebElement game) {
        try {
            webDriverWait.until(visibilityOfElementLocated(gamePrice));
            return game.findElement(gamePrice).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Цена игры  не найдена");
        }
        return "Цена игры  не найдена";
    }
}
