package fifthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import fifthlesson.pageobject.CooperativesPage;
import fifthlesson.pageobject.FilterPage;
import fifthlesson.pageobject.MainPage;
import fifthlesson.pageobject.MysteriesAndDetectivesPage;
import fifthlesson.utils.ConfigPropertiesProcessing;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestScenarioSingletonPractice {

    @BeforeTest
    public void driverOptions() {
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
        mainPage.categoriesButtonTopMenuDesktopClick();
        mainPage.cooperativesCategoryButtonClick();
        Assert.assertEquals(url(), "https://store.steampowered.com/category/multiplayer_coop/", "Открыта неверная страница");

        CooperativesPage cooperativesPage = new CooperativesPage();
        cooperativesPage.filterSectionScrolling();

        cooperativesPage.withTheHighestRatingParameterButtonClickByJs();
        Assert.assertTrue(cooperativesPage
                .withTheHighestRatingParameterButtonActiveStatusChecking(), "Раздел \"С наивысшим рейтингом\" не выбран");

        cooperativesPage.casualGameParameterClickByJs();
        Assert.assertTrue(cooperativesPage
                .casualGameParameterTagChecking(), "Тэг \"Казуальная игра\" не отображается");

        cooperativesPage.playersParameterClickByJs();

        cooperativesPage.cooperativeParameterClickByJs();
        Assert.assertTrue(cooperativesPage
                .cooperativeParameterTagChecking(), "Тэг \"Кооператив игра\" не отображается");

        cooperativesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(Selenide.webdriver().driver().getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        Selenide.webdriver().driver().switchTo().window(windowToSwitch);

        String currentGameTitleText = cooperativesPage.gameTitleGetText();
        String expectedGameTitleText = "Garry's Mod";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() throws InterruptedException {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.categoriesButtonTopMenuDesktopClick();
        mainPage.mysteriesAndDetectivesCategoryButtonClick();
        Assert.assertEquals(url(), "https://store.steampowered.com/category/mystery_detective/", "Открыта неверная страница");

        MysteriesAndDetectivesPage mysteriesAndDetectivesPage = new MysteriesAndDetectivesPage();
        mysteriesAndDetectivesPage.filterSectionScrolling();

        mysteriesAndDetectivesPage.salesLeadersParameterButtonClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .salesLeadersParameterButtonActiveStatusChecking(), "Раздел \"Лидеры продаж\" не выбран");

        addingWaitingTime();
        mysteriesAndDetectivesPage.showMoreButtonClickByJs();

        mysteriesAndDetectivesPage.strategyParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .strategyParameterTagChecking(), "Тэг \"Стратегия\" не отображается");

        mysteriesAndDetectivesPage.playersParameterClickByJs();

        mysteriesAndDetectivesPage.forMultiplePlayersParameterClickByJs();
        Assert.assertTrue(mysteriesAndDetectivesPage
                .forMultiplePlayersParameterTagChecking(), "Тэг \"Для нескольких игроков\" не отображается");

        mysteriesAndDetectivesPage.firstGameWithFilterParametersClickByJs();
        List<String> allWindowHandles = new ArrayList<>(Selenide.webdriver().driver().getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        Selenide.webdriver().driver().switchTo().window(windowToSwitch);

        String currentGameTitleText = mysteriesAndDetectivesPage.gameTitleGetText();
        String expectedGameTitleText = "West Hunt";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() throws InterruptedException {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "Oxygen Not Included";

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText(observedGameSeries);
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(Selenide.webdriver().driver().getWebDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.releasingDateParameterClickByJs();
        Assert.assertTrue(filterPage
                .releasingDateParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.removeFreeGamesCheckboxClickByJs();
        Assert.assertTrue(filterPage
                .removeFreeGamesCheckboxActiveStatusChecking(), "Checkbox \"Скрыть бесплатные игры\" не активирован");

        addingWaitingTime();
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
    public void checkingSortingByReleaseDateAndOtherParameter() throws InterruptedException {
        open("https://store.steampowered.com/");
        Assert.assertEquals(url(), "https://store.steampowered.com/", "Открыта неверная страница");
        String observedGameSeries = "HITMAN";

        MainPage mainPage = new MainPage();
        mainPage.inputBoxWriteText(observedGameSeries);
        mainPage.inputBoxConfirmClick();
        Assert.assertEquals(Selenide.webdriver().driver().getWebDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        FilterPage filterPage = new FilterPage();
        filterPage.sortingParametersClickByJs();

        filterPage.priceIncreaseParameterClickByJs();
        Assert.assertTrue(filterPage
                .priceIncreaseParameterSortingChecking(), "Установлен неверный параметр сортировки");

        filterPage.specialOffersCheckboxClickByJs();
        Assert.assertTrue(filterPage
                .specialOffersCheckboxActiveStatusChecking(), "Checkbox \"Специальные предложения\" не активирован");

        filterPage.windowsOperatingSystemParameterClickByJs();
        Assert.assertTrue(filterPage
                .windowsOperatingSystemParameterActiveStatusChecking(), "Checkbox \"Windows\" не активирован");

        addingWaitingTime();
        Map<String, WebElement> foundGameInformation = filterPage.searchingForRequiredGameInList(observedGameSeries);
        WebElement foundGame = foundGameInformation.get("gameElement");
        WebElement currentGameTitle = foundGameInformation.get("gameTitle");

        if (foundGame != null) {
            String expectedGameTitle = "HITMAN 3 - Trinity Pack";
            String expectedCurrentGamePrice = "140 руб";
            String expectedCurrentGameReleaseDate = "20 янв. 2022";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGameTitle
                    .getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertTrue(filterPage
                    .getGameReleaseDate(foundGame).contains(expectedCurrentGameReleaseDate), "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(filterPage
                    .getGamePrice(foundGame), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Ни одна игра серии " + observedGameSeries + " не найдена");
        }
    }

    private void addingWaitingTime() throws InterruptedException {
        Thread.sleep(3000);
    }

}