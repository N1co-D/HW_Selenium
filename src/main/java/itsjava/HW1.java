package itsjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new ChromeDriver();

        driver1.get("https://button-one.ru/"); // открытие ссылки в окне браузера
        driver2.get("https://store.steampowered.com/?l=russian");

        System.out.println("driver1.getWindowHandle() = " + driver1.getWindowHandle()); // Получение идентификатора открытого окна браузера
        System.out.println("driver2.getWindowHandle() = " + driver2.getWindowHandle());

        System.out.println();
        System.out.println("driver1.getWindowHandles() = " + driver1.getWindowHandles()); // Получение идентификаторов всех открытых окон браузера
        System.out.println("driver2.getWindowHandles() = " + driver2.getWindowHandles());

        driver1.manage(); // Возвращает объект Options, который предоставляет доступ к различным настройкам браузера:
//                           размер окна браузера, управление куками и т.д.

        System.out.println();
        System.out.println("driver2.findElement(By.id(\"language_pulldown\")) = " + driver2.findElement(By.id("language_pulldown"))); // Получение ссылки элемента
        System.out.println("driver2.findElements(By.className(\"menuitem supernav\")) = " + driver2.findElements(By.tagName("link"))); // Получение идентификатора открытого окна браузера

        System.out.println();
        System.out.println("driver1.getCurrentUrl() = " + driver1.getCurrentUrl()); // Получение текущего URL страницы
        System.out.println("driver2.getCurrentUrl() = " + driver2.getCurrentUrl());

//      System.out.println("driver1.getPageSource() = " + driver1.getPageSource()); // Получение исходного кода страницы

        System.out.println();
        System.out.println("driver1.getTitle() = " + driver1.getTitle()); // Получение заголовка страницы
        System.out.println("driver2.getTitle() = " + driver2.getTitle());

        driver2.navigate().to("https://www.youtube.com/"); // Переход на страницу по указанному URL

//      driver1.switchTo().window(driver2.getWindowHandle()); // Переключение на другое окно или на другой элемент внутри страницы

        driver1.quit(); // Завершение всего сеанса (закрытие всех вкладок в окне)
        driver2.close(); // Закрытие текущей страницы (прочие вкладки в окне остаются открытыми)
    }
}
