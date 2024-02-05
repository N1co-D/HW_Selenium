package fifthlesson;

public class ExpectedConditionsNotes {
    public static void main(String[] args) {
        /*
        alertIsPresent()                                                    Возвращает условие ожидания появления всплывающего окна.
        and(ExpectedCondition<?>... conditions)                             Ожидание с логическим условием "и" для списка переданных условий.
        attributeContains(By locator, String attribute, String value)       Проверка, что элемент с указанным локатором содержит атрибут с конкретным значением.
        attributeContains(WebElement element, String attribute,             Проверка, что указанный элемент содержит атрибут с конкретным значением.
                                                        String value)
        attributeToBe(By locator, String attribute, String value)           Проверка, что элемент с указанным локатором имеет атрибут с определенным значением.
        attributeToBe(WebElement element, String attribute,                 Проверка, что указанный элемент имеет атрибут с определенным значением.
                                                    String value)
        attributeToBeNotEmpty(WebElement element, String attribute)         Проверка, что у элемента с указанным локатором есть атрибут с непустым значением.
        domAttributeToBe(WebElement element, String attribute,              Проверка, что указанный элемент имеет атрибут DOM с определенным значением.
                                                        String value)
        domPropertyToBe(WebElement element, String property,                Проверка, что указанный элемент имеет свойство DOM с определенным значением.
                                                    String value)
        elementSelectionStateToBe(By locator, boolean selected)             Проверка, выбран ли указанный элемент.
        elementSelectionStateToBe(WebElement element, boolean selected)     Проверка, выбран ли указанный элемент.
        elementToBeClickable(By locator)                                    Проверка, что элемент видим и доступен для нажатия.
        elementToBeClickable(WebElement element)                            Проверка, что элемент видим и доступен для нажатия.
        elementToBeSelected(By locator)                                     Проверка, выбран ли указанный элемент.
        elementToBeSelected(WebElement element)                             Проверка, выбран ли указанный элемент.
        frameToBeAvailableAndSwitchToIt(int frameLocator)                   Проверка, доступен ли указанный фрейм для переключения.
        frameToBeAvailableAndSwitchToIt(String frameLocator)                Проверка, доступен ли указанный фрейм для переключения.
        frameToBeAvailableAndSwitchToIt(By locator)                         Проверка, доступен ли указанный фрейм для переключения.
        frameToBeAvailableAndSwitchToIt(WebElement frameLocator)            Проверка, доступен ли указанный фрейм для переключения.
        invisibilityOf(WebElement element)                                  Проверка, что элемент невидим.
        invisibilityOfAllElements(List<WebElement> elements)                Проверка, что все элементы из указанного списка невидимы.
        invisibilityOfAllElements(WebElement... elements)                   Проверка, что все элементы из указанного списка невидимы.
        invisibilityOfElementLocated(By locator)                            Проверка, что элемент с указанным локатором невидим или отсутствует в DOM.
        invisibilityOfElementWithText(By locator, String text)              Проверка, что элемент с текстом невидим или отсутствует в DOM.
        javaScriptThrowsNoExceptions(String javaScript)                     Проверка, что JavaScript выполняется без ошибок.
        jsReturnsValue(String javaScript)                                   Получение значения типа String из JavaScript.
        not(ExpectedCondition<?> condition)                                 Ожидание с логическим условием "не" для переданного условия.
        numberOfElementsToBe(By locator, Integer number)                    Проверка, что количество элементов с указанным локатором равно заданному числу.
        numberOfElementsToBeLessThan(By locator, Integer number)            Проверка, что количество элементов с указанным локатором меньше заданного числа.
        numberOfElementsToBeMoreThan(By locator, Integer number)            Проверка, что количество элементов с указанным локатором больше заданного числа.
        numberOfWindowsToBe(int expectedNumberOfWindows)                    Проверка, что количество окон равно заданному числу.
        or(ExpectedCondition<?>... conditions)                              Ожидание с логическим условием "или" для списка переданных условий.
        presenceOfAllElementsLocatedBy(By locator)                          Проверка, что на веб-странице присутствует хотя бы один элемент с указанным локатором.
        presenceOfElementLocated(By locator)                                Проверка, что элемент присутствует в DOM на веб-странице.
        presenceOfNestedElementLocatedBy(By locator, By childLocator)       Проверка, что дочерний элемент с указанным локатором присутствует как часть родительского элемента.
        presenceOfNestedElementLocatedBy(WebElement element,                Проверка, что дочерний элемент с указанным локатором присутствует как часть родительского элемента.
                                                    By childLocator)
        presenceOfNestedElementsLocatedBy(By parent, By childLocator)       Проверка, что дочерний элемент с указанным локатором присутствует как часть родительского элемента.
        refreshed(ExpectedCondition<T> condition)                           Обертка для условия, позволяющая элементам обновляться путем перерисовки.
        stalenessOf(WebElement element)                                     Ожидание, пока элемент больше не будет присоединен к DOM.
        textMatches(By locator, Pattern pattern)                            Проверка, что элемент с указанным локатором содержит текст, соответствующий заданному шаблону.
        textToBe(By locator, String value)                                  Проверка, что элемент с указанным локатором содержит определенный текст.
        textToBePresentInElement(WebElement element, String text)           Проверка, что указанный текст присутствует в указанном элементе.
        textToBePresentInElementLocated(By locator, String text)            Проверка, что указанный текст присутствует в элементе с указанным локатором.
        textToBePresentInElementValue(By locator, String text)              Проверка, что указанный текст присутствует в значении атрибута value указанного элемента.
        textToBePresentInElementValue(WebElement element,                   Проверка, что указанный текст присутствует в значении атрибута value указанного элемента.
                                                    String text)
        titleContains(String title)                                         Проверка, что заголовок содержит указанную подстроку (с учетом регистра).
        titleIs(String title)                                               Проверка, что заголовок страницы совпадает с указанным заголовком.
        urlContains(String fraction)                                        Проверка, что URL текущей страницы содержит указанный текст.
        urlMatches(String regex)                                            Проверка, что URL соответствует указанному регулярному выражению.
        urlToBe(String url)                                                 Проверка, что URL текущей страницы совпадает с указанным URL.
        visibilityOf(WebElement element)                                    Проверка, что элемент, известный как присутствующий в DOM на странице, видим.
        visibilityOfAllElements(List<WebElement> elements)                  Проверка, что все элементы, соответствующие локатору, видимы на веб-странице.
        visibilityOfAllElements(WebElement... elements)                     Проверка, что все элементы, соответствующие локатору, видимы на веб-странице.
        visibilityOfAllElementsLocatedBy(By locator)                        Проверка, что все элементы, соответствующие локатору, видимы на веб-странице.
        visibilityOfElementLocated(By locator)                              Проверка, что элемент присутствует в DOM на странице и видим.
        visibilityOfNestedElementsLocatedBy(By parent, By childLocator)     Проверка, что дочерний элемент, соответствующий локатору, видим как часть родительского элемента.
        visibilityOfNestedElementsLocatedBy(WebElement element,             Проверка, что дочерний элемент, соответствующий локатору, видим как часть родительского элемента.
                                                    By childLocator)


        WebDriverWait wait = new WebDriverWait(driver, 10);

        // 1. alertIsPresent()
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // 2. and(ExpectedCondition<?>... conditions)
        WebElement elementAnd = wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")),
                ExpectedConditions.textToBe(By.id("exampleElement"), "Expected Text")
        ));

        // 3. attributeContains(By locator, String attribute, String value)
        wait.until(ExpectedConditions.attributeContains(By.id("exampleElement"), "class", "expectedClass"));

        // 4. attributeToBe(By locator, String attribute, String value)
        wait.until(ExpectedConditions.attributeToBe(By.id("exampleElement"), "value", "expectedValue"));

        // 5. attributeToBeNotEmpty(WebElement element, String attribute)
        wait.until(ExpectedConditions.attributeToBeNotEmpty(By.id("exampleElement"), "class"));

        // 6. domAttributeToBe(WebElement element, String attribute, String value)
        wait.until(ExpectedConditions.domAttributeToBe(By.id("exampleElement"), "data-example", "expectedValue"));

        // 7. domPropertyToBe(WebElement element, String property, String value)
        wait.until(ExpectedConditions.domPropertyToBe(By.id("exampleElement"), "propertyName", "expectedValue"));

        // 8. elementSelectionStateToBe(By locator, boolean selected)
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("exampleCheckbox"), true));

        // 9. elementToBeClickable(By locator)
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleButton")));

        // 10. elementToBeClickable(WebElement element)
        WebElement clickableElement2 = wait.until(ExpectedConditions.elementToBeClickable(elementAnd));

        // 11. elementToBeSelected(By locator)
        wait.until(ExpectedConditions.elementToBeSelected(By.id("exampleCheckbox")));

        // 12. elementToBeSelected(WebElement element)
        wait.until(ExpectedConditions.elementToBeSelected(elementAnd));

        // 13. frameToBeAvailableAndSwitchToIt(int frameLocator)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        // 14. frameToBeAvailableAndSwitchToIt(String frameLocator)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("exampleFrame"));

        // 15. frameToBeAvailableAndSwitchToIt(By locator)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("exampleFrame")));

        // 16. frameToBeAvailableAndSwitchToIt(WebElement frameLocator)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementAnd));

        // 17. invisibilityOf(WebElement element)
        wait.until(ExpectedConditions.invisibilityOf(elementAnd));

        // 18. invisibilityOfAllElements(List<WebElement> elements)
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementAnd, clickableElement, clickableElement2));

        // 19. invisibilityOfAllElements(WebElement... elements)
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementAnd, clickableElement, clickableElement2));

        // 20. invisibilityOfElementLocated(By locator)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("exampleElement")));

        // 21. invisibilityOfElementWithText(By locator, String text)
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("exampleElement"), "Expected Text"));

        // 22. javaScriptThrowsNoExceptions(String javaScript)
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return true;"));

        // 23. jsReturnsValue(String javaScript)
        String jsResult = wait.until(ExpectedConditions.jsReturnsValue("return document.title;"));

        // 24. not(ExpectedCondition<?> condition)
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id("exampleButton"))));

        // 25. numberOfElementsToBe(By locator, Integer number)
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("exampleClass"), 3));

        // 26. numberOfElementsToBeLessThan(By locator, Integer number)
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("exampleClass"), 5));

        // 27. numberOfElementsToBeMoreThan(By locator, Integer number)
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("exampleClass"), 1));

        // 28. numberOfWindowsToBe(int expectedNumberOfWindows)
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 29. or(ExpectedCondition<?>... conditions)
        WebElement elementOr = wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")),
                ExpectedConditions.textToBe(By.id("exampleElement"), "Expected Text")
        ));

        // 30. presenceOfAllElementsLocatedBy(By locator)
        List<WebElement> allElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("exampleTag")));

        // 31. presenceOfElementLocated(By locator)
        WebElement singleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleElement")));

        // 32. presenceOfNestedElementLocatedBy(By locator, By childLocator)
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("parentElement"), By.id("childElement")));

        // 33. presenceOfNestedElementLocatedBy(WebElement element, By childLocator)
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(elementAnd, By.id("childElement")));

        // 34. presenceOfNestedElementsLocatedBy(By parent, By childLocator)
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("parentElement"), By.className("childClass")));

        // 35. refreshed(ExpectedCondition<T> condition)
        WebElement refreshedElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(singleElement)));

        // 36. stalenessOf(WebElement element)
        wait.until(ExpectedConditions.stalenessOf(elementOr));

        // 37. textMatches(By locator, Pattern pattern)
        wait.until(ExpectedConditions.textMatches(By.id("exampleElement"), Pattern.compile("Expected.*")));

        // 38. textToBe(By locator, String value)
        wait.until(ExpectedConditions.textToBe(By.id("exampleElement"), "Expected Text"));

        // 39. textToBePresentInElement(WebElement element, String text)
        wait.until(ExpectedConditions.textToBePresentInElement(elementAnd, "Expected Text"));

        // 40. textToBePresentInElementLocated(By locator, String text)
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("exampleElement"), "Expected Text"));

        // 41. textToBePresentInElementValue(By locator, String text)
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("exampleElement"), "Expected Value"));

        // 42. textToBePresentInElementValue(WebElement element, String text)
        wait.until(ExpectedConditions.textToBePresentInElementValue(elementAnd, "Expected Value"));

        // 43. titleContains(String title)
        wait.until(ExpectedConditions.titleContains("Expected Title"));

        // 44. titleIs(String title)
        wait.until(ExpectedConditions.titleIs("Expected Title"));

        // 45. urlContains(String fraction)
        wait.until(ExpectedConditions.urlContains("example"));

        // 46. urlMatches(String regex)
        wait.until(ExpectedConditions.urlMatches(".+example\\.com.+"));

        // 47. urlToBe(String url)
        wait.until(ExpectedConditions.urlToBe("https://example.com"));

        // 48. visibilityOf(WebElement element)
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(elementAnd));

        // 49. visibilityOfAllElements(List<WebElement> elements)
        List<WebElement> allVisibleElements = wait.until(ExpectedConditions.visibilityOfAllElements(elementAnd, clickableElement));

        // 50. visibilityOfAllElements(WebElement... elements)
        List<WebElement> allVisibleElementsArray = wait.until(ExpectedConditions.visibilityOfAllElements(elementAnd, clickableElement));

        // 51. visibilityOfAllElementsLocatedBy(By locator)
        List<WebElement> allVisibleLocatedElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("exampleClass")));

        // 52. visibilityOfElementLocated(By locator)
        WebElement visibleLocatedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")));

        // 53. visibilityOfNestedElementsLocatedBy(By parent, By childLocator)
        List<WebElement> nestedVisibleElements = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.id("parentElement"), By.className("childClass")));

        // 54. visibilityOfNestedElementsLocatedBy(WebElement element, By childLocator)
        List<WebElement> nestedVisibleElements2 = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(elementAnd, By.className("childClass")));
         */
    }
}
