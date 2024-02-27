package sixthlesson.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Страница с фильтром игр в Steam
 */
public class FilterPage {
    private final String sortingParameters = "//a[@id='sort_by_trigger']";
    private final String releasingDateParameter = "//a[text() = 'дате выхода']";
    private final String releasingDateParameterChecking = "//div[@id = 'sort_by_dselect_container']/a[text() = 'дате выхода']";
    private final String removeFreeGamesCheckbox = "//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']";
    private final String removeFreeGamesCheckboxActiveStatus = "//div[contains(@class, 'checked') and @data-loc = 'Скрыть бесплатные игры']";
    private final String priceIncreaseParameter = "//a[@id = 'Price_ASC']";
    private final String priceIncreaseParameterChecking = "//div[@id = 'sort_by_dselect_container']/a[text() = 'возрастанию цены']";
    private final String specialOffersCheckbox = "//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']";
    private final String specialOffersCheckboxActiveStatus = "//div[contains(@class, 'checked') and @data-loc = 'Специальные предложения']";
    private final String windowsOperatingSystemCheckbox = "//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']";
    private final String windowsOperatingSystemCheckboxActiveStatus = "//div[contains(@class, 'checked') and @data-loc = 'Windows']";
    private final String allGamesFromList = "//div[@id = 'search_resultsRows']/a";
    private final String currentGame = ".//span[@class = 'title']";
    private final String gameReleaseDate = ".//div[contains(@class, 'search_released')]";
    private final String gamePrice = ".//div[@class = 'discount_final_price']";
    private final int secondsOfWaiting = 10;

    private void sortingParametersClickByJs() {
        $x(sortingParameters).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(sortingParameters));
    }

    public void releasingDateParameterClickByJs() {
        sortingParametersClickByJs();
        $x(releasingDateParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(releasingDateParameter));
    }

    public boolean releasingDateParameterSortingChecking() {
        return $x(releasingDateParameterChecking).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void priceIncreaseParameterClickByJs() {
        sortingParametersClickByJs();
        $x(priceIncreaseParameter).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(priceIncreaseParameter));
    }

    public boolean priceIncreaseParameterSortingChecking() {
        return $x(priceIncreaseParameterChecking).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void removeFreeGamesCheckboxClickByJs() {
        $x(removeFreeGamesCheckbox).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(removeFreeGamesCheckbox));
    }

    public boolean removeFreeGamesCheckboxActiveStatusChecking() {
        return $x(removeFreeGamesCheckboxActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void specialOffersCheckboxClickByJs() {
        $x(specialOffersCheckbox).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(specialOffersCheckbox));
    }

    public boolean specialOffersCheckboxActiveStatusChecking() {
        return $x(specialOffersCheckboxActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    public void windowsOperatingSystemParameterClickByJs() {
        $x(windowsOperatingSystemCheckbox).should(visible, Duration.ofSeconds(secondsOfWaiting));
        executeJavaScript("arguments[0].click()", $x(windowsOperatingSystemCheckbox));
    }

    public boolean windowsOperatingSystemParameterActiveStatusChecking() {
        return $x(windowsOperatingSystemCheckboxActiveStatus).should(visible, Duration.ofSeconds(secondsOfWaiting))
                .isDisplayed();
    }

    private ElementsCollection getAllGamesWithFilterParameters() {
        return $$x(allGamesFromList).should(CollectionCondition.sizeGreaterThan(0));

    }

    public Map<String, WebElement> searchingForRequiredGameInList(String observedGameSeries) {
        ElementsCollection allGamesFromList = getAllGamesWithFilterParameters();
        WebElement foundGame = null;
        WebElement currentGameTitle = null;
        FilterPage filterPage = new FilterPage();

        for (WebElement game : allGamesFromList) {
            currentGameTitle = filterPage.getCurrentGameTitle(game);
            if (currentGameTitle.getText().startsWith(observedGameSeries)) {
                foundGame = game;
                break;
            }
        }

        Map<String, WebElement> foundGameInformation = new HashMap<>();
        foundGameInformation.put("gameElement", foundGame);
        foundGameInformation.put("gameTitle", currentGameTitle);
        return foundGameInformation;
    }

    private WebElement getCurrentGameTitle(WebElement game) {
        $x(currentGame).should(visible, Duration.ofSeconds(secondsOfWaiting));
        return game.findElement(By.xpath(currentGame));
    }

    public String getGameReleaseDate(WebElement game) {
        $x(gameReleaseDate).should(visible, Duration.ofSeconds(secondsOfWaiting));
        return game.findElement(By.xpath(gameReleaseDate)).getText();
    }

    public String getGamePrice(WebElement game) {
        $x(gamePrice).should(visible, Duration.ofSeconds(secondsOfWaiting));
        return game.findElement(By.xpath(gamePrice)).getText();
    }
}
