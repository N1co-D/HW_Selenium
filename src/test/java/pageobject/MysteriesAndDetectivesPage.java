//package pageobject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import utils.DriverSingleton;
//
///**
// * Страница "Тайны и детективы" в Steam
// */
//public class MysteriesAndDetectivesPage {
//    private static By salesLeadersParameterButton = By.xpath("//div[text() = 'Лидеры продаж']");
//    private static By showMoreButton = By.xpath("//div[contains(@class, 'FacetValueShowMore') and text() = 'Показать больше']");
//    private static By fieldWithSearchResults = By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]");
//    private static By strategyParameter = By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Стратегия']");
//    private static By playersParameter = By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']");
//    private static By forMultiplePlayersParameter = By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Для нескольких игроков']");
//
//    private static By firstGameWithFilterParameters = By.xpath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a");
//
//
//    public static By getFirstGameWithFilterParameters() {
//        return firstGameWithFilterParameters;
//    }
//
//    public static By getSalesLeadersParameterButton() {
//        return salesLeadersParameterButton;
//    }
//
//    public static By getShowMoreButton() {
//        return showMoreButton;
//    }
//
//    public static By getFieldWithSearchResults() {
//        return fieldWithSearchResults;
//    }
//
//    public static By getStrategyParameter() {
//        return strategyParameter;
//    }
//
//    public static By getPlayersParameter() {
//        return playersParameter;
//    }
//
//    public static By getForMultiplePlayersParameter() {
//        return forMultiplePlayersParameter;
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
