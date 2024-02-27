package sixthlesson.pageobject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Страница "Тайны и детективы" в Steam
 */
public class MysteriesAndDetectivesPage {
    private final String filterSection = "//div[@id = 'SaleSection_13268']";
    private final String salesLeadersParameterButton = "//div[text() = 'Лидеры продаж']";
    private final String salesLeadersParameterButtonActiveStatus = "//div[contains(@class, '3HhxiFyD3z9B') and text() = 'Лидеры продаж']";
    private final String showMoreButton = "//div[text() = 'Показать больше']";
    private final String strategyParameter = "//div[contains(@class, 'Qu-ZCE2EM66oWdyl74Lzy')]//a[text() = 'Стратегия']";
    private final String strategyParameterTag = "//span[text() = 'Стратегия']";
    private final String playersParameter = "//div[text() = 'Игроки']";
    private final String forMultiplePlayersParameter = "//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Для нескольких игроков']";
    private final String firstGameWithFilterParameters = "//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]";
    private final String gameTitle = "//div[@id = 'appHubAppName']";
    private final int secondsOfWaiting = 10;

    private void filterSectionScrolling() {
        $x(filterSection).should(visible, Duration.ofSeconds(secondsOfWaiting)).scrollTo();
    }

    public void salesLeadersParameterButtonClickByJs() {
        filterSectionScrolling();
        $x(salesLeadersParameterButton).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click();", $x(salesLeadersParameterButton));
    }

    public boolean salesLeadersParameterButtonActiveStatusChecking() {
        return $x(salesLeadersParameterButtonActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public MysteriesAndDetectivesPage showMoreButtonClickByJs() {
        $x(showMoreButton).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(showMoreButton));
        return this;
    }

    public void strategyParameterClickByJs() {
        $x(strategyParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(strategyParameter));
    }

    public boolean strategyParameterTagChecking() {
        return $x(strategyParameterTag).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public MysteriesAndDetectivesPage playersParameterClickByJs() {
        $x(playersParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(playersParameter));
        return this;
    }

    public void forMultiplePlayersParameterClickByJs() {
        $x(forMultiplePlayersParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(forMultiplePlayersParameter));
    }

    public boolean forMultiplePlayersParameterTagChecking() {
        return $x(forMultiplePlayersParameter).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void firstGameWithFilterParametersClickByJs() {
        $x(firstGameWithFilterParameters).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(firstGameWithFilterParameters));
    }

    public String gameTitleGetText() {
        return $x(gameTitle).should(visible, Duration.ofSeconds(secondsOfWaiting)).getText();
    }
}