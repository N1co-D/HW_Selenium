package sixthlesson.pageobject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

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
    private final int secondsOfWaiting = 10;

    public void filterSectionScrolling() {
        $x(filterSection).should(visible, Duration.ofSeconds(secondsOfWaiting)).scrollTo();
    }

    public void withTheHighestRatingParameterButtonClickByJs() {
        $x(withTheHighestRatingParameterButton).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(withTheHighestRatingParameterButton));
    }

    public boolean withTheHighestRatingParameterButtonActiveStatusChecking() {
        return $x(withTheHighestRatingParameterButtonActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void casualGameParameterClickByJs() {
        $x(casualGameParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(casualGameParameter));
    }

    public boolean casualGameParameterTagChecking() {
        return $x(casualGameParameterTag).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void playersParameterClickByJs() {
        $x(playersParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(playersParameter));
    }

    public void cooperativeParameterClickByJs() {
        $x(cooperativeParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(cooperativeParameter));
    }

    public boolean cooperativeParameterTagChecking() {
        return $x(cooperativeParameterTag).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void firstGameWithFilterParametersClickByJs() {
        $x(firstGameWithFilterParameters).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(firstGameWithFilterParameters));
    }

    public String gameTitleGetText() {
        return $x(gameTitle).should(visible, Duration.ofSeconds(secondsOfWaiting)).getText();
    }
}
