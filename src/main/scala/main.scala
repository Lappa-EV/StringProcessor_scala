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