# Coroutines Homework

## Задача

### Перейти с коллбеков на саспенд функции и корутины

1. Поменять возвращаемый тип в `CatsService` и добавить модификатор `suspend`
2. Переписать логику в презентере с `Callback` на корутины и `suspend` функции
3. Реализовать свой скоуп: PresenterScope с `MainDispatcher` и CoroutineName("CatsCoroutine") в качестве элементов контекста
4. Добавить обработку исключений через try-catch. В случае `java.net.SocketTimeoutException` показываем Toast с текстом "Не удалось получить ответ от сервером". В остальных случаях логируем исключение в `otus.homework.coroutines.CrashMonitor` и показываем Toast с `exception.message`
5. Не забываем отменять Job в `onStop()`

### Добавить к запросу фактов запрос рандомных картинок с [https://aws.random.cat/meow](https://aws.random.cat/meow)

1. На каждый рефреш экрана должен запрашиваться факт + картинка: добавляем сетевой запрос и реализуем логику аналогичную первой задаче. Для загрузки изображений уже подключена библиотека [Picasso](https://github.com/square/picasso)
2. В метод `view.populate` передаем 1 аргумент, поэтому необходимо реализовать модель презентейшен слоя в которой будут содержаться необходимые данные для рендеринга(текст и ссылка на картинку)
3. Отменятся запросы должны одновременно

### Реализовать решение ViewModel

1. Реализовать наследника `ViewModel` и продублировать в нем логику из `CatsPresenter`, с необходимыми изменениями. Используйте `viewModelScope` в качестве скоупа.
2. Добавить логирование ошибок через CoroutineExceptionHanlder. Используйте класс CrashMonitor в качестве фейкового CrashMonitor инструмента
3. Создать sealed класс `Result`. Унаследовать от него классы `Success<T>`, `Error`. Использовать эти классы как стейт необходимый для рендеринга/отображени ошибки


## Решение

Приложение переведено на coroutines.

В качестве сервиса получения случайных картинок используется [TheCat](https://developers.thecatapi.com/view-account/ylX4blBYT9FaoVd6OhvR?report=bOoHBz-8t), позволяющий получить список случайных изображений.

Представлены три варианта реализации задачи, находящиеся в ```app/src/main/java/otus/homework/coroutines/presentation```

1. ```/mvp``` - реализация *custom view* на основе паттеран `MVP`
2. ```/mvvm/parent``` - реализация *custom view* на основе паттерна ```MVVM``` и `findViewTreeViewModelStoreOwner`
3. ```/mvvm/owners``` - реализация *custom view* на основе паттерна ```MVVM``` и *custom* ```ViewModelStoreOwner, LifecycleOwner```
4. ```/mvi``` - реализация *custom view* на основе паттерна ```MVI``` и библиотеки ```MVICore```
