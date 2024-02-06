package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public enum DriverSingleton {
    DRIVER;

    //    private static WebDriver driver;
    private WebDriver driver;

    private DriverSingleton() {
        driver = WebDriverManager.getInstance("chrome").create();
    }

    public WebDriver getDriver() {
        return driver;
    }

    //    public static WebDriver getDriver() {
//        if (driver == null) {
//            File file = new File("src/main/resources/config.properties");
//            Properties props = new Properties();
//
//            try {
//                props.load(new FileInputStream(file));
//            } catch (IOException e) {
//                System.err.println("Ошибка при загрузке файла!");
//                throw new RuntimeException(e);
//            }
//
//            if (props.getProperty("browser").equals("chrome")) {
//                System.out.println("Определен браузер: Google Chrome");
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            } else if (props.getProperty("browser").equals("firefox")) {
//                System.out.println("Определен браузер: Mozilla Firefox");
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            } else if (props.getProperty("browser").equals("edge")) {
//                System.out.println("Определен браузер: Microsoft Edge");
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//            } else {
//                System.err.println("Браузер не определен");
//            }
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        }
//        return driver;
//    }
}
