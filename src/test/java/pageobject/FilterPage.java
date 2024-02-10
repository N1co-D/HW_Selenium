package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSingleton;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница с фильтром в Steam
 */
public class FilterPage {
    private By sortingParameters = new By.ById("sort_by_trigger");
    private By showMoreButton = new By.ByXPath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']");
    private By releasingDateParameter = new By.ByXPath("//a[@class = 'inactive_selection' and text() = 'дате выхода']");
    private By fieldWithSearchResults = new By.ByXPath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]");
    private By fieldWithSearchResultsWhereCountIsNull = new By.ByXPath("//div[@id = 'search_results']/div[contains(text(), 'Результатов по вашему запросу:')]");
    private By removeFreeGamesCheckbox = new By.ByXPath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']");
    private By forMultiplePlayersParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']");
    private By priceIncreaseParameter = new By.ByXPath("//a[@id = 'Price_ASC']");
    private By specialOffersCheckbox = new By.ByXPath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']");
    private By windowsOperatingSystemParameter = new By.ByXPath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']");
    private By allGames = new By.ByXPath("//div[@id = 'search_resultsRows']/a");
    private By currentGame = new By.ByXPath("//div[@id = 'search_resultsRows']/a//span[@class = 'title']");
    private By gameReleaseDate = new By.ByXPath("//div[@id = 'search_resultsRows']/a//div[contains(@class, 'search_released')]");
    private By gamePrice = new By.ByXPath("//div[@id = 'search_resultsRows']/a//div[@class = 'discount_final_price']");
    Actions actions = new Actions(DRIVER.getDriver());
    private WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));

    public void sortingParametersClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(sortingParameters));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(sortingParameters));
    }

    public void releasingDateParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(releasingDateParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(releasingDateParameter));
    }

    public void fieldWithSearchResultsClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(fieldWithSearchResults));
    }

    public By fieldWithSearchResultsPath() {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return fieldWithSearchResults;
    }

    public String fieldWithSearchResultsGetText() {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return DRIVER.getDriver().findElement(fieldWithSearchResults).getText();
    }

    public void removeFreeGamesCheckboxClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckbox));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(removeFreeGamesCheckbox));
    }

    public List <WebElement> getAllGamesWithFilterParameters() {
        webDriverWait.until(visibilityOfElementLocated(allGames));
        return DRIVER.getDriver().findElements(allGames);
    }

    public By getCurrentGame() {
        webDriverWait.until(visibilityOfElementLocated(currentGame));
        return currentGame;
    }

    public By getGameReleaseDate() {
        webDriverWait.until(visibilityOfElementLocated(gameReleaseDate));
        return gameReleaseDate;
    }

    public By getGamePrice() {
        webDriverWait.until(visibilityOfElementLocated(gamePrice));
        return gamePrice;
    }
}
