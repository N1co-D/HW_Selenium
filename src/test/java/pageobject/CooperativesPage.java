package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница "Кооперативы" на сайте Steam
 */
public class CooperativesPage {
    private By witTheHighestRatingParameterButton = new By.ByXPath("//div[text() = 'С наивысшим рейтингом']");
    private By witTheHighestRatingParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'С наивысшим рейтингом']");
    private By casualGameParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Казуальная игра']");
    private By casualGameParameterTag = new By.ByXPath("//span[text() = 'Казуальная игра']");
    private By playersParameter = new By.ByXPath("//div[contains(@class, '_3L67OJmzdGjQ4fcAzZ2JvY') and text() = 'Игроки']");
    private By cooperativeParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Кооператив']");
    private By cooperativeParameterTag = new By.ByXPath("//span[text() = 'Кооператив']");
    private By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]");
    private By fieldWithSearchResults = new By.ByXPath("//div[contains(text(), 'Совпадений:')]");
    private By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private Actions actions = new Actions(DRIVER.getDriver());
    private WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public void filterSectionScrolling() {
        webDriverWait.until(visibilityOfElementLocated(filterSection));
        actions.scrollToElement(DRIVER.getDriver().findElement(filterSection)).perform();
    }

    public void witTheHighestRatingParameterButtonClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(witTheHighestRatingParameterButton));
    }

    public boolean witTheHighestRatingParameterButtonActiveStatusChecking() {
        webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButtonActiveStatus));
        return DRIVER.getDriver().findElement(witTheHighestRatingParameterButtonActiveStatus).isDisplayed();
    }

    public void casualGameParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(casualGameParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(casualGameParameter));
    }

    public boolean casualGameParameterTagChecking() {
        webDriverWait.until(visibilityOfElementLocated(casualGameParameterTag));
        return DRIVER.getDriver().findElement(casualGameParameterTag).isDisplayed();
    }

    public void playersParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(playersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(playersParameter));
    }

    public void cooperativeParameterClickByJs() {
        webDriverWait.until(visibilityOfElementLocated(cooperativeParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(cooperativeParameter));
    }

    public boolean cooperativeParameterTagChecking() {
        webDriverWait.until(visibilityOfElementLocated(cooperativeParameterTag));
        return DRIVER.getDriver().findElement(cooperativeParameterTag).isDisplayed();
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
