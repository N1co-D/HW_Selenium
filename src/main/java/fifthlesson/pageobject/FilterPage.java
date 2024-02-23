package fifthlesson.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static fifthlesson.utils.DriverSingleton.MANAGER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

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
    private final By allGamesFromList = new By.ByXPath("//div[@id = 'search_resultsRows']/a");
    private final By currentGame = new By.ByXPath(".//span[@class = 'title']");
    private final By gameReleaseDate = new By.ByXPath(".//div[contains(@class, 'search_released')]");
    private final By gamePrice = new By.ByXPath(".//div[@class = 'discount_final_price']");
    JavascriptExecutor jsExecutor = (JavascriptExecutor) MANAGER.getDriver();
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    public void sortingParametersClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(sortingParameters));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(sortingParameters));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел сортировки не найден");
            throw noSuchElementException;
        }
    }

    public void releasingDateParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(releasingDateParameter));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(releasingDateParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'дате выхода' не найден");
            throw noSuchElementException;
        }
    }

    public boolean releasingDateParameterSortingChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(releasingDateParameterChecking))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'дате выхода' не найден");
            throw noSuchElementException;
        }
    }

    public void priceIncreaseParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameter));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(priceIncreaseParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'возрастанию цены' не найден");
            throw noSuchElementException;
        }
    }

    public boolean priceIncreaseParameterSortingChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameterChecking))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр сортировки 'возрастанию цены' не найден");
            throw noSuchElementException;
        }
    }

    public void removeFreeGamesCheckboxClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckbox));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(removeFreeGamesCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Скрыть бесплатные игры' не найден");
            throw noSuchElementException;
        }
    }

    public boolean removeFreeGamesCheckboxActiveStatusChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckboxActiveStatus))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Скрыть бесплатные игры' не найден");
            throw noSuchElementException;
        }
    }

    public void specialOffersCheckboxClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(specialOffersCheckbox));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(specialOffersCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Специальные предложения' не найден");
            throw noSuchElementException;
        }
    }

    public boolean specialOffersCheckboxActiveStatusChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(specialOffersCheckboxActiveStatus))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Специальные предложения' не найден");
            throw noSuchElementException;
        }
    }

    public void windowsOperatingSystemParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckbox));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(windowsOperatingSystemCheckbox));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Windows' не найден");
            throw noSuchElementException;
        }
    }

    public boolean windowsOperatingSystemParameterActiveStatusChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckboxActiveStatus))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Чекбокс 'Windows' не найден");
            throw noSuchElementException;
        }
    }

    private List<WebElement> getAllGamesWithFilterParameters() {
        try {
            return webDriverWait.until(visibilityOfAllElementsLocatedBy(allGamesFromList));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игры по заданным параметрам фильтра не найдены");
            throw noSuchElementException;
        }
    }

    public Map<String, WebElement> searchingForRequiredGameInList(String observedGameSeries) {
        List<WebElement> allGamesFromList = getAllGamesWithFilterParameters();
        WebElement foundGame = null;
        WebElement currentGameTitle = null;
        FilterPage filterPage = new FilterPage();

        for (WebElement game : allGamesFromList) {
            currentGameTitle = filterPage.getCurrentGameTitle(game);
            if (currentGameTitle.getText().startsWith(observedGameSeries)) {
                foundGame = game;
                break;
            }
        }

        Map<String, WebElement> foundGameInformation = new HashMap<>();
        foundGameInformation.put("gameElement", foundGame);
        foundGameInformation.put("gameTitle", currentGameTitle);
        return foundGameInformation;
    }

    private WebElement getCurrentGameTitle(WebElement game) {
        try {
            return game.findElement(currentGame);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игра не найдена");
            throw noSuchElementException;
        }
    }

    public String getGameReleaseDate(WebElement game) {
        try {
            webDriverWait.until(visibilityOfElementLocated(gameReleaseDate)).getText();
            return game.findElement(gameReleaseDate).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Дата выхода игры не найдена");
            throw noSuchElementException;
        }
    }

    public String getGamePrice(WebElement game) {
        try {
            webDriverWait.until(visibilityOfElementLocated(gamePrice)).getText();
            return game.findElement(gamePrice).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Цена игры не найдена");
            throw noSuchElementException;
        }
    }
}
