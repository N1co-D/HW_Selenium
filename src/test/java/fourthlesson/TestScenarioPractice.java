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

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        categoriesButtonTopMenuDesktop.click();

        WebElement cooperativesCategoryButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']")));
        cooperativesCategoryButton.click();
        actions.scrollByAmount(0, 1850).perform();

        WebElement witTheHighestRatingParameterButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'С наивысшим рейтингом']")));
        clickByJs(witTheHighestRatingParameterButton);

        WebElement casualGameParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Казуальная игра']")));
        clickByJs(casualGameParameter);

        WebElement playersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']")));
        clickByJs(playersParameter);

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement cooperativeParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Кооператив']")));
        clickByJs(cooperativeParameter);

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        if (!resultsText.equals(resultsTextForComparing)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a"))));
            String gameLink = firstGameWithFilterParameters.getAttribute("href");
            driver.get(gameLink);
            Assert.assertEquals(driver.getTitle(), "Garry's Mod в Steam", "Указан заголовок некорректной игры");
        }
    }

    @Test(priority = 2)
    public void checkingCorrectProductDisplayWithFilterParametersMysteriesAndDetectives() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        categoriesButtonTopMenuDesktop.click();

        WebElement mysteriesAndDetectivesCategoryButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']")));
        mysteriesAndDetectivesCategoryButton.click();
        actions.scrollByAmount(0, 1850).perform();

        WebElement salesLeadersParameterButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[text() = 'Лидеры продаж']")));
        clickByJs(salesLeadersParameterButton);

        WebElement showMoreButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']")));
        clickByJs(showMoreButton);

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement strategyParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Стратегия']")));
        clickByJs(strategyParameter);

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        WebElement playersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']")));
        clickByJs(playersParameter);

        WebElement forMultiplePlayersParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']")));
        clickByJs(forMultiplePlayersParameter);

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsTextForComparing))));
        WebElement resultsForComparing2 = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(visibilityOfElementLocated((By.xpath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a"))));
            String gameLink = firstGameWithFilterParameters.getAttribute("href");
            driver.get(gameLink);
            Assert.assertEquals(driver.getTitle(), "West Hunt в Steam", "Указан заголовок некорректной игры");
        }
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);

        WebElement inputBox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        clickByJs(inputBox);
        actions.sendKeys(inputBox, "Oxygen Not Included").perform();

        WebElement inputBoxConfirm = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        clickByJs(inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(visibilityOfElementLocated(By.id("sort_by_trigger")));
        clickByJs(sortingParameters);

        WebElement releasingDateParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@class = 'inactive_selection' and text() = 'дате выхода']")));
        clickByJs(releasingDateParameter);

        WebElement fieldWithSearchResults = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsText = fieldWithSearchResults.getText();

        WebElement removeFreeGamesCheckbox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(removeFreeGamesCheckbox);

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        webDriverWait.until(refreshed(not(textToBe(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]"), resultsTextForComparing))));
        WebElement resultsForComparing2 = webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
            for (WebElement game : allGames) {
                WebElement currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
                if (currentGame.getText().startsWith("Oxygen Not Included")) {
                    WebElement gameReleaseDate = game.findElement(By.xpath(".//div[contains(@class, 'search_released')]"));
                    WebElement gamePrice = game.findElement(By.xpath(".//div[@class = 'discount_final_price']"));
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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);

        WebElement inputBox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        clickByJs(inputBox);
        actions.sendKeys(inputBox, "The Callisto Protocol").perform();

        WebElement inputBoxConfirm = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        clickByJs(inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(visibilityOfElementLocated(By.id("sort_by_trigger")));
        clickByJs(sortingParameters);

        WebElement priceIncreaseParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id = 'Price_ASC']")));
        clickByJs(priceIncreaseParameter);

        WebElement specialOffersCheckbox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(specialOffersCheckbox);

        webDriverWait.until(visibilityOfElementLocated(By.xpath("//div[@id = 'search_results']/div[contains(text(), 'Результатов по вашему запросу:')]")));

        WebElement windowsOperatingSystemParameter = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']")));
        clickByJs(windowsOperatingSystemParameter);

        List<WebElement> allGames = webDriverWait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
        for (WebElement game : allGames) {
            WebElement currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
            if (currentGame.getText().startsWith("The Callisto Protocol")) {
                WebElement gameReleaseDate = game.findElement(By.xpath(".//div[contains(@class, 'search_released')]"));
                WebElement gamePrice = game.findElement(By.xpath(".//div[@class = 'discount_final_price']"));
                Assert.assertEquals(currentGame.getText(), "The Callisto Protocol™ - The Outer Way Skin Collection", "Указан заголовок некорректной игры");
                Assert.assertTrue(gameReleaseDate.getText().contains("7 фев. 2023"), "Указана некорректная дата релиза игры");
                Assert.assertEquals(gamePrice.getText(), "200 руб", "Указана некорректная цена игры");
                break;
            }
        }
    }

    public void clickByJs(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }
}
