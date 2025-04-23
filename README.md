# README.md

## Описание

Этот проект содержит объект `StringProcessor`, который обрабатывает список строк. В предыдущей версии код был написан 
в императивном стиле с использованием изменяемых переменных и циклов.
Задача проекта — преобразовать исходный код в функциональный стиль. 
## Задача

Исходный код выполнял следующие функции:
1. Принимал список строк.
2. Фильтровал строки длиной более 3 символов.
3. Преобразовывал отфильтрованные строки в верхний регистр.

```scala
object StringProcessor {
  def processStrings(strings: List[String]): List[String] = {
    var result = List[String]()
    for (str <- strings) {
      if (str.length > 3) {
        result = result :+ str.toUpperCase
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val strings = List("apple", "cat", "banana", "dog", "elephant")
    val processedStrings = processStrings(strings)
    println(s"Processed strings: $processedStrings")
  }
}
```

## Изменения

### Основные изменения в коде:
1. **Удаление изменяемых переменных**: Вместо использования переменной `result`, теперь используются методы `filter` 
и `map`, которые возвращают новый список.
2. **Функциональная обработка**: Вместо цикла `for`, код использует методы высшего порядка, такие как `filter` и `map`, что делает код более читаемым и компактным.
3. **Обработка ошибок**: Добавлена проверка на пустой список и обработка возможного исключения с использованием `Try`, `Success` и `Failure`.

### Пример кода

Ниже представлен новый код:

```scala
import scala.util.{Try, Success, Failure}

// Объект для обработки строк
object StringProcessor {

  // Обработка списка строк
  def processStrings(strings: List[String]): List[String] = {
    if (strings.isEmpty) {
      throw new IllegalArgumentException("Список ввода не может быть пустым")
    }

    strings
      .filter(_.length > 3)          // Фильтрация строк
      .map(_.toUpperCase)            // Преобразование в верхний регистр
  }

  // Точка входа в программу
  def main(args: Array[String]): Unit = {
    val inputStrings = Array("apple", "cat", "banana", "dog", "elephant").toList

    // Обработка ошибок
    Try(processStrings(inputStrings)) match {
      case Success(result) => println(s"Processed strings: $result")
      case Failure(exception) => println(s"An error occurred: ${exception.getMessage}")
    }
  }
}
```

## Запуск

1. Убедитесь, что у вас установлен Scala.
2. Клонируйте этот репозиторий:
   ```bash
   git clone https://github.com/Lappa-EV/StringProcessor_scala.git
   ```
3. Перейдите в папку проекта:
   ```bash
   cd StringProcessor
   ```
4. Запустите программу:
   ```bash
   scala main.scala
   ```

## Заключение

Данный проект демонстрирует подход к программированию в функциональном стиле, делая код более декларативным и легким для
понимания. 

## Ссылка на репозиторий

[Ссылка на GitHub репозиторий](https://github.com/Lappa-EV/StringProcessor_scala)


Выполнила: Лаппа Екатерина