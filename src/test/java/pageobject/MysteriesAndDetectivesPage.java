package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница "Тайны и детективы" в Steam
 */
public class MysteriesAndDetectivesPage {
    private By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private By salesLeadersParameterButton = new By.ByXPath("//div[text() = 'Лидеры продаж']");
    private By salesLeadersParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, 'SelectedFlavor') and text() = 'Лидеры продаж']");
    private By showMoreButton = new By.ByXPath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']");
    private By fieldWithSearchResults = new By.ByXPath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]");
    private By strategyParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Стратегия']");
    private By playersParameter = new By.ByXPath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']");
    private By forMultiplePlayersParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']");
    private By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a");
    private By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private Actions actions = new Actions(DRIVER.getDriver());
    private WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));

    public void filterSectionScrolling() {
        webDriverWait.until(visibilityOfElementLocated(filterSection));
        actions.scrollToElement(DRIVER.getDriver().findElement(filterSection)).perform();
    }

    public void salesLeadersParameterButtonClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(salesLeadersParameterButton));
    }

    public boolean salesLeadersParameterButtonActiveStatusChecking() {
        webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButtonActiveStatus));
        return DRIVER.getDriver().findElement(salesLeadersParameterButtonActiveStatus).isDisplayed();
    }

    public void showMoreButtonClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(showMoreButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(showMoreButton));
    }

    public void strategyParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(strategyParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(strategyParameter));
    }

    public boolean strategyParameterTagChecking() {
        webDriverWait.until(visibilityOfElementLocated(strategyParameter));
        return DRIVER.getDriver().findElement(strategyParameter).isDisplayed();
    }

    public void playersParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(playersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(playersParameter));
    }

    public void forMultiplePlayersParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(forMultiplePlayersParameter));
    }

    public boolean forMultiplePlayersParameterTagChecking() {
        webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
        return DRIVER.getDriver().findElement(forMultiplePlayersParameter).isDisplayed();
    }

    public String fieldWithSearchResultsGetText() {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return DRIVER.getDriver().findElement(fieldWithSearchResults).getText();
    }

    public By fieldWithSearchResultsPath() {
        webDriverWait.until(visibilityOfElementLocated(fieldWithSearchResults));
        return fieldWithSearchResults;
    }

    public void firstGameWithFilterParametersClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(firstGameWithFilterParameters));
    }

    public String gameTitleGetText() {
        webDriverWait.until(visibilityOfElementLocated(gameTitle));
        return DRIVER.getDriver().findElement(gameTitle).getText();
    }
}
