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
 * Страница "Тайны и детективы" в Steam
 */
public class MysteriesAndDetectivesPage {
    private final By filterSection = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private final By salesLeadersParameterButton = new By.ByXPath("//div[text() = 'Лидеры продаж']");
    private final By salesLeadersParameterButtonActiveStatus = new By.ByXPath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'Лидеры продаж']");
    private final By showMoreButton = new By.ByXPath("//div[text() = 'Показать больше']");
    private final By strategyParameter = new By.ByXPath("//div[contains(@class, 'Qu-ZCE2EM66oWdyl74Lzy')]//a[text() = 'Стратегия']");
    private final By strategyParameterTag = new By.ByXPath("//span[text() = 'Стратегия']");
    private final By playersParameter = new By.ByXPath("//div[text() = 'Игроки']");
    private final By forMultiplePlayersParameter = new By.ByXPath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Для нескольких игроков']");
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

    public void salesLeadersParameterButtonClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButton));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(salesLeadersParameterButton));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'Лидеры продаж' не был найден");
        }
    }

    public boolean salesLeadersParameterButtonActiveStatusChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(salesLeadersParameterButtonActiveStatus));
            return DRIVER.getDriver().findElement(salesLeadersParameterButtonActiveStatus)
                    .isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел фильтра 'Лидеры продаж' не был найден");
        }
        return false;
    }

    public void showMoreButtonClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(showMoreButton));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(showMoreButton));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Показать больше' не была найдена");
        }
    }

    public void strategyParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(strategyParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(strategyParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Стратегия' не был найден");
        }
    }

    public boolean strategyParameterTagChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(strategyParameterTag));
            return DRIVER.getDriver().findElement(strategyParameterTag).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Стратегия' не был найден");
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

    public void forMultiplePlayersParameterClickByJs() {
        try {
            webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
            jsExecutor.executeScript("arguments[0].click()", DRIVER.getDriver()
                    .findElement(forMultiplePlayersParameter));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Параметр фильтра 'Для нескольких игроков' не был найден");
        }
    }

    public boolean forMultiplePlayersParameterTagChecking() {
        try {
            webDriverWait.until(visibilityOfElementLocated(forMultiplePlayersParameter));
            return DRIVER.getDriver().findElement(forMultiplePlayersParameter).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Тэг параметра 'Для нескольких игроков' не был найден");
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
