package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.DriverSingleton.DRIVER;

/**
 * Страница "Кооперативы" на сайте Steam
 */
public class CooperativesPage {
    private By witTheHighestRatingParameterButton = new By.ByXPath("//div[text() = 'С наивысшим рейтингом']");
    private By witTheHighestRatingParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, 'SelectedFlavor') and text() = 'С наивысшим рейтингом']");
    private By casualGameParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Казуальная игра']");
    private By casualGameParameterTag = new By.ByXPath("//div[contains(@class, 'SelectedFacetValuesList')]//span[text() = 'Казуальная игра']");
    private By playersParameter = new By.ByXPath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']");
    private By cooperativeParameter = new By.ByXPath("//a[contains(@class, 'FacetValueName') and text() = 'Кооператив']");
    private By cooperativeParameterTag = new By.ByXPath("//div[contains(@class, 'SelectedFacetValuesList')]//span[text() = 'Кооператив']");
    private By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a");
    private By fieldWithSearchResults = new By.ByXPath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]");
    private By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private Actions actions = new Actions(DRIVER.getDriver());

    public void filterSectionScrolling(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(filterSection));
        actions.scrollToElement(DRIVER.getDriver().findElement(filterSection)).perform();
    }

    public void witTheHighestRatingParameterButtonClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(witTheHighestRatingParameterButton));
    }

    public boolean witTheHighestRatingParameterButtonActiveStatusChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButtonActiveStatus));
        return DRIVER.getDriver().findElement(witTheHighestRatingParameterButtonActiveStatus).isDisplayed();
    }

    public void casualGameParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(casualGameParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(casualGameParameter));
    }

    public boolean casualGameParameterTagChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(casualGameParameterTag));
        return DRIVER.getDriver().findElement(casualGameParameterTag).isDisplayed();
    }

    public void playersParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(playersParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(playersParameter));
    }

    public void cooperativeParameterClickByJs(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(cooperativeParameter));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
        jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver().findElement(cooperativeParameter));
    }

    public boolean cooperativeParameterTagChecking(WebDriverWait webDriverWait) {
        webDriverWait.until(visibilityOfElementLocated(cooperativeParameterTag));
        return DRIVER.getDriver().findElement(cooperativeParameterTag).isDisplayed();
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
