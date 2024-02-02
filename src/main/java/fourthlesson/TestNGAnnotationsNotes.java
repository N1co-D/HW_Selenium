package fourthlesson;

public class TestNGAnnotationsNotes {

    public static void main(String[] args) {
        /*
        @Test:          Определяет, что метод является тестовым методом.
        @BeforeSuite:   Обозначает метод, который будет выполняться перед запуском всех тестов внутри тестового набора.
        @AfterSuite:    Обозначает метод, который будет выполняться после выполнения всех тестов внутри тестового набора.
        @BeforeTest:    Обозначает метод, который будет выполняться перед запуском всех тестов внутри текущего <test> тега.
        @AfterTest:     Обозначает метод, который будет выполняться после выполнения всех тестов внутри текущего <test> тега.
        @BeforeClass:   Обозначает метод, который будет выполняться перед выполнением всех тестов внутри текущего класса.
        @AfterClass:    Обозначает метод, который будет выполняться после выполнения всех тестов внутри текущего класса.
        @BeforeGroups:  Обозначает метод, который будет выполняться перед выполнением всех тестов внутри указанных групп.
        @AfterGroups:   Обозначает метод, который будет выполняться после выполнения всех тестов внутри указанных групп.
        @BeforeMethod:  Обозначает метод, который будет выполняться перед каждым тестовым методом.
        @AfterMethod:   Обозначает метод, который будет выполняться после каждого тестового метода.
        @DataProvider:  Обозначает метод, который предоставляет данные для тестовых методов.
        @Parameters:    Обозначает, что метод принимает параметры из файла suite XML.
        @Factory:       Позволяет создавать экземпляры тестового класса с различными наборами данных.
        @Listeners:     Позволяет подключать слушателей для отслеживания событий во время выполнения тестов.
        @TestInstance:  Указывает на то, каким образом TestNG должен создавать экземпляры тестового класса.


        @BeforeSuite
        public void setUpBeforeSuite() {
            // Код, выполняющийся перед запуском всех тестов внутри тестового набора
        }

        @AfterSuite
        public void tearDownAfterSuite() {
            // Код, выполняющийся после выполнения всех тестов внутри тестового набора
        }

        @BeforeTest
        public void setUpBeforeTest() {
            // Код, выполняющийся перед запуском всех тестов внутри текущего <test> тега
        }

        @AfterTest
        public void tearDownAfterTest() {
            // Код, выполняющийся после выполнения всех тестов внутри текущего <test> тега
        }

        @BeforeClass
        public void setUpBeforeClass() {
            // Код, выполняющийся перед выполнением всех тестов внутри текущего класса
        }

        @AfterClass
        public void tearDownAfterClass() {
            // Код, выполняющийся после выполнения всех тестов внутри текущего класса
        }

        @BeforeGroups("group1")
        public void setUpBeforeGroups() {
            // Код, выполняющийся перед выполнением всех тестов внутри указанных групп
        }

        @AfterGroups("group1")
        public void tearDownAfterGroups() {
            // Код, выполняющийся после выполнения всех тестов внутри указанных групп
        }

        @BeforeMethod
        public void setUpBeforeMethod() {
            // Код, выполняющийся перед каждым тестовым методом
        }

        @AfterMethod
        public void tearDownAfterMethod() {
            // Код, выполняющийся после каждого тестового метода
        }

        @Test
        public void exampleTest() {
            // Код тестового метода
        }

        @DataProvider(name = "data-provider")
        public Object[][] dataProviderMethod() {
            // Код, предоставляющий данные для тестовых методов
        }

        @Parameters({"param1", "param2"})
        @Test
        public void testWithParameters(String param1, String param2) {
            // Код тестового метода, принимающего параметры из файла suite XML
        }

        @Factory
        public Object[] factoryMethod() {
            // Код, создающий экземпляры тестового класса с различными наборами данных
        }

        @Listeners(CustomListener.class)
        public class ExampleTestWithListeners {
            // Код класса, подключающего слушателя для отслеживания событий во время выполнения тестов
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        public class ExampleTestWithTestInstance {
            // Код класса, указывающего, как TestNG должен создавать экземпляры тестового класса
        }

         */
    }
}