package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSingleton;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница "Тайны и детективы" в Steam
 */
public class MysteriesAndDetectivesPage {
    private static By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private static By salesLeadersParameterButton = new By.ByXPath("//div[text() = 'Лидеры продаж']");
    private static By salesLeadersParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, 'SelectedFlavor') and text() = 'Лидеры продаж']");
    private static By showMoreButton = new By.ByXPath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']");
    private static By fieldWithSearchResults = new By.ByXPath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]");
    private static By strategyParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Стратегия']");
    private static By playersParameter = new By.ByXPath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']");
    private static By forMultiplePlayersParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']");
    private static By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a");
    private static By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private Actions actions = new Actions(DRIVER.getDriver());

    public void filterSectionScrolling(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(filterSection));
        actions.scrollToElement(DRIVER.getDriver().findElement(filterSection)).perform();
    }

    public void salesLeadersParameterButtonClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(salesLeadersParameterButton));
    }

    public boolean salesLeadersParameterButtonActiveStatusChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButtonActiveStatus));
        return DRIVER.getDriver().findElement(salesLeadersParameterButtonActiveStatus).isDisplayed();
    }

    public void showMoreButtonClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(showMoreButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(showMoreButton));
    }

    public void strategyParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(strategyParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(strategyParameter));
    }

    public boolean strategyParameterTagChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(strategyParameter));
        return DRIVER.getDriver().findElement(strategyParameter).isDisplayed();
    }

    public void playersParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(playersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(playersParameter));
    }

    public void forMultiplePlayersParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(forMultiplePlayersParameter));
    }

    public boolean forMultiplePlayersParameterTagChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
        return DRIVER.getDriver().findElement(forMultiplePlayersParameter).isDisplayed();
    }

    public String fieldWithSearchResultsGetText(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return DRIVER.getDriver().findElement(fieldWithSearchResults).getText();
    }

    public By fieldWithSearchResultsPath(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return fieldWithSearchResults;
    }

    public void firstGameWithFilterParametersClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(firstGameWithFilterParameters));
    }

    public String gameTitleGetText(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(gameTitle));
        return DRIVER.getDriver().findElement(gameTitle).getText();
    }
}
