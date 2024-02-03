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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Элемент по указанному XPath не найден.");
        categoriesButtonTopMenuDesktop.click();

        WebElement cooperativesCategoryButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Кооперативы']")));
        Assert.assertTrue(cooperativesCategoryButton.isDisplayed(), "Элемент по указанному XPath не найден.");
        cooperativesCategoryButton.click();
        actions.scrollByAmount(0, 1850).perform();

        WebElement witTheHighestRatingParameterButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FlavorLabel_Dhg57') and text() = 'С наивысшим рейтингом']")));
        Assert.assertTrue(witTheHighestRatingParameterButton.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(witTheHighestRatingParameterButton);
        actions.moveToElement(witTheHighestRatingParameterButton);
        jsExecutor.executeScript("arguments[0].click()", witTheHighestRatingParameterButton);
        actions.moveToElement(witTheHighestRatingParameterButton);

        WebElement casualGameParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Казуальная игра']")));
        Assert.assertTrue(casualGameParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(casualGameParameter);
        actions.moveToElement(casualGameParameter);
        jsExecutor.executeScript("arguments[0].click()", casualGameParameter);

        WebElement playersParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']")));
        Assert.assertTrue(playersParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(playersParameter);
        actions.moveToElement(playersParameter);
        jsExecutor.executeScript("arguments[0].click()", playersParameter);

        WebElement results = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsText = results.getText();

        WebElement cooperativeParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Кооператив']")));
        Assert.assertTrue(cooperativeParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(cooperativeParameter);
        actions.moveToElement(cooperativeParameter);
        jsExecutor.executeScript("arguments[0].click()", cooperativeParameter);
        actions.moveToElement(witTheHighestRatingParameterButton);

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        if (!resultsText.equals(resultsTextForComparing)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_NO-IP')]/div[1]//div[@class = 'salepreviewwidgets_StoreSaleWidgetHalfLeft_2Va3O']/a"))));
            Assert.assertTrue(firstGameWithFilterParameters.isDisplayed(), "Элемент по указанному XPath не найден.");
            actions.scrollToElement(firstGameWithFilterParameters);
            actions.moveToElement(firstGameWithFilterParameters);
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
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement categoriesButtonTopMenuDesktop = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Элемент по указанному XPath не найден.");
        categoriesButtonTopMenuDesktop.click();

        WebElement mysteriesAndDetectivesCategoryButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']")));
        Assert.assertTrue(mysteriesAndDetectivesCategoryButton.isDisplayed(), "Элемент по указанному XPath не найден.");
        mysteriesAndDetectivesCategoryButton.click();
        actions.scrollByAmount(0, 1850).perform();

        WebElement salesLeadersParameterButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FlavorLabel_Dhg57') and text() = 'Лидеры продаж']")));
        Assert.assertTrue(salesLeadersParameterButton.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(salesLeadersParameterButton);
        actions.moveToElement(salesLeadersParameterButton);
        jsExecutor.executeScript("arguments[0].click()", salesLeadersParameterButton);
        actions.moveToElement(salesLeadersParameterButton);

        WebElement showMoreButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']")));
        Assert.assertTrue(showMoreButton.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(showMoreButton);
        actions.moveToElement(showMoreButton);
        jsExecutor.executeScript("arguments[0].click()", showMoreButton);

        WebElement results = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsText = results.getText();

        WebElement strategyParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Стратегия']")));
        Assert.assertTrue(strategyParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(strategyParameter);
        actions.moveToElement(strategyParameter);
        jsExecutor.executeScript("arguments[0].click()", strategyParameter);

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        WebElement playersParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']")));
        Assert.assertTrue(playersParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(playersParameter);
        actions.moveToElement(playersParameter);
        jsExecutor.executeScript("arguments[0].click()", playersParameter);

        WebElement forMultiplePlayersParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']")));
        Assert.assertTrue(forMultiplePlayersParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        actions.scrollToElement(forMultiplePlayersParameter);
        actions.moveToElement(forMultiplePlayersParameter);
        jsExecutor.executeScript("arguments[0].click()", forMultiplePlayersParameter);
        actions.moveToElement(forMultiplePlayersParameter);

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]"), resultsTextForComparing))));
        WebElement resultsForComparing2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]")));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            WebElement firstGameWithFilterParameters = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_NO-IP')]/div[1]//div[@class = 'salepreviewwidgets_StoreSaleWidgetHalfLeft_2Va3O']/a"))));
            Assert.assertTrue(firstGameWithFilterParameters.isDisplayed(), "Элемент по указанному XPath не найден.");
            actions.scrollToElement(firstGameWithFilterParameters);
            actions.moveToElement(firstGameWithFilterParameters);
            String gameLink = firstGameWithFilterParameters.getAttribute("href");
            driver.get(gameLink);
        }
        Assert.assertEquals(driver.getTitle(), "SpyParty в Steam", "Указан заголовок некорректной игры");
    }

    @Test(priority = 3)
    public void checkingSortingByReleaseDateOfGame() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement inputBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        Assert.assertTrue(inputBox.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", inputBox);
        actions.sendKeys(inputBox, "Oxygen Not Included").perform();

        WebElement inputBoxConfirm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        Assert.assertTrue(inputBoxConfirm.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'sort_by_trigger']")));
        Assert.assertTrue(sortingParameters.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", sortingParameters);

        WebElement releasingDateParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'inactive_selection' and text() = 'дате выхода']")));
        Assert.assertTrue(releasingDateParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", releasingDateParameter);

        WebElement results = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsText = results.getText();

        WebElement removeFreeGamesCheckbox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']")));
        Assert.assertTrue(removeFreeGamesCheckbox.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", removeFreeGamesCheckbox);

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]"), resultsText))));
        WebElement resultsForComparing = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsTextForComparing = resultsForComparing.getText();

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]"), resultsTextForComparing))));
        WebElement resultsForComparing2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]")));
        String resultsTextForComparing2 = resultsForComparing2.getText();

        String gameLink;
        if (!resultsTextForComparing.equals(resultsTextForComparing2)) {
            List<WebElement> allGames = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
            for (WebElement game : allGames) {
                WebElement currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
                if (currentGame.getText().startsWith("Oxygen Not Included")) {
                    gameLink = game.getAttribute("href");
                    driver.navigate().to(gameLink);
                    break;
                }
            }
        }

        Assert.assertEquals(driver.getTitle(), "Oxygen Not Included - Spaced Out! в Steam", "Указан заголовок некорректной игры");
    }

    @Test(priority = 4)
    public void checkingSortingByReleaseDateAndOtherParameter() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://store.steampowered.com/");
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement inputBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'store_nav_search_term']")));
        Assert.assertTrue(inputBox.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", inputBox);
        actions.sendKeys(inputBox, "The Callisto Protocol").perform();

        WebElement inputBoxConfirm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'store_search_link']/img")));
        Assert.assertTrue(inputBoxConfirm.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", inputBoxConfirm);
        Assert.assertEquals(driver.getTitle(), "Поиск Steam", "Указан заголовок некорректной страницы");

        WebElement sortingParameters = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'sort_by_trigger']")));
        Assert.assertTrue(sortingParameters.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", sortingParameters);

        WebElement priceIncreaseParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'Price_ASC']")));
        Assert.assertTrue(priceIncreaseParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", priceIncreaseParameter);

        WebElement specialOffersCheckbox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']")));
        Assert.assertTrue(specialOffersCheckbox.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", specialOffersCheckbox);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'search_results']/div[contains(text(), 'Результатов по вашему запросу:')]")));

        WebElement windowsOperatingSystemParameter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']")));
        Assert.assertTrue(windowsOperatingSystemParameter.isDisplayed(), "Элемент по указанному XPath не найден.");
        jsExecutor.executeScript("arguments[0].click()", windowsOperatingSystemParameter);

        String gameLink;
        List<WebElement> allGames = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'search_resultsRows']/a")));
        for (WebElement game : allGames) {
            WebElement currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
            if (currentGame.getText().startsWith("The Callisto Protocol")) {
                gameLink = game.getAttribute("href");
                driver.navigate().to(gameLink);
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().contains("The Callisto Protocol™ - The Outer Way Skin"), "Указан заголовок некорректной игры");
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }
}
