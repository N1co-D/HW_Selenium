package firstlesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class HW2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        ChromeOptions options1 = new ChromeOptions();
        ChromeOptions options2 = new ChromeOptions();

        options.addArguments("start-maximized", "incognito"); // Добавляет дополнительные аргументы (параметры) запуска браузера

        options1.addArguments("start-maximized");
        options2.addArguments("incognito");

        options.addExtensions(new File(("C:\\Users\\dmark\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gkojfkhlekighikafcpjkiklfbnlmeio\\1.219.646_0.crx"))); // Добавляет расширение (плагин) к браузеру

//      options.setExperimentalOption("download.default.directory", "C:\\Users\\dmark\\Desktop\\internship\\selenium\\new Downloads"); // Устанавливает экспериментальные опции для браузера (например, настройка каталога для скачивания)

//      options.addEncodedExtensions(); // Добавляет закодированные расширения (плагины) к браузеру

        options.asMap(); // Возвращает карту (Map), представляющую текущие опции

        System.out.println("options.getBrowserName() = " + options.getBrowserName()); // Возвращает имя браузера
        System.out.println("options.getBrowserVersion() = " + options.getBrowserVersion()); // Возвращает версию браузера
//      System.out.println("options.getCapability() = " + options.getCapability()); // Возвращает значение указанной возможности
        System.out.println("options.getCapabilityNames() = " + options.getCapabilityNames()); // Возвращает названия всех возможностей
        System.out.println("options.getPlatformName() = " + options.getPlatformName()); // Возвращает имя платформы

        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("https://www.youtube.com/");

        WebDriver driver2 = new ChromeDriver(options1.merge(options2)); // Комбинирует настройки из разных наборов параметров (merge)
        driver2.get("https://store.steampowered.com/?l=russian");

        driver1.quit();
        driver2.quit();

    }
}
