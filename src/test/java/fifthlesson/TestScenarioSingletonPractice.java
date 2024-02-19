package fifthlesson;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.CooperativesPage;
import pageobject.FilterPage;
import pageobject.MainPage;
import pageobject.MysteriesAndDetectivesPage;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverSingleton.MANAGER;

public class TestScenarioSingletonPractice {

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        MANAGER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(MANAGER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

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

        cooperativesPage.cooperativeParameterClickByJs();
        Assert.assertTrue(cooperativesPage.cooperativeParameterTagChecking(), "Тэг \"Кооператив игра\" не отображается");

        cooperativesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(MANAGER.getDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        MANAGER.getDriver().switchTo().window(windowToSwitch);

        String currentGameTitleText = cooperativesPage.gameTitleGetText();
        String expectedGameTitleText = "Garry's Mod";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        MANAGER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(MANAGER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

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

        mysteriesAndDetectivesPage.forMultiplePlayersParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage.forMultiplePlayersParameterTagChecking(), "Тэг \"Для нескольких игроков\" не отображается");

        mysteriesAndDetectivesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(MANAGER.getDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        MANAGER.getDriver().switchTo().window(windowToSwitch);

        String currentGameTitleText = mysteriesAndDetectivesPage.gameTitleGetText();
        String expectedGameTitleText = "West Hunt";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() throws InterruptedException {
        MANAGER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(MANAGER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "Oxygen Not Included";

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText(observedGameSeries);
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(MANAGER.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.releasingDateParameterClickByJs();
        Assert.assertTrue(filterPage.releasingDateParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.removeFreeGamesCheckboxClickByJs();
        Assert.assertTrue(filterPage.removeFreeGamesCheckboxActiveStatusChecking(), "Checkbox \"Скрыть бесплатные игры\" не активирован");

        addingWaitingTime();
        List<WebElement> allGames = filterPage.getAllGamesWithFilterParameters();
        WebElement foundGame = null;
        WebElement currentGameTitle = null;

        for (WebElement game : allGames) {
            currentGameTitle = filterPage.getCurrentGameTitle(game);
            if (currentGameTitle.getText().startsWith(observedGameSeries)) {
                foundGame = game;
                break;
            }
        }

        if (foundGame != null) {
            String expectedGameTitle = "Oxygen Not Included - Spaced Out!";
            String expectedCurrentGamePrice = "299 руб";
            String expectedCurrentGameReleaseDate = "16 дек. 2021";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGameTitle.getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage.getGameReleaseDate(foundGame), expectedCurrentGameReleaseDate, "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage.getGamePrice(foundGame), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Ни одна игра серии " + observedGameSeries + " не найдена");
        }
    }

    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() throws InterruptedException {
        MANAGER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(MANAGER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "HITMAN";

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText(observedGameSeries);
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(MANAGER.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.priceIncreaseParameterClickByJs();
        Assert.assertTrue(filterPage.priceIncreaseParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.specialOffersCheckboxClickByJs();
        Assert.assertTrue(filterPage.specialOffersCheckboxActiveStatusChecking(), "Checkbox \"Специальные предложения\" не активирован");

        filterPage.windowsOperatingSystemParameterClickByJs();
        Assert.assertTrue(filterPage.windowsOperatingSystemParameterActiveStatusChecking(), "Checkbox \"Windows\" не активирован");

        addingWaitingTime();
        List<WebElement> allGames = filterPage.getAllGamesWithFilterParameters();
        WebElement foundGame = null;
        WebElement currentGameTitle = null;

        for (WebElement game : allGames) {
            currentGameTitle = filterPage.getCurrentGameTitle(game);
            if (currentGameTitle.getText().startsWith(observedGameSeries)) {
                foundGame = game;
                break;
            }
        }

        if (foundGame != null) {
            String expectedGameTitle = "HITMAN 3 - Trinity Pack";
            String expectedCurrentGamePrice = "140 руб";
            String expectedCurrentGameReleaseDate = "20 янв. 2022";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGameTitle.getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertTrue(filterPage.getGameReleaseDate(foundGame).contains(expectedCurrentGameReleaseDate), "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage.getGamePrice(foundGame), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Ни одна игра серии " + observedGameSeries + " не найдена");
        }
    }

    private void addingWaitingTime() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterTest
    public void afterTests() {
        MANAGER.getDriver().quit();
    }

}