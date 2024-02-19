package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница с фильтром в Steam
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
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

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

    public boolean releasingDateParameterSortingChecking() {
        webDriverWait.until(visibilityOfElementLocated(releasingDateParameterChecking));
        return DRIVER.getDriver().findElement(releasingDateParameterChecking).isDisplayed();
    }

    public void priceIncreaseParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(priceIncreaseParameter));
    }

    public boolean priceIncreaseParameterSortingChecking() {
        webDriverWait.until(visibilityOfElementLocated(priceIncreaseParameterChecking));
        return DRIVER.getDriver().findElement(priceIncreaseParameterChecking).isDisplayed();
    }

    public void removeFreeGamesCheckboxClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckbox));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(removeFreeGamesCheckbox));
    }

    public boolean removeFreeGamesCheckboxActiveStatusChecking() {
        webDriverWait.until(visibilityOfElementLocated(removeFreeGamesCheckboxActiveStatus));
        return DRIVER.getDriver().findElement(removeFreeGamesCheckboxActiveStatus).isDisplayed();
    }

    public void specialOffersCheckboxClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(specialOffersCheckbox));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(specialOffersCheckbox));
    }

    public boolean specialOffersCheckboxActiveStatusChecking() {
        webDriverWait.until(visibilityOfElementLocated(specialOffersCheckboxActiveStatus));
        return DRIVER.getDriver().findElement(specialOffersCheckboxActiveStatus).isDisplayed();
    }

    public void windowsOperatingSystemParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckbox));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(windowsOperatingSystemCheckbox));
    }

    public boolean windowsOperatingSystemParameterActiveStatusChecking() {
        webDriverWait.until(visibilityOfElementLocated(windowsOperatingSystemCheckboxActiveStatus));
        return DRIVER.getDriver().findElement(windowsOperatingSystemCheckboxActiveStatus).isDisplayed();
    }

    public List<WebElement> getAllGamesWithFilterParameters() {
        return webDriverWait.until(visibilityOfAllElementsLocatedBy(allGames));
    }

    public WebElement getCurrentGame(WebElement game) {
        webDriverWait.until(visibilityOfElementLocated(currentGame));
        return game.findElement(currentGame);
    }

    public String getGameReleaseDate(WebElement game) {
        webDriverWait.until(visibilityOfElementLocated(gameReleaseDate));
        return game.findElement(gameReleaseDate).getText();
    }

    public String getGamePrice(WebElement game) {
        webDriverWait.until(visibilityOfElementLocated(gamePrice));
        return game.findElement(gamePrice).getText();
    }
}
