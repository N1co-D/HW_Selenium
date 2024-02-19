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
    private By salesLeadersParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'Лидеры продаж']");
    private By showMoreButton = new By.ByXPath("//div[text() = 'Показать больше']");
    private By fieldWithSearchResults = new By.ByXPath("//div[contains(text(), 'Совпадений:')]");
    private By strategyParameter = new By.ByXPath("//div[contains(@class, 'Qu-ZCE2EM66oWdyl74Lzy')]//a[text() = 'Стратегия']");
    private By strategyParameterTag = new By.ByXPath("//span[text() = 'Стратегия']");
    private By playersParameter = new By.ByXPath("//div[text() = 'Игроки']");
    private By forMultiplePlayersParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Для нескольких игроков']");
    private By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]");
    private By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private Actions actions = new Actions(DRIVER.getDriver());
    private WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

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
        webDriverWait.until(visibilityOfElementLocated(strategyParameterTag));
        return DRIVER.getDriver().findElement(strategyParameterTag).isDisplayed();
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
