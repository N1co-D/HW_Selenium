package fifthlesson.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static fifthlesson.utils.DriverSingleton.MANAGER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Страница "Кооперативы" на сайте Steam
 */
public class CooperativesPage {
    private final String withTheHighestRatingParameterButton = "//div[text() = 'С наивысшим рейтингом']";
    private final String withTheHighestRatingParameterButtonActiveStatus = "//div[contains(@class, '3HhxiFyD3z9B') and text() = 'С наивысшим рейтингом']";
    private final String casualGameParameter = "//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Казуальная игра']";
    private final String casualGameParameterTag = "//span[text() = 'Казуальная игра']";
    private final String playersParameter = "//div[contains(@class, '_3L67OJmzdGjQ4fcAzZ2JvY') and text() = 'Игроки']";
    private final String cooperativeParameter = "//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Кооператив']";
    private final String cooperativeParameterTag = "//span[text() = 'Кооператив']";
    private final String filterSection = "//div[@id = 'SaleSection_13268']";
    private final String firstGameWithFilterParameters = "//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]";
    private final String gameTitle = "//div[@id = 'appHubAppName']";
    //    private final Actions actions = new Actions(MANAGER.getDriver());
//    private final Actions actions = new Actions(Selenide.webdriver().driver().getWebDriver());
//    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) MANAGER.getDriver();
//    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
    private final int secondsOfWaiting = 10;

//    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    public void filterSectionScrolling() {
        $x(filterSection).should(visible, Duration.ofSeconds(secondsOfWaiting)).scrollTo();
//        actions.scrollToElement(filterSectionElement).perform();
    }

    public void withTheHighestRatingParameterButtonClickByJs() {
        $x(withTheHighestRatingParameterButton).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(withTheHighestRatingParameterButton));
//        $x(withTheHighestRatingParameterButton).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
//        jsExecutor.executeScript("arguments[0].click()", withTheHighestRatingParameterButtonElement);
    }

//    public void withTheHighestRatingParameterButtonClickByJs() {
//        SelenideElement withTheHighestRatingParameterButtonElement = Selenide.$x(withTheHighestRatingParameterButton).should(Condition.visible, Duration.ofSeconds(secondsOfWaiting));
//        jsExecutor.executeScript("arguments[0].click()", withTheHighestRatingParameterButtonElement);
//    }

    public boolean withTheHighestRatingParameterButtonActiveStatusChecking() {
        return $x(withTheHighestRatingParameterButtonActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting)).isDisplayed();
    }

//    public void casualGameParameterClickByJs() {
//        SelenideElement casualGameParameterElement = Selenide.$x(casualGameParameter).should(Condition.visible, Duration.ofSeconds(secondsOfWaiting));
//        jsExecutor.executeScript("arguments[0].click()", casualGameParameterElement);
//    }

    public void casualGameParameterClickByJs() {
        $x(casualGameParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(casualGameParameter));
//        jsExecutor.executeScript("arguments[0].click()", casualGameParameterElement);
    }

    public boolean casualGameParameterTagChecking() {
        return $x(casualGameParameterTag).should(visible, Duration.ofSeconds(secondsOfWaiting)).isDisplayed();
    }

//    public void playersParameterClickByJs() {
//        SelenideElement playersParameterElement = Selenide.$x(playersParameter).should(Condition.visible, Duration.ofSeconds(secondsOfWaiting));
//        jsExecutor.executeScript("arguments[0].click()", playersParameterElement);
//    }

    public void playersParameterClickByJs() {
        $x(playersParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(playersParameter));
//        jsExecutor.executeScript("arguments[0].click()", playersParameterElement);
    }

//    public void cooperativeParameterClickByJs() {
//        SelenideElement cooperativeParameterElement = Selenide.$x(cooperativeParameter).should(Condition.visible, Duration.ofSeconds(secondsOfWaiting));
//        jsExecutor.executeScript("arguments[0].click()", cooperativeParameterElement);
//    }

    public void cooperativeParameterClickByJs() {
        $x(cooperativeParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(cooperativeParameter));
//        jsExecutor.executeScript("arguments[0].click()", cooperativeParameterElement);
    }

    public boolean cooperativeParameterTagChecking() {
        return $x(cooperativeParameterTag).should(visible, Duration.ofSeconds(secondsOfWaiting)).isDisplayed();
    }

//    public void firstGameWithFilterParametersClickByJs() {
//        SelenideElement firstGameWithFilterParametersElement = Selenide.$x(firstGameWithFilterParameters).should(Condition.visible, Duration.ofSeconds(secondsOfWaiting));
//        jsExecutor.executeScript("arguments[0].click()", firstGameWithFilterParametersElement);
//    }

    public void firstGameWithFilterParametersClickByJs() {
        $x(firstGameWithFilterParameters).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(firstGameWithFilterParameters));
//        jsExecutor.executeScript("arguments[0].click()", firstGameWithFilterParametersElement);
    }

    public String gameTitleGetText() {
        return $x(gameTitle).should(visible, Duration.ofSeconds(secondsOfWaiting)).getText();
    }
}
