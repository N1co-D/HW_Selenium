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
    private final By witTheHighestRatingParameterButton = new By.ByXPath("//div[text() = 'С наивысшим рейтингом']");
    private final By witTheHighestRatingParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'С наивысшим рейтингом']");
    private final By casualGameParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Казуальная игра']");
    private final By casualGameParameterTag = new By.ByXPath("//span[text() = 'Казуальная игра']");
    private final By playersParameter = new By.ByXPath("//div[contains(@class, '_3L67OJmzdGjQ4fcAzZ2JvY') and text() = 'Игроки']");
    private final By cooperativeParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Кооператив']");
    private final By cooperativeParameterTag = new By.ByXPath("//span[text() = 'Кооператив']");
    private final By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private final By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]");
    private final By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private final Actions actions = new Actions(DRIVER.getDriver());
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

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
