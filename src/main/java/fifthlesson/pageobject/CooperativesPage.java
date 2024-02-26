package fifthlesson.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static fifthlesson.utils.DriverSingleton.MANAGER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Страница "Кооперативы" на сайте Steam
 */
public class CooperativesPage {
    private final By withTheHighestRatingParameterButton = new By.ByXPath("//div[text() = 'С наивысшим рейтингом']");
    private final By withTheHighestRatingParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'С наивысшим рейтингом']");
    private final By casualGameParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Казуальная игра']");
    private final By casualGameParameterTag = new By.ByXPath("//span[text() = 'Казуальная игра']");
    private final By playersParameter = new By.ByXPath("//div[contains(@class, '_3L67OJmzdGjQ4fcAzZ2JvY') and text() = 'Игроки']");
    private final By cooperativeParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Кооператив']");
    private final By cooperativeParameterTag = new By.ByXPath("//span[text() = 'Кооператив']");
    private final By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private final By firstGameWithFilterParameters = new By.ByXPath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]");
    private final By gameTitle = new By.ByXPath("//div[@id = 'appHubAppName']");
    private final Actions actions = new Actions(MANAGER.getDriver());
    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) MANAGER.getDriver();
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    public void filterSectionScrolling() {
        try {
            webDriverWait.until(visibilityOfElementLocated(filterSection));
            actions.scrollToElement(MANAGER.getDriver().findElement(filterSection)).perform();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел с фильтром не найден");
            throw noSuchElementException;
        }
    }

    public void withTheHighestRatingParameterButtonClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(withTheHighestRatingParameterButton));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(withTheHighestRatingParameterButton));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'С наивысшим рейтингом' не найден");
            throw noSuchElementException;
        }
    }

    public boolean withTheHighestRatingParameterButtonActiveStatusChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(withTheHighestRatingParameterButtonActiveStatus))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'С наивысшим рейтингом' не найден");
            throw noSuchElementException;
        }
    }

    public void casualGameParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(casualGameParameter));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(casualGameParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Казуальная игра' не найден");
            throw noSuchElementException;
        }
    }

    public boolean casualGameParameterTagChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(casualGameParameterTag))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Казуальная игра' не найден");
            throw noSuchElementException;
        }
    }

    public void playersParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(playersParameter));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(playersParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Игроки' не найден");
            throw noSuchElementException;
        }
    }

    public void cooperativeParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(cooperativeParameter));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(cooperativeParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Кооператив' не найден");
            throw noSuchElementException;
        }
    }

    public boolean cooperativeParameterTagChecking() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(cooperativeParameterTag))
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Кооператив' не найден");
            throw noSuchElementException;
        }
    }

    public void firstGameWithFilterParametersClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters));
            jsExecutor.executeScript("arguments[0].click()", MANAGER.getDriver()
                    .findElement(firstGameWithFilterParameters));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Игра не найдена");
            throw noSuchElementException;
        }
    }

    public String gameTitleGetText() {
        try {
            return webDriverWait.until(visibilityOfElementLocated(gameTitle)).getText();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Заголовок игры не найден");
            throw noSuchElementException;
        }
    }
}
