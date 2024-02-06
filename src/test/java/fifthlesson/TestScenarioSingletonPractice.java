package fifthlesson;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobject.CooperativesPage;
import pageobject.FilterPage;
import pageobject.MainPage;
import pageobject.MysteriesAndDetectivesPage;
import utils.Driver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestScenarioSingletonPractice {
    private WebDriverWait webDriverWait;

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        Driver.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Actions actions = new Actions(Driver.getDriver());

        webDriverWait.until((visibilityOfElementLocated(MainPage.getCategoriesButtonTopMenuDesktop())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getCategoriesButtonTopMenuDesktop()));

        webDriverWait.until((visibilityOfElementLocated(MainPage.getCooperativesCategoryButton())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getCooperativesCategoryButton()));

        actions.scrollByAmount(0, 1850).perform();

        webDriverWait.until((visibilityOfElementLocated(CooperativesPage.getWitTheHighestRatingParameterButton())));
        CooperativesPage.clickByJs(CooperativesPage.getWebElement(CooperativesPage.getWitTheHighestRatingParameterButton()));

        webDriverWait.until((visibilityOfElementLocated(CooperativesPage.getCasualGameParameter())));
        CooperativesPage.clickByJs(CooperativesPage.getWebElement(CooperativesPage.getCasualGameParameter()));

        webDriverWait.until((visibilityOfElementLocated(CooperativesPage.getPlayersParameter())));
        CooperativesPage.clickByJs(CooperativesPage.getWebElement(CooperativesPage.getPlayersParameter()));

        webDriverWait.until((visibilityOfElementLocated(CooperativesPage.getFieldWithSearchResults())));
        CooperativesPage.clickByJs(CooperativesPage.getWebElement(CooperativesPage.getFieldWithSearchResults()));
        String resultsText = CooperativesPage.getWebElement(CooperativesPage.getFieldWithSearchResults()).getText();

        webDriverWait.until((visibilityOfElementLocated(CooperativesPage.getCooperativeParameter())));
        CooperativesPage.clickByJs(CooperativesPage.getWebElement(CooperativesPage.getCooperativeParameter()));

        webDriverWait.until(refreshed(not(textToBe(CooperativesPage.getFieldWithSearchResults(), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(CooperativesPage.getFieldWithSearchResults()));
        String resultsTextForComparing = resultsForComparing.getText();

        if (!resultsText.equals(resultsTextForComparing)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((CooperativesPage.getFirstGameWithFilterParameters())));
            String gameLink = firstGameWithFilterParameters.getAttribute("href");
            Driver.getDriver().get(gameLink);
            Assert.assertEquals(Driver.getDriver().getTitle(), "Garry's Mod в Steam", "Указан заголовок некорректной игры");
        }
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        Driver.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Actions actions = new Actions(Driver.getDriver());

        webDriverWait.until((visibilityOfElementLocated(MainPage.getCategoriesButtonTopMenuDesktop())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getCategoriesButtonTopMenuDesktop()));

        webDriverWait.until((visibilityOfElementLocated(MainPage.getMysteriesAndDetectivesCategoryButton())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getMysteriesAndDetectivesCategoryButton()));

        actions.scrollByAmount(0, 1850).perform();

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getSalesLeadersParameterButton())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getSalesLeadersParameterButton()));

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getShowMoreButton())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getShowMoreButton()));

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getFieldWithSearchResults())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getFieldWithSearchResults()));
        String resultsText = MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getFieldWithSearchResults()).getText();

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getStrategyParameter())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getStrategyParameter()));

        webDriverWait.until(refreshed(not(textToBe(MysteriesAndDetectivesPage.getFieldWithSearchResults(), resultsText))));

        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(MysteriesAndDetectivesPage.getFieldWithSearchResults()));
        String resultsTextForComparing = resultsForComparing.getText();

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getPlayersParameter())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getPlayersParameter()));

        webDriverWait.until((visibilityOfElementLocated(MysteriesAndDetectivesPage.getForMultiplePlayersParameter())));
        MysteriesAndDetectivesPage.clickByJs(MysteriesAndDetectivesPage.getWebElement(MysteriesAndDetectivesPage.getForMultiplePlayersParameter()));

        webDriverWait.until(refreshed(not(textToBe(MysteriesAndDetectivesPage.getFieldWithSearchResults(), resultsTextForComparing))));

        WebElement resultsForComparing2 = webDriverWait.until(visibilityOfElementLocated(MysteriesAndDetectivesPage.getFieldWithSearchResults()));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((MysteriesAndDetectivesPage.getFirstGameWithFilterParameters())));
            String gameLink = firstGameWithFilterParameters.getAttribute("href");
            Driver.getDriver().get(gameLink);
            Assert.assertEquals(Driver.getDriver().getTitle(), "West Hunt в Steam", "Указан заголовок некорректной игры");
        }
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        Driver.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Actions actions = new Actions(Driver.getDriver());

        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBox())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBox()));
        actions.sendKeys(MainPage.getWebElement(MainPage.getInputBox()), "Oxygen Not Included").perform();

        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBoxConfirm())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBoxConfirm()));
        Assert.assertEquals(Driver.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSortingParameters())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSortingParameters()));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getReleasingDateParameter())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getReleasingDateParameter()));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getFieldWithSearchResults())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getFieldWithSearchResults()));
        String resultsText = FilterPage.getWebElement(FilterPage.getFieldWithSearchResults()).getText();

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getRemoveFreeGamesCheckbox())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getRemoveFreeGamesCheckbox()));

        webDriverWait.until(refreshed(not(textToBe(FilterPage.getFieldWithSearchResults(), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(FilterPage.getFieldWithSearchResults()));
        String resultsTextForComparing = resultsForComparing.getText();

        webDriverWait.until(refreshed(not(textToBe(FilterPage.getFieldWithSearchResults(), resultsTextForComparing))));
        WebElement resultsForComparing2 = webDriverWait.until(visibilityOfElementLocated(FilterPage.getFieldWithSearchResults()));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(FilterPage.getAllGames()));
            for (WebElement game : allGames) {
                WebElement currentGame = game.findElement(FilterPage.getCurrentGame());
                if (currentGame.getText().startsWith("Oxygen Not Included")) {
                    WebElement gameReleaseDate = game.findElement(FilterPage.getReleasingDateParameter());
                    WebElement gamePrice = game.findElement(FilterPage.getGamePrice());
                    Assert.assertEquals(currentGame.getText(), "Oxygen Not Included - Spaced Out!", "Указан заголовок некорректной игры");
                    Assert.assertEquals(gameReleaseDate.getText(), "16 дек. 2021", "Указана некорректная дата релиза игры");
                    Assert.assertEquals(gamePrice.getText(), "299 руб", "Указана некорректная цена игры");
                    break;
                }
            }
        }
    }

    /**
     * Тест сам по себе рабочий, но с 5 февраля не актуален в связи с тем, что специальное предложение по играм с таким названием
     * закончилось, и все они перестали отображаться в списке при установке галочки в элементе specialOffersCheckbox
     */
    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        Driver.getDriver().manage().window().maximize();
        MainPage.getToMainPage();
        Actions actions = new Actions(Driver.getDriver());

        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBox())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBox()));
        actions.sendKeys(MainPage.getWebElement(MainPage.getInputBox()), "The Callisto Protocol").perform();

        webDriverWait.until((visibilityOfElementLocated(MainPage.getInputBoxConfirm())));
        MainPage.clickByJs(MainPage.getWebElement(MainPage.getInputBoxConfirm()));
        Assert.assertEquals(Driver.getDriver().getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSortingParameters())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSortingParameters()));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getPriceIncreaseParameter())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getPriceIncreaseParameter()));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getSpecialOffersCheckbox())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getSpecialOffersCheckbox()));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getFieldWithSearchResultsWhereCountIsNull())));

        webDriverWait.until((visibilityOfElementLocated(FilterPage.getWindowsOperatingSystemParameter())));
        FilterPage.clickByJs(FilterPage.getWebElement(FilterPage.getWindowsOperatingSystemParameter()));

        List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(FilterPage.getAllGames()));
        for (WebElement game : allGames) {
            WebElement currentGame = game.findElement(FilterPage.getCurrentGame());
            if (currentGame.getText().startsWith("The Callisto Protocol")) {
                WebElement gameReleaseDate = game.findElement(FilterPage.getGameReleaseDate());
                WebElement gamePrice = game.findElement(FilterPage.getGamePrice());
                Assert.assertEquals(currentGame.getText(), "The Callisto Protocol™ - The Outer Way Skin Collection", "Указан заголовок некорректной игры");
                Assert.assertTrue(gameReleaseDate.getText().contains("7 фев. 2023"), "Указана некорректная дата релиза игры");
                Assert.assertEquals(gamePrice.getText(), "200 руб", "Указана некорректная цена игры");
                break;
            }
        }
    }

    @AfterTest
    public void afterTests() {
        Driver.getDriver().quit();
    }
}