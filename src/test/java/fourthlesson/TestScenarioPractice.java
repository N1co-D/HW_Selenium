package fourthlesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestScenarioPractice {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeClass
    public WebDriver browserDefinition() {
        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();

        try {
            props.load(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла!");
            throw new RuntimeException(e);
        }

        if (props.getProperty("browser").equals("chrome")) {
            System.out.println("Определен браузер: Google Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (props.getProperty("browser").equals("firefox")) {
            System.out.println("Определен браузер: Mozilla Firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("start-maximized");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (props.getProperty("browser").equals("edge")) {
            System.out.println("Определен браузер: Microsoft Edge");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("start-maximized");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else {
            System.err.println("Браузер не определен");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        return driver;
    }

    @Test(priority = 1)
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://store.steampowered.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        Actions actions = new Actions(driver);

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        clickByJs(categoriesButtonTopMenuDesktop);

        WebElement cooperativesCategoryButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[text() = 'Кооперативы']")));
        clickByJs(cooperativesCategoryButton);

        WebElement filterSection = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'SaleSection_13268']")));
        actions.scrollToElement(filterSection).perform();

        WebElement witTheHighestRatingParameterButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'С наивысшим рейтингом']")));
        clickByJs(witTheHighestRatingParameterButton);
        WebElement witTheHighestRatingParameterButtonActiveStatus = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'С наивысшим рейтингом']")));
        Assert.assertTrue(witTheHighestRatingParameterButtonActiveStatus.isDisplayed(), "Раздел \"С наивысшим рейтингом\" не выбран");

        WebElement casualGameParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Казуальная игра']")));
        clickByJs(casualGameParameter);
        WebElement casualGameParameterTag = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[text() = 'Казуальная игра']")));
        Assert.assertTrue(casualGameParameterTag.isDisplayed(), "Тэг \"Казуальная игра\" не отображается");

        WebElement playersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, '_3L67OJmzdGjQ4fcAzZ2JvY') and text() = 'Игроки']")));
        clickByJs(playersParameter);

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Совпадений:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement cooperativeParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Кооператив']")));
        clickByJs(cooperativeParameter);
        WebElement cooperativeParameterTag = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[text() = 'Кооператив']")));
        Assert.assertTrue(cooperativeParameterTag.isDisplayed(), "Тэг \"Кооператив игра\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Совпадений:')]"), resultsText))));

        WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]"))));
        clickByJs(firstGameWithFilterParameters);
        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        driver.switchTo().window(windowToSwitch);

        WebElement gameTitle = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[@id = 'appHubAppName']"))));
        String currentGameTitleText = gameTitle.getText();
        String expectedGameTitleText = "Garry's Mod";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://store.steampowered.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        Actions actions = new Actions(driver);

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        clickByJs(categoriesButtonTopMenuDesktop);

        WebElement mysteriesAndDetectivesCategoryButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[text() = 'Тайны и детективы']")));
        clickByJs(mysteriesAndDetectivesCategoryButton);

        WebElement filterSection = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'SaleSection_13268']")));
        actions.scrollToElement(filterSection).perform();

        WebElement salesLeadersParameterButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'Лидеры продаж']")));
        clickByJs(salesLeadersParameterButton);
        WebElement salesLeadersParameterButtonActiveStatus = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, '3HhxiFyD3z9B') and text() = 'Лидеры продаж']")));
        Assert.assertTrue(salesLeadersParameterButtonActiveStatus.isDisplayed(), "Раздел \"Лидеры продаж\" не выбран");

        WebElement showMoreButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'Показать больше']")));
        clickByJs(showMoreButton);

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Совпадений:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement strategyParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Qu-ZCE2EM66oWdyl74Lzy')]//a[text() = 'Стратегия']")));
        clickByJs(strategyParameter);
        WebElement strategyParameterTag = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[text() = 'Стратегия']")));
        Assert.assertTrue(strategyParameterTag.isDisplayed(), "Тэг \"Стратегия\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Совпадений:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        WebElement playersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'Игроки']")));
        clickByJs(playersParameter);

        WebElement forMultiplePlayersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, '_3WMvo5MdrS9WFngIIdcTlU') and text() = 'Для нескольких игроков']")));
        clickByJs(forMultiplePlayersParameter);
        WebElement forMultiplePlayersParameterTag = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[text() = 'Для нескольких игроков']")));
        Assert.assertTrue(forMultiplePlayersParameterTag.isDisplayed(), "Тэг \"Для нескольких игроков\" не отображается");

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Совпадений:')]"), resultsTextForComparing))));

        WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]"))));
        clickByJs(firstGameWithFilterParameters);
        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        driver.switchTo().window(windowToSwitch);

        WebElement gameTitle = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[@id = 'appHubAppName']"))));
        String currentGameTitleText = gameTitle.getText();
        String expectedGameTitleText = "West Hunt";
        Assert.assertEquals(currentGameTitleText, expectedGameTitleText, "Текущий заголовок игры " + currentGameTitleText + " не соответствует ожидаемому значению - " + expectedGameTitleText);
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        Actions actions = new Actions(driver);
        String observedGame = "Oxygen Not Included";

        WebElement inputBox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        clickByJs(inputBox);
        actions.sendKeys(inputBox, observedGame).perform();

        WebElement inputBoxConfirm = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        clickByJs(inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(visibilityOfElementLocated(By.id("sort_by_trigger")));
        clickByJs(sortingParameters);

        WebElement releasingDateParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[text() = 'дате выхода']")));
        clickByJs(releasingDateParameter);
        WebElement releasingDateParameterChecking = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'sort_by_dselect_container']/a[text() = 'дате выхода']")));
        Assert.assertTrue(releasingDateParameterChecking.isDisplayed(), "Установлен неверный параметр сортировки");

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement removeFreeGamesCheckbox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(removeFreeGamesCheckbox);
        WebElement removeFreeGamesCheckboxActiveStatus = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'checked') and @data-loc = 'Скрыть бесплатные игры']")));
        Assert.assertTrue(removeFreeGamesCheckboxActiveStatus.isDisplayed(), "Checkbox \"Скрыть бесплатные игры\" не активирован");

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]"), resultsTextForComparing))));

        List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
        WebElement foundGame = null;
        WebElement currentGame = null;

        for (WebElement game : allGames) {
            currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
            if (currentGame.getText().startsWith(observedGame)) {
                foundGame = game;
                break;
            }
        }

        if (foundGame != null) {
            WebElement gameReleaseDate = foundGame.findElement(By.xpath(".//div[contains(@class, 'search_released')]"));
            WebElement gamePrice = foundGame.findElement(By.xpath(".//div[@class = 'discount_final_price']"));
            String expectedGameTitle = "Oxygen Not Included - Spaced Out!";
            String expectedCurrentGamePrice = "299 руб";
            String expectedCurrentGameReleaseDate = "16 дек. 2021";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGame.getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(gameReleaseDate.getText(), expectedCurrentGameReleaseDate, "Полученная дата релиза игры не соответствует ожидаемому значению");
            checkingGameParameters.assertEquals(gamePrice.getText(), expectedCurrentGamePrice, "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Игра с названием " + observedGame + " не найдена");
        }
    }

    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.steampowered.com/", "Открыта неверная страница");
        Actions actions = new Actions(driver);
        String observedGame = "HITMAN";

        WebElement inputBox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        clickByJs(inputBox);
        actions.sendKeys(inputBox, observedGame).perform();

        WebElement inputBoxConfirm = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        clickByJs(inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(visibilityOfElementLocated(By.id("sort_by_trigger")));
        clickByJs(sortingParameters);

        WebElement priceIncreaseParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'Price_ASC']")));
        clickByJs(priceIncreaseParameter);
        WebElement priceIncreaseParameterChecking = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'sort_by_dselect_container']/a[text() = 'возрастанию цены']")));
        Assert.assertTrue(priceIncreaseParameterChecking.isDisplayed(), "Установлен неверный параметр сортировки");

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement specialOffersCheckbox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(specialOffersCheckbox);
        WebElement specialOffersCheckboxActiveStatus = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'checked') and @data-loc = 'Специальные предложения']")));
        Assert.assertTrue(specialOffersCheckboxActiveStatus.isDisplayed(), "Checkbox \"Специальные предложения\" не активирован");

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(text(), 'Результатов по вашему запросу:')]"), resultsText))));

        WebElement windowsOperatingSystemCheckbox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(windowsOperatingSystemCheckbox);
        WebElement windowsOperatingSystemCheckboxActiveStatus = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'checked') and @data-loc = 'Windows']")));
        Assert.assertTrue(windowsOperatingSystemCheckboxActiveStatus.isDisplayed(), "Checkbox \"Windows\" не активирован");

        List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
        WebElement foundGame = null;
        WebElement currentGame = null;

        for (WebElement game : allGames) {
            currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
            if (currentGame.getText().startsWith(observedGame)) {
                foundGame = game;
                break;
            }
        }

        if (foundGame != null) {
            WebElement gamePrice = foundGame.findElement(By.xpath(".//div[contains(@class, 'discount_final_price')]"));
            String expectedGameTitle = "HITMAN™ Essential Collection";
            String expectedCurrentGamePrice = "548,80 pуб.";

            SoftAssert checkingGameParameters = new SoftAssert();
            checkingGameParameters.assertEquals(currentGame.getText(), expectedGameTitle, "Текущий заголовок игры не соответствует ожидаемому значению");
            checkingGameParameters.assertTrue(gamePrice.getText().contains(expectedCurrentGamePrice), "Полученная цена игры не соответствует ожидаемому значению");
            checkingGameParameters.assertAll();
        } else {
            Assert.fail("Игра с названием " + observedGame + " не найдена");
        }
    }

    private void clickByJs(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }
}
