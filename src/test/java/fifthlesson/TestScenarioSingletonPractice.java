package fifthlesson;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobject.CooperativesPage;
import pageobject.MainPage;
import pageobject.MysteriesAndDetectivesPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static utils.DriverSingleton.*;


public class TestScenarioSingletonPractice {
    private WebDriverWait webDriverWait;

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.categoriesButtonTopMenuDesktopClick(webDriverWait);
        mainPage.cooperativesCategoryButtonClick(webDriverWait);

        CooperativesPage cooperativesPage = new CooperativesPage();
        cooperativesPage.filterSectionScrolling(webDriverWait);

        cooperativesPage.witTheHighestRatingParameterButtonClickByJs(webDriverWait);
        Assert.assertTrue(cooperativesPage.witTheHighestRatingParameterButtonActiveStatusChecking(webDriverWait), "Раздел \"С наивысшим рейтингом\" не выбран");

        cooperativesPage.casualGameParameterClickByJs(webDriverWait);
        Assert.assertTrue(cooperativesPage.casualGameParameterTagChecking(webDriverWait), "Тэг \"Казуальная игра\" не отображается");

        cooperativesPage.playersParameterClickByJs(webDriverWait);

        String resultsText = cooperativesPage.fieldWithSearchResultsGetText(webDriverWait);

        cooperativesPage.cooperativeParameterClickByJs(webDriverWait);
        Assert.assertTrue(cooperativesPage.cooperativeParameterTagChecking(webDriverWait), "Тэг \"Кооператив игра\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(cooperativesPage.fieldWithSearchResultsPath(webDriverWait), resultsText))));

        String resultsTextForComparing = cooperativesPage.fieldWithSearchResultsGetText(webDriverWait);

        if (!resultsText.equals(resultsTextForComparing)) {
            cooperativesPage.firstGameWithFilterParametersClickByJs(webDriverWait);
            List<String> allWindowHandles = new ArrayList<>(DRIVER.getDriver().getWindowHandles());
            String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
            DRIVER.getDriver().switchTo().window(windowToSwitch);
        }

        Assert.assertEquals(cooperativesPage.gameTitleGetText(webDriverWait), "Garry's Mod", "Указан заголовок некорректной игры");
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(30));
        DRIVER.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Assert.assertEquals(DRIVER.getDriver().getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");

        MainPage mainPage = new MainPage();
        mainPage.categoriesButtonTopMenuDesktopClick(webDriverWait);
        mainPage.mysteriesAndDetectivesCategoryButtonClick(webDriverWait);

        MysteriesAndDetectivesPage mysteriesAndDetectivesPage = new MysteriesAndDetectivesPage();
        mysteriesAndDetectivesPage.filterSectionScrolling(webDriverWait);

        mysteriesAndDetectivesPage.salesLeadersParameterButtonClickByJs(webDriverWait);
        Assert.assertTrue(mysteriesAndDetectivesPage.salesLeadersParameterButtonActiveStatusChecking(webDriverWait), "Раздел \"Лидеры продаж\" не выбран");

        mysteriesAndDetectivesPage.showMoreButtonClickByJs(webDriverWait);

        mysteriesAndDetectivesPage.strategyParameterClickByJs(webDriverWait);
        Assert.assertTrue(mysteriesAndDetectivesPage.strategyParameterTagChecking(webDriverWait), "Тэг \"Стратегия\" не отображается");

        mysteriesAndDetectivesPage.playersParameterClickByJs(webDriverWait);

        String resultsText = mysteriesAndDetectivesPage.fieldWithSearchResultsGetText(webDriverWait);

        mysteriesAndDetectivesPage.forMultiplePlayersParameterClickByJs(webDriverWait);
        Assert.assertTrue(mysteriesAndDetectivesPage.forMultiplePlayersParameterTagChecking(webDriverWait), "Тэг \"Для нескольких игроков\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(mysteriesAndDetectivesPage.fieldWithSearchResultsPath(webDriverWait), resultsText))));

        String resultsTextForComparing = mysteriesAndDetectivesPage.fieldWithSearchResultsGetText(webDriverWait);

        if (!resultsText.equals(resultsTextForComparing)) {
            mysteriesAndDetectivesPage.firstGameWithFilterParametersClickByJs(webDriverWait);
            List<String> allWindowHandles = new ArrayList<>(DRIVER.getDriver().getWindowHandles());
            String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
            DRIVER.getDriver().switchTo().window(windowToSwitch);
        }

        Assert.assertEquals(mysteriesAndDetectivesPage.gameTitleGetText(webDriverWait), "West Hunt", "Указан заголовок некорректной игры");
    }

//    @Test(priority = 3)
//    public void checkingSortingByReleaseDateOfGame() {
//        webDriverWait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
//        DriverSingleton.getDriver().manage().window().maximize();
//        MainPage.getToMainPage();
//        Actions actions = new Actions(DriverSingleton.getDriver());
//
//        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBox())));
//        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBox()));
//        actions.sendKeys(MainPage.getWebElement(MainPage.getInputBox()), "Oxygen Not Included").perform();
//
//        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBoxConfirm())));
//        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBoxConfirm()));
//        Assert.assertEquals(DriverSingleton.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSortingParameters())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSortingParameters()));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getReleasingDateParameter())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getReleasingDateParameter()));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getFieldWithSearchResults())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getFieldWithSearchResults()));
//        String resultsText = FilterPage.getWebElement(FilterPage.getFieldWithSearchResults()).getText();
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getRemoveFreeGamesCheckbox())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getRemoveFreeGamesCheckbox()));
//
//        webDriverWait.until(refreshed(not(textToBe(FilterPage.getFieldWithSearchResults(), resultsText))));
//        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(FilterPage.getFieldWithSearchResults()));
//        String resultsTextForComparing = resultsForComparing.getText();
//
//        webDriverWait.until(refreshed(not(textToBe(FilterPage.getFieldWithSearchResults(), resultsTextForComparing))));
//        WebElement resultsForComparing2 = webDriverWait.until(visibilityOfElementLocated(FilterPage.getFieldWithSearchResults()));
//        String resultsTextForComparing2 = resultsForComparing2.getText();
//
//        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
//            List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(FilterPage.getAllGames()));
//            for (WebElement game : allGames) {
//                WebElement currentGame = game.findElement(FilterPage.getCurrentGame());
//                if (currentGame.getText().startsWith("Oxygen Not Included")) {
//                    WebElement gameReleaseDate = game.findElement(FilterPage.getReleasingDateParameter());
//                    WebElement gamePrice = game.findElement(FilterPage.getGamePrice());
//                    Assert.assertEquals(currentGame.getText(), "Oxygen Not Included - Spaced Out!", "Указан заголовок некорректной игры");
//                    Assert.assertEquals(gameReleaseDate.getText(), "16 дек. 2021", "Указана некорректная дата релиза игры");
//                    Assert.assertEquals(gamePrice.getText(), "299 руб", "Указана некорректная цена игры");
//                    break;
//                }
//            }
//        }
//    }
//
//    /**
//     * Тест сам по себе рабочий, но с 5 февраля не актуален в связи с тем, что специальное предложение по играм с таким названием
//     * закончилось, и все они перестали отображаться в списке при установке галочки в элементе specialOffersCheckbox
//     */
//    @Test(priority = 4)
//    public void checkingSortingByReleaseDateAndOtherParameter() {
//        webDriverWait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
//        DriverSingleton.getDriver().manage().window().maximize();
//        MainPage.getToMainPage();
//        Actions actions = new Actions(DriverSingleton.getDriver());
//
//        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBox())));
//        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBox()));
//        actions.sendKeys(MainPage.getWebElement(MainPage.getInputBox()), "The Callisto Protocol").perform();
//
//        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBoxConfirm())));
//        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBoxConfirm()));
//        Assert.assertEquals(DriverSingleton.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSortingParameters())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSortingParameters()));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getPriceIncreaseParameter())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getPriceIncreaseParameter()));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSpecialOffersCheckbox())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSpecialOffersCheckbox()));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getFieldWithSearchResultsWhereCountIsNull())));
//
//        webDriverWait.until((visibilityOfElementLocated(FilterPage.getWindowsOperatingSystemParameter())));
//        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getWindowsOperatingSystemParameter()));
//
//        List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(FilterPage.getAllGames()));
//        for (WebElement game : allGames) {
//            WebElement currentGame = game.findElement(FilterPage.getCurrentGame());
//            if (currentGame.getText().startsWith("The Callisto Protocol")) {
//                WebElement gameReleaseDate = game.findElement(FilterPage.getGameReleaseDate());
//                WebElement gamePrice = game.findElement(FilterPage.getGamePrice());
//                Assert.assertEquals(currentGame.getText(), "The Callisto Protocol™ - The Outer Way Skin Collection", "Указан заголовок некорректной игры");
//                Assert.assertTrue(gameReleaseDate.getText().contains("7 фев. 2023"), "Указана некорректная дата релиза игры");
//                Assert.assertEquals(gamePrice.getText(), "200 руб", "Указана некорректная цена игры");
//                break;
//            }
//        }
//    }

    @AfterTest
    public void afterTests() {
        DRIVER.getDriver().quit();
    }
}