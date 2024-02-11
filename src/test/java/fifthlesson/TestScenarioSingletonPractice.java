package fifthlesson;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobject.CooperativesPage;
import pageobject.FilterPage;
import pageobject.MainPage;
import pageobject.MysteriesAndDetectivesPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static utils.DriverSingleton.DRIVER;

public class TestScenarioSingletonPractice {
    private WebDriverWait webDriverWait;

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.categoriesButtonTopMenuDesktopClick();
        mainPage.cooperativesCategoryButtonClick();

        CooperativesPage cooperativesPage = new CooperativesPage();
        cooperativesPage.filterSectionScrolling();

        cooperativesPage.witTheHighestRatingParameterButtonClickByJs();
        Assert.assertTrue(cooperativesPage.witTheHighestRatingParameterButtonActiveStatusChecking(), "Раздел \"С наивысшим рейтингом\" не выбран");

        cooperativesPage.casualGameParameterClickByJs();
        Assert.assertTrue(cooperativesPage.casualGameParameterTagChecking(), "Тэг \"Казуальная игра\" не отображается");

        cooperativesPage.playersParameterClickByJs();

        String resultsText = cooperativesPage.fieldWithSearchResultsGetText();

        cooperativesPage.cooperativeParameterClickByJs();
        Assert.assertTrue(cooperativesPage.cooperativeParameterTagChecking(), "Тэг \"Кооператив игра\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(cooperativesPage.fieldWithSearchResultsPath(), resultsText))));

        String resultsTextForComparing = cooperativesPage.fieldWithSearchResultsGetText();

        if (!resultsText.equals(resultsTextForComparing)) {
            cooperativesPage.firstGameWithFilterParametersClickByJs();
            List<String> allWindowHandles = new ArrayList<>(DRIVER.getDriver().getWindowHandles());
            String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
            DRIVER.getDriver().switchTo().window(windowToSwitch);
        }

        Assert.assertEquals(cooperativesPage.gameTitleGetText(), "Garry's Mod", "Указан заголовок некорректной игры");
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.categoriesButtonTopMenuDesktopClick();
        mainPage.mysteriesAndDetectivesCategoryButtonClick();

        MysteriesAndDetectivesPage mysteriesAndDetectivesPage = new MysteriesAndDetectivesPage();
        mysteriesAndDetectivesPage.filterSectionScrolling();

        mysteriesAndDetectivesPage.salesLeadersParameterButtonClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage.salesLeadersParameterButtonActiveStatusChecking(), "Раздел \"Лидеры продаж\" не выбран");

        mysteriesAndDetectivesPage.showMoreButtonClickByJs();

        mysteriesAndDetectivesPage.strategyParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage.strategyParameterTagChecking(), "Тэг \"Стратегия\" не отображается");

        mysteriesAndDetectivesPage.playersParameterClickByJs();

        String resultsText = mysteriesAndDetectivesPage.fieldWithSearchResultsGetText();

        mysteriesAndDetectivesPage.forMultiplePlayersParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage.forMultiplePlayersParameterTagChecking(), "Тэг \"Для нескольких игроков\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(mysteriesAndDetectivesPage.fieldWithSearchResultsPath(), resultsText))));

        String resultsTextForComparing = mysteriesAndDetectivesPage.fieldWithSearchResultsGetText();

        if (!resultsText.equals(resultsTextForComparing)) {
            mysteriesAndDetectivesPage.firstGameWithFilterParametersClickByJs();
            List<String> allWindowHandles = new ArrayList<>(DRIVER.getDriver().getWindowHandles());
            String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
            DRIVER.getDriver().switchTo().window(windowToSwitch);
        }

        Assert.assertEquals(mysteriesAndDetectivesPage.gameTitleGetText(), "West Hunt", "Указан заголовок некорректной игры");
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText("Oxygen Not Included");
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(DRIVER.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.releasingDateParameterClickByJs();
        Assert.assertTrue(filterPage.releasingDateParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.fieldWithSearchResultsClickByJs();
        String resultsText = filterPage.fieldWithSearchResultsGetText();

        filterPage.removeFreeGamesCheckboxClickByJs();
        Assert.assertTrue(filterPage.removeFreeGamesCheckboxActiveStatusChecking(), "Checkbox \"Скрыть бесплатные игры\" не активирован");

        webDriverWait.until(refreshed(not(textToBe(filterPage.fieldWithSearchResultsPath(), resultsText))));
        String resultsTextForComparing = filterPage.fieldWithSearchResultsGetText();

        if (!resultsText.equals(resultsTextForComparing)) {
            List<WebElement> allGames = filterPage.getAllGamesWithFilterParameters();
            for (WebElement game : allGames) {
                if (filterPage.getCurrentGameText().startsWith("Oxygen Not Included")) {
                    Assert.assertEquals(filterPage.getCurrentGameText(), "Oxygen Not Included - Spaced Out!", "Указан заголовок некорректной игры");
                    Assert.assertEquals(filterPage.getGameReleaseDate(), "16 дек. 2021", "Указана некорректная дата релиза игры");
                    Assert.assertEquals(filterPage.getGamePrice(), "299 руб", "Указана некорректная цена игры");
                    break;
                }
            }
        }
    }

    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText("HITMAN");
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(DRIVER.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.priceIncreaseParameterClickByJs();
        Assert.assertTrue(filterPage.priceIncreaseParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.fieldWithSearchResultsClickByJs();
        String resultsText = filterPage.fieldWithSearchResultsGetText();

        filterPage.specialOffersCheckboxClickByJs();
        Assert.assertTrue(filterPage.specialOffersCheckboxActiveStatusChecking(), "Checkbox \"Специальные предложения\" не активирован");

        webDriverWait.until(refreshed(not(textToBe(filterPage.fieldWithSearchResultsPath(), resultsText))));
        String resultsTextForComparing = filterPage.fieldWithSearchResultsGetText();

        filterPage.windowsOperatingSystemParameterClickByJs();
        Assert.assertTrue(filterPage.windowsOperatingSystemParameterActiveStatusChecking(), "Checkbox \"Windows\" не активирован");

        if (!resultsText.equals(resultsTextForComparing)) {
            List<WebElement> allGames = filterPage.getAllGamesWithFilterParameters();
            for (WebElement game : allGames) {
                if (filterPage.getCurrentGameText().startsWith("HITMAN")) {
                    Assert.assertEquals(filterPage.getCurrentGameText(), "HITMAN 3", "Указан заголовок некорректной игры");
                    Assert.assertTrue(filterPage.getGameReleaseDate().contains("20 янв. 2022"), "Указана некорректная дата релиза игры");
                    Assert.assertEquals(filterPage.getGamePrice(), "440 руб", "Указана некорректная цена игры");
                    break;
                }
            }
        }
    }

    @AfterTest
    public void afterTests() {
        DRIVER.getDriver().quit();
    }
}