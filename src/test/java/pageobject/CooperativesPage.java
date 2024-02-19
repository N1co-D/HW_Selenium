package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

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
    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) DRIVER.getDriver();
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public void filterSectionScrolling() {
        try {
            webDriverWait.until(visibilityOfElementLocated(filterSection));
            actions.scrollToElement(DRIVER.getDriver().findElement(filterSection)).perform();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел с фильтром не был найден");
        }
    }

    public void witTheHighestRatingParameterButtonClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButton));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(witTheHighestRatingParameterButton));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'С наивысшим рейтингом' не был найден");
        }
    }

    public boolean witTheHighestRatingParameterButtonActiveStatusChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(witTheHighestRatingParameterButtonActiveStatus));
            return DRIVER.getDriver().findElement(witTheHighestRatingParameterButtonActiveStatus)
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'С наивысшим рейтингом' не был найден");
        }
        return false;
    }

    public void casualGameParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(casualGameParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(casualGameParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Казуальная игра' не был найден");
        }
    }

    public boolean casualGameParameterTagChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(casualGameParameterTag));
            return DRIVER.getDriver().findElement(casualGameParameterTag).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Казуальная игра' не был найден");
        }
        return false;
    }

    public void playersParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(playersParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(playersParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Игроки' не был найден");
        }
    }

    public void cooperativeParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(cooperativeParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(cooperativeParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Кооператив' не был найден");
        }
    }

    public boolean cooperativeParameterTagChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(cooperativeParameterTag));
            return DRIVER.getDriver().findElement(cooperativeParameterTag).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Кооператив' не был найден");
        }
        return false;
    }

    public void firstGameWithFilterParametersClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(firstGameWithFilterParameters));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игра не была найдена");
        }
    }

    public String gameTitleGetText() {
        try {
            webDriverWait.until(visibilityOfElementLocated(gameTitle));
            return DRIVER.getDriver().findElement(gameTitle).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Заголовок игры не был найден");
        }
        return "Заголовок игры не был найден";
    }
}
