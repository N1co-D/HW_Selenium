package fourthlesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ActionsClassNotes {
    public static void main(String[] args) {

        /*

        build():                                                        Метод создает и возвращает действие (Action), которое можно использовать для построения последовательности действий.
        click():                                                        Выполняет клик левой кнопкой мыши в текущей позиции указателя.
        click(WebElement target):                                       Выполняет клик левой кнопкой мыши по указанному элементу.
        clickAndHold():                                                 Нажимает и удерживает левую кнопку мыши.
        clickAndHold(WebElement target):                                Нажимает и удерживает левую кнопку мыши на указанном элементе.
        contextClick():                                                 Выполняет контекстное (правой кнопкой мыши) меню в текущей позиции указателя.
        contextClick(WebElement target):                                Выполняет контекстное меню для указанного элемента.
        doubleClick():                                                  Выполняет двойной клик левой кнопкой мыши в текущей позиции указателя.
        doubleClick(WebElement target):                                 Выполняет двойной клик левой кнопкой мыши по указанному элементу.
        dragAndDrop(WebElement source, WebElement target):              Выполняет перетаскивание элемента от источника к цели.
        dragAndDropBy(WebElement source, int xOffset, int yOffset):     Перетаскивает элемент на указанный сдвиг по осям X и Y.
        getActiveKeyboard():                                            Возвращает текущий активный объект клавиатуры.
        getActivePointer():                                             Возвращает текущий активный указатель.
        getActiveWheel():                                               Возвращает текущий активный объект колеса.
        getSequences():                                                 Возвращает последовательности действий, добавленные в действие Actions.
        keyDown(CharSequence key):                                      Нажимает клавишу на клавиатуре.
        keyDown(WebElement target, CharSequence key):                   Нажимает клавишу на клавиатуре с фокусом на указанный элемент.
        keyUp(CharSequence key):                                        Отпускает клавишу на клавиатуре.
        keyUp(WebElement target, CharSequence key):                     Отпускает клавишу на клавиатуре с фокусом на указанный элемент.
        moveByOffset(int xOffset, int yOffset):                         Перемещает указатель относительно текущей позиции.
        moveToElement(WebElement target):                               Перемещает указатель к центру указанного элемента.
        moveToElement(WebElement target, int xOffset, int yOffset):     Перемещает указатель к указанному элементу с заданным смещением.
        moveToLocation(int xCoordinate, int yCoordinate):               Перемещает указатель в абсолютные координаты на экране.
        pause(long pause):                                              Делает паузу в миллисекундах.
        pause(Duration duration):                                       Делает паузу в соответствии с заданной длительностью.
        perform():                                                      Выполняет все добавленные в Actions действия.
        release():                                                      Отпускает текущее удерживание клавиши или мыши.
        release(WebElement target):                                     Отпускает удерживание клавиши или мыши на указанном элементе.
        scrollByAmount(int deltaX, int deltaY):                         Прокручивает страницу на указанное количество пикселей.
        scrollFromOrigin(WheelInput.ScrollOrigin scrollOrigin,          Прокручивает страницу относительно указанного источника.
                                         int deltaX, int deltaY):
        scrollToElement(WebElement element):                            Прокручивает страницу так, чтобы элемент был видимым.
        sendKeys(CharSequence... keys):                                 Отправляет последовательность клавиш.
        sendKeys(WebElement target, CharSequence... keys):              Отправляет последовательность клавиш с фокусом на указанный элемент.
        setActiveKeyboard(String name):                                 Устанавливает активную клавиатуру по имени.
        setActivePointer(PointerInput.Kind kind, String name):          Устанавливает активный указатель по имени и виду.
        setActiveWheel(String name):                                    Устанавливает активное колесо по имени.
        tick(Interaction... actions):                                   Выполняет действия в заданной последовательности (в том числе созданные через Sequence.Builder).

         */

        File file = new File("src/main/resources/config.properties");
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/?l=russian");

        Actions actions = new Actions(driver);

        // build(): Метод создает и возвращает действие (Action), которое можно использовать для построения последовательности действий.
        actions.build();

        // click(): Выполняет клик левой кнопкой мыши в текущей позиции указателя.
        actions.click().perform();

        // click(WebElement target): Выполняет клик левой кнопкой мыши по указанному элементу.
        WebElement button = driver.findElement(By.tagName("button"));
        actions.click(button).perform();

        // clickAndHold(): Нажимает и удерживает левую кнопку мыши.
        actions.clickAndHold().perform();

        // clickAndHold(WebElement target): Нажимает и удерживает левую кнопку мыши на указанном элементе.
        actions.clickAndHold(button).perform();

        // contextClick(): Выполняет контекстное (правой кнопкой мыши) меню в текущей позиции указателя.
        actions.contextClick().perform();

        // contextClick(WebElement target): Выполняет контекстное меню для указанного элемента.
        actions.contextClick(button).perform();

        // doubleClick(): Выполняет двойной клик левой кнопкой мыши в текущей позиции указателя.
        actions.doubleClick().perform();

        // doubleClick(WebElement target): Выполняет двойной клик левой кнопкой мыши по указанному элементу.
        actions.doubleClick(button).perform();

        // dragAndDrop(WebElement source, WebElement target): Выполняет перетаскивание элемента от источника к цели.
        WebElement sourceElement = driver.findElement(By.id("source"));
        WebElement targetElement = driver.findElement(By.id("target"));
        actions.dragAndDrop(sourceElement, targetElement).perform();

        // dragAndDropBy(WebElement source, int xOffset, int yOffset): Перетаскивает элемент на указанный сдвиг по осям X и Y.
        actions.dragAndDropBy(sourceElement, 100, 50).perform();

        // getActiveKeyboard(): Возвращает текущий активный объект клавиатуры.
        actions.getActiveKeyboard();

        // getActivePointer(): Возвращает текущий активный указатель.
        actions.getActivePointer();

        // getActiveWheel(): Возвращает текущий активный объект колеса.
        actions.getActiveWheel();

        // keyDown(CharSequence key): Нажимает клавишу на клавиатуре.
        actions.keyDown("Shift").perform();

        // keyDown(WebElement target, CharSequence key): Нажимает клавишу на клавиатуре с фокусом на указанный элемент.
        actions.keyDown(button, "Ctrl").perform();

        // keyUp(CharSequence key): Отпускает клавишу на клавиатуре.
        actions.keyUp("Shift").perform();

        // keyUp(WebElement target, CharSequence key): Отпускает клавишу на клавиатуре с фокусом на указанный элемент.
        actions.keyUp(button, "Ctrl").perform();

        // moveByOffset(int xOffset, int yOffset): Перемещает указатель относительно текущей позиции.
        actions.moveByOffset(50, 30).perform();

        // moveToElement(WebElement target): Перемещает указатель к центру указанного элемента.
        actions.moveToElement(button).perform();

        // moveToElement(WebElement target, int xOffset, int yOffset): Перемещает указатель к указанному элементу с заданным смещением.
        actions.moveToElement(button, 10, 10).perform();

        // pause(long pause): Делает паузу в миллисекундах.
        actions.pause(1000).perform();

        // pause(Duration duration): Делает паузу в соответствии с заданной длительностью.
        actions.pause(Duration.ofSeconds(2)).perform();

        // perform(): Выполняет все добавленные в Actions действия.
        actions.perform();

        // release(): Отпускает текущее удерживание клавиши или мыши.
        actions.release().perform();

        // release(WebElement target): Отпускает удерживание клавиши или мыши на указанном элементе.
        actions.release(button).perform();

        // scrollByAmount(int deltaX, int deltaY): Прокручивает страницу на указанное количество пикселей.
        actions.scrollByAmount(0, 500).perform();

        // scrollToElement(WebElement element): Прокручивает страницу так, чтобы элемент был видимым.
        actions.scrollToElement(button).perform();

        // sendKeys(CharSequence... keys): Отправляет последовательность клавиш.
        actions.sendKeys("Hello").perform();

        // sendKeys(WebElement target, CharSequence... keys): Отправляет последовательность клавиш с фокусом на указанный элемент.
        actions.sendKeys(button, "World").perform();

        // setActiveKeyboard(String name): Устанавливает активную клавиатуру по имени.
        actions.setActiveKeyboard("qwerty");

        // setActivePointer(PointerInput.Kind kind, String name): Устанавливает активный указатель по имени и виду.
        actions.setActivePointer(PointerInput.Kind.MOUSE, "mouse");

        // setActiveWheel(String name): Устанавливает активное колесо по имени.
        actions.setActiveWheel("scroll_wheel");

    }

}
