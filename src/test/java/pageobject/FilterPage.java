//package pageobject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import utils.DriverSingleton;
//
///**
// * Страница с фильтром в Steam
// */
//public class FilterPage {
//    private static By sortingParameters = By.id("sort_by_trigger");
//    private static By showMoreButton = By.id("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']");
//    private static By releasingDateParameter = By.xpath("//a[@class = 'inactive_selection' and text() = 'дате выхода']");
//    private static By fieldWithSearchResults = By.xpath("//div[@id = 'search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу:')]");
//    private static By fieldWithSearchResultsWhereCountIsNull = By.xpath("//div[@id = 'search_results']/div[contains(text(), 'Результатов по вашему запросу:')]");
//
//    private static By removeFreeGamesCheckbox = By.xpath("//div[@class = 'tab_filter_control_row']//span[@class = 'tab_filter_control_checkbox']");
//    private static By forMultiplePlayersParameter = By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']");
//    private static By priceIncreaseParameter = By.xpath("//a[@id = 'Price_ASC']");
//    private static By specialOffersCheckbox = By.xpath("//span[@data-loc = 'Специальные предложения']//span[@class = 'tab_filter_control_checkbox']");
//    private static By windowsOperatingSystemParameter = By.xpath("//span[@data-loc = 'Windows']//span[@class = 'tab_filter_control_checkbox']");
//    private static By allGames = By.xpath("//div[@id = 'search_resultsRows']/a");
//    private static By currentGame = By.xpath("//div[@id = 'search_resultsRows']/a//span[@class = 'title']");
//    private static By gameReleaseDate = By.xpath("//div[@id = 'search_resultsRows']/a//div[contains(@class, 'search_released')]");
//    private static By gamePrice = By.xpath("//div[@id = 'search_resultsRows']/a//div[@class = 'discount_final_price']");
//
//    public static By getFieldWithSearchResultsWhereCountIsNull() {
//        return fieldWithSearchResultsWhereCountIsNull;
//    }
//
//    public static By getGameReleaseDate() {
//        return gameReleaseDate;
//    }
//
//    public static By getGamePrice() {
//        return gamePrice;
//    }
//
//    public static By getCurrentGame() {
//        return currentGame;
//    }
//
//    public static By getAllGames() {
//        return allGames;
//    }
//
//    public static By getSortingParameters() {
//        return sortingParameters;
//    }
//
//    public static By getShowMoreButton() {
//        return showMoreButton;
//    }
//
//    public static By getReleasingDateParameter() {
//        return releasingDateParameter;
//    }
//
//    public static By getFieldWithSearchResults() {
//        return fieldWithSearchResults;
//    }
//
//    public static By getRemoveFreeGamesCheckbox() {
//        return removeFreeGamesCheckbox;
//    }
//
//    public static By getForMultiplePlayersParameter() {
//        return forMultiplePlayersParameter;
//    }
//
//    public static By getPriceIncreaseParameter() {
//        return priceIncreaseParameter;
//    }
//
//    public static By getSpecialOffersCheckbox() {
//        return specialOffersCheckbox;
//    }
//
//    public static By getWindowsOperatingSystemParameter() {
//        return windowsOperatingSystemParameter;
//    }
//
//    public static WebElement getWebElement(By xpath) {
//        return DriverSingleton.getDriver().findElement(xpath);
//    }
//
//    public static void clickByJs(WebElement webElement) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
//        jsExecutor.executeScript("arguments[0].click()", webElement);
//    }
//}
