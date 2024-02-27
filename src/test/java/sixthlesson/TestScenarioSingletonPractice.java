package sixthlesson;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sixthlesson.pageobject.CooperativesPage;
import sixthlesson.pageobject.FilterPage;
import sixthlesson.pageobject.MainPage;
import sixthlesson.pageobject.MysteriesAndDetectivesPage;
import sixthlesson.utils.ConfigPropertiesProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestScenarioSingletonPractice {
    @BeforeTest
    public void setUpDriverOptions() {
        ConfigPropertiesProcessing configPropertiesProcessing = new ConfigPropertiesProcessing();
        System.out.println("Определен браузер: " + configPropertiesProcessing.getBrowserFromProperty());
        System.out.println("Размер окна: " + configPropertiesProcessing.getSizeOfBrowserFromProperty());
        Configuration.browser = configPropertiesProcessing.getBrowserFromProperty();
        Configuration.browserSize = configPropertiesProcessing.getSizeOfBrowserFromProperty();
    }

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();

        mainPage.categoriesButtonTopMenuDesktopClick().cooperativesCategoryButtonClick();
        Assert.assertEquals(url(), "https://store.steampowered.com/category/multiplayer_coop/", "Открыта неверная страница");

        CooperativesPage cooperativesPage = new CooperativesPage();

        cooperativesPage.withTheHighestRatingParameterButtonClickByJs();
        Assert.assertTrue(cooperativesPage
                .withTheHighestRatingParameterButtonActiveStatusChecking(), "Раздел \"С наивысшим рейтингом\" не выбран");

        cooperativesPage.casualGameParameterClickByJs();
        Assert.assertTrue(cooperativesPage
                .casualGameParameterTagChecking(), "Тэг \"Казуальная игра\" не отображается");

        cooperativesPage.playersParameterClickByJs().cooperativeParameterClickByJs();
        Assert.assertTrue(cooperativesPage
                .cooperativeParameterTagChecking(), "Тэг \"Кооператив игра\" не отображается");

        addWaitingTime();
        cooperativesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(switchTo().window(0).getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        switchTo().window(windowToSwitch);

        String currentGameTitleText = cooperativesPage.gameTitleGetText();
        String expectedGameTitleText = "Garry's Mod";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();

        mainPage.categoriesButtonTopMenuDesktopClick().mysteriesAndDetectivesCategoryButtonClick();
        Assert.assertEquals(url(), "https://store.steampowered.com/category/mystery_detective/", "Открыта неверная страница");

        MysteriesAndDetectivesPage mysteriesAndDetectivesPage = new MysteriesAndDetectivesPage();

        mysteriesAndDetectivesPage.salesLeadersParameterButtonClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .salesLeadersParameterButtonActiveStatusChecking(), "Раздел \"Лидеры продаж\" не выбран");

        addWaitingTime();
        mysteriesAndDetectivesPage.showMoreButtonClickByJs().strategyParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .strategyParameterTagChecking(), "Тэг \"Стратегия\" не отображается");

        mysteriesAndDetectivesPage.playersParameterClickByJs().forMultiplePlayersParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .forMultiplePlayersParameterTagChecking(), "Тэг \"Для нескольких игроков\" не отображается");

        addWaitingTime();
        mysteriesAndDetectivesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(switchTo().window(0).getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        switchTo().window(windowToSwitch);

        String currentGameTitleText = mysteriesAndDetectivesPage.gameTitleGetText();
        String expectedGameTitleText = "West Hunt";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "Oxygen Not Included";

        MainPage mainPage = new MainPage();

        mainPage.SearchGameByInputBox(observedGameSeries);
        Assert.assertEquals(title(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();

        filterPage.releasingDateParameterClickByJs();
        Assert.assertTrue(filterPage
                .releasingDateParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.removeFreeGamesCheckboxClickByJs();
        Assert.assertTrue(filterPage
                .removeFreeGamesCheckboxActiveStatusChecking(), "Checkbox \"Скрыть бесплатные игры\" не активирован");

        addWaitingTime();
        Map<String, WebElement> foundGameInformation = filterPage.searchingForRequiredGameInList(observedGameSeries);
        WebElement foundGame = foundGameInformation.get("gameElement");
        WebElement currentGameTitle = foundGameInformation.get("gameTitle");

        if (foundGame != null) {
            String expectedGameTitle = "Oxygen Not Included - Spaced Out!";
            String expectedCurrentGamePrice = "299 руб";
            String expectedCurrentGameReleaseDate = "16 дек. 2021";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGameTitle
                    .getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage
                    .getGameReleaseDate(foundGame), expectedCurrentGameReleaseDate, "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage
                    .getGamePrice(foundGame), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Ни одна игра серии " + observedGameSeries + " не найдена");
        }
    }

    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "PUZZLE";

        MainPage mainPage = new MainPage();

        mainPage.SearchGameByInputBox(observedGameSeries);
        Assert.assertEquals(title(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();

        filterPage.priceIncreaseParameterClickByJs();
        Assert.assertTrue(filterPage
                .priceIncreaseParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.specialOffersCheckboxClickByJs();
        Assert.assertTrue(filterPage
                .specialOffersCheckboxActiveStatusChecking(), "Checkbox \"Специальные предложения\" не активирован");

        filterPage.windowsOperatingSystemParameterClickByJs();
        Assert.assertTrue(filterPage
                .windowsOperatingSystemParameterActiveStatusChecking(), "Checkbox \"Windows\" не активирован");

        addWaitingTime();
        Map<String, WebElement> foundGameInformation = filterPage.searchingForRequiredGameInList(observedGameSeries);
        WebElement foundGame = foundGameInformation.get("gameElement");
        WebElement currentGameTitle = foundGameInformation.get("gameTitle");

        if (foundGame != null) {
            String expectedGameTitle = "PUZZLE: LANDSCAPES";
            String expectedCurrentGamePrice = "21 руб";
            String expectedCurrentGameReleaseDate = "8 авг. 2018";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGameTitle
                    .getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertTrue(filterPage.getGameReleaseDate(foundGame)
                    .contains(expectedCurrentGameReleaseDate), "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage
                    .getGamePrice(foundGame), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Ни одна игра серии " + observedGameSeries + " не найдена");
        }
    }

    private void addWaitingTime() {
        sleep(2000);
    }
}