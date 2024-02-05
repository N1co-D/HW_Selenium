package fifthlesson;

public class CodeStyleNotes {
    public static void main(String[] args) {
        /*
        JAVA CODE STYLE:

        1. Соглашения по именованию
        а) Имена классов
            Используйте CamelCase для имен классов. Начинайте имена классов с заглавной буквы.
            Пример:

            public class MyClassName {
                // ...
            }

        б) Имена методов
            Используйте camelCase для имен методов. Выбирайте описательные имена, передающие назначение метода. Начинайте имена методов с прописной буквы.
            Пример:

            public void calculateTotalPrice() {
                // ...
            }

        в) Имена переменных
            Используйте camelCase для имен переменных. Будьте описательными и используйте значимые имена для переменных.
            Начинайте имена переменных с прописной буквы. Избегайте использования однобуквенных имен переменных (за исключением счетчиков циклов).
            Пример:

            int itemCount;
            String customerName;

        г) Имена констант
            Используйте заглавные буквы и подчеркивания для констант. Объявляйте константы с ключевым словом final.
            Разделяйте слова в именах констант подчеркиваниями.
            Пример:

            public static final int MAX_VALUE = 100;

        д) Имена пакетов
            Используйте строчные буквы для имен пакетов. Используйте обратную доменную нотацию для именования пакетов (например, com.example.myapp).


        2. Форматирование кода
        а) Отступы
            Используйте 4 пробела для отступов (без табуляции). Сохраняйте однородный отступ во всем коде.
            Пример:

            public void exampleMethod() {
                if (condition) {
                    // Отступ согласован
                    doSomething();
                } else {
                    doSomethingElse();
                }
            }

        б) Фигурные скобки
            Используйте стиль "Кернигана и Ритчи" для фигурных скобок. Размещайте открывающие фигурные скобки { на той же строке, что и объявление.
            Пример:

            public void exampleMethod() {
                if (condition) {
                    doSomething();
                } else {
                    doSomethingElse();
                }
            }

        в) Длина строки
            Ограничивайте строки от 80 до 120 символов для улучшения читаемости. Разбивайте длинные строки на несколько строк при необходимости.
            Пример:

            public void exampleMethod(String parameter1, String parameter2, String parameter3,
                                      String parameter4, String parameter5) {
                // ...
            }


        3. Комментирование и документирование
            а) Комментарии
            Используйте комментарии сдержанно, сосредотачиваясь на объяснении сложной логики или неочевидных решений.
            Пишите четкие и краткие комментарии. Избегайте комментирования очевидного.
            Пример:

            // Вычислить общую стоимость
            public double calculateTotalPrice() {
                // ...
            }

        б) Javadoc
            Используйте комментарии Javadoc для документирования классов, методов и полей.
            Включите информацию о назначении, параметрах, возвращаемых значениях и исключениях (если применимо) для методов.
            Пример:

        /**
         * Это комментарий Javadoc для класса MyClass.
         /*
                public class MyClass {

                    /**
                     * Вычисляет общую стоимость.
                     *
                     * @param quantity Количество товаров.
                     * @param price Цена за единицу товара.
                     * @return Общая стоимость.
                     * /
                    public double calculateTotalPrice(int quantity, double price) {
                        // ...
                    }
                }


        4. Организация кода
        а) Импорты
            Организуйте импорты и используйте отдельные строки для различных групп импортов (стандартные, специфичные для проекта, сторонние).
            Избегайте использования импортов с подстановочными символами (import java.util.*); явно импортируйте только необходимые классы.
            Пример:

            import java.util.List;
            import java.util.ArrayList;
            import com.example.myapp.MyClass;

        б) Структура класса
            Сохраняйте последовательную структуру класса: объявление пакета, импорты, объявление класса, поля, конструкторы, методы.
            Группируйте связанные поля и методы вместе.
            Пример:

            package com.example.myapp;

            import java.util.List;
                    public class MyClass {
                        // Поля

                        // Конструкторы

                        // Методы
                    }


        Правила создания МР-ов:
        1. Создаем задачу в JIra
        2. Создаем ветку от master-а
        3. Называем ветку: JIRA-123213_название_теста
        4. Пишем тест и доп классы создаем в отдельном пакете с названием hw и номер, например “hw2” (внутри пакета ru.buttonone)
                                     ❗ проверяем, что на данной ветке все работает ❗
        5. Добавляем файлы и пушим на сервер в новую ветку
        6. Создаем мердж реквест
        7. Кидаем ссылку в чат и ждем апрува
        8. После внесения исправлений обязательно проверяем, что все исправления действительно сделаны (не торопимся, аккуратно все проверяем)
        9. После апрува принимаем merge и удаляем ветку глобально
        10. Переключаемся на мастер (удаляем локально свою ветку) и делаем git -> update project
         */
    }
}
