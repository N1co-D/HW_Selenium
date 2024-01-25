import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://store.steampowered.com/?l=russian");

        WebElement element = driver.findElement(By.id("language_pulldown"));

//        driver.findElement(By.id())); // Поиск элемента по идентификатору
//        driver.findElement(By.tagName()); // Поиск элемента по имени тега
//        driver.findElement(By.name()); // Поиск элемента по имени
//        driver.findElement(By.className()); // Поиск элемента по имени класса
//        driver.findElement(By.linkText()); // Поиск элемента по тексту ссылки
//        driver.findElement(By.xpath()); // Поиск элемента по выражению
//        driver.findElement(By.cssSelector()); // Поиск элемента с использованием CSS Selector
//        driver.findElement(By.partialLinkText()); // Поиск элемента по частичному совпадению текста гиперссылки

        element.click(); // Активация кнопки (нажатие)
//      element.findElement(); // Поиск первого элемента согласно указанному параметру
//      element.findElements(); // Поиск всех элементов согласно указанному параметру
//      element.clear(); // Очищение (если элемент - текстовое поле)
//      ?? System.out.println("element.getAccessibleName() = " + element.getAccessibleName()); // Получение значение атрибута "AccessibleName" у элемента
//      ?? System.out.println("element.getAriaRole() = " + element.getAriaRole()); // Получение значение атрибута "aria-role" у элемента
        element.getAttribute("name"); // Получение указанного атрибута
        element.getCssValue("color"); // Получение указанного свойства CSS элемента
//      ?? element.getDomProperty(); // Получение значения заданного свойства элемента
        System.out.println("element.getLocation() = " + element.getLocation()); // Получение координат элемента
        System.out.println("element.getRect() = " + element.getRect()); // Получение объекта с информацией о размерах и положении элемента на странице
//      ?? element.getShadowRoot(); // Возвращение представления теневого корня элемента для доступа к теневой модели DOM веб-компонента
        System.out.println("element.getSize() = " + element.getSize()); // Получение размеров элемента (ширина и высота)
        System.out.println("element.getTagName() = " + element.getTagName()); // Получение имя тега HTML элемента
        System.out.println("element.getText() = " + element.getText()); // Получение текста, отображаемого на элементе
        System.out.println("element.isDisplayed() = " + element.isDisplayed()); // Возвращает true, если элемент отображается на странице, и false, если скрыт
        System.out.println("element.isEnabled() = " + element.isEnabled()); // Возвращает true, если элемент доступен для взаимодействия, и false, если заблокирован.
        System.out.println("element.isSelected() = " + element.isSelected()); // Возвращает true, если элемент является выбранным (например, чекбокс), и false, если нет.

    }
}