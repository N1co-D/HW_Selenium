package fourthlesson;

public class WebDriverWaitMethodsNotes {
    public static void main(String[] args) {
        /*
        timeoutException(String message, Throwable lastException):  Этот метод выбрасывает исключение по таймауту.

        ignoreAll(Collection types):                                Игнорирует все исключения, которые содержатся в переданной коллекции.
        ignoring(Class exceptionType):                              Игнорирует конкретный тип исключения.
        pollingEvery(Duration duration):                            Определяет частоту, с которой FluentWait должен проверять условия.
        until(Function condition):                                  Повторяет проверку условия, пока оно не станет истинным или пока не истечет время ожидания.
        withMessage(String message):                                Определяет сообщение, которое должно быть включено в исключение, если время ожидания истекло.
        withTimeout(Duration duration):                             Определяет максимальное время ожидания


        ignoreAll(Collection types):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoreAll(Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class));

        ignoring(Class exceptionType):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoring(NoSuchElementException.class);

        pollingEvery(Duration duration):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofMillis(500));

        until(Function condition):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element_id")));

        withMessage(String message):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withMessage("Element was not found within the timeout");

        withTimeout(Duration duration):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withTimeout(Duration.ofSeconds(30));
         */
    }
}
