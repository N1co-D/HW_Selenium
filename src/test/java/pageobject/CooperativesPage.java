package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

/**
 * Страница "Кооперативы" на сайте Steam
 */
public class CooperativesPage {
    private static By witTheHighestRatingParameterButton = By.xpath("//div[text() = 'С наивысшим рейтингом']");
    private static By casualGameParameter = By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Казуальная игра']");
    private static By playersParameter = By.xpath("//div[contains(@class, 'FacetTitle') and text() = 'Игроки']");
    private static By fieldWithSearchResults = By.xpath("//div[contains(@class, 'FacetedBrowseMatchCount') and contains(text(), 'Совпадений:')]");
    private static By cooperativeParameter = By.xpath("//a[contains(@class, 'FacetValueName') and text() = 'Кооператив']");
    private static By firstGameWithFilterParameters = By.xpath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetHalfLeft')]/a");

    public static By getFirstGameWithFilterParameters() {
        return firstGameWithFilterParameters;
    }

    public static By getWitTheHighestRatingParameterButton() {
        return witTheHighestRatingParameterButton;
    }

    public static By getCasualGameParameter() {
        return casualGameParameter;
    }

    public static By getPlayersParameter() {
        return playersParameter;
    }

    public static By getFieldWithSearchResults() {
        return fieldWithSearchResults;
    }

    public static By getCooperativeParameter() {
        return cooperativeParameter;
    }

    public static WebElement getWebElement(By xpath) {
        return Driver.getDriver().findElement(xpath);
    }

    public static void clickByJs(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click()", webElement);
    }
}
