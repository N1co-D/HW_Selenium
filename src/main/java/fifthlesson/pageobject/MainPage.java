package fifthlesson.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static fifthlesson.utils.DriverSingleton.MANAGER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Главная страница Steam
 */
public class MainPage {
    private final String categoriesButtonTopMenuDesktop ="//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']";
    private final String cooperativesCategoryButton = "//a[@class = 'popup_menu_item' and text() = 'Кооперативы']";
    private final String mysteriesAndDetectivesCategoryButton = "//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']";
    private final String inputBox = "//input[@id = 'store_nav_search_term']";
    private final String inputBoxConfirm = "//a[@id = 'store_search_link']/img";
//    private final Actions actions = new Actions(Selenide.webdriver().driver().getWebDriver());
//    private final Actions actions = new Actions(MANAGER.getDriver());
    private final int secondsOfWaiting = 10;

//    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    public void categoriesButtonTopMenuDesktopClick() {
        $x(categoriesButtonTopMenuDesktop).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    public void cooperativesCategoryButtonClick() {
        $x(cooperativesCategoryButton).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    public void mysteriesAndDetectivesCategoryButtonClick() {
        $x(mysteriesAndDetectivesCategoryButton).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    public void inputBoxWriteText(String text) {
        $x(inputBox).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
        $x(inputBox).sendKeys(text);
//        actions.sendKeys(text).perform();
    }

    public void inputBoxConfirmClick() {
        $x(inputBoxConfirm).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }
}
