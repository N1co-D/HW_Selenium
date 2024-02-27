package sixthlesson.pageobject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница Steam
 */
public class MainPage {
    private final String categoriesButtonTopMenuDesktop = "//div//span//a[@class = 'pulldown_desktop' and text() = 'Категории']";
    private final String cooperativesCategoryButton = "//a[@class = 'popup_menu_item' and text() = 'Кооперативы']";
    private final String mysteriesAndDetectivesCategoryButton = "//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']";
    private final String inputBox = "//input[@id = 'store_nav_search_term']";
    private final String inputBoxConfirm = "//a[@id = 'store_search_link']/img";
    private final int secondsOfWaiting = 10;

    public MainPage categoriesButtonTopMenuDesktopClick() {
        $x(categoriesButtonTopMenuDesktop).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
        return this;
    }

    public void cooperativesCategoryButtonClick() {
        $x(cooperativesCategoryButton).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    public void mysteriesAndDetectivesCategoryButtonClick() {
        $x(mysteriesAndDetectivesCategoryButton).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    private void inputBoxWriteText(String text) {
        $x(inputBox).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
        $x(inputBox).sendKeys(text);
    }

    private void inputBoxConfirmClick() {
        $x(inputBoxConfirm).should(visible, Duration.ofSeconds(secondsOfWaiting)).click();
    }

    public void SearchGameByInputBox(String text) {
        inputBoxWriteText(text);
        inputBoxConfirmClick();
    }
}
