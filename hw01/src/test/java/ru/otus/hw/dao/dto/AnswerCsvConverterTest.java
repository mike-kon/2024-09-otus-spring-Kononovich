package ru.otus.hw.dao.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw.domain.Answer;

import static org.junit.jupiter.api.Assertions.*;

class AnswerCsvConverterTest {

  @Test
  @DisplayName("Проверка на правильности")
  void convertTrue() {
    String input = "aaaa%true";
    AnswerCsvConverter answerCsvConverter = new AnswerCsvConverter();
    Answer answer = answerCsvConverter.convertToRead(input);
    assertEquals("aaaa", answer.text());
    assertTrue(answer.isCorrect());
  }

  @Test
  @DisplayName("Проверка на ложности")
  void convertFalse() {
    String input = "bbbb%false";
    AnswerCsvConverter answerCsvConverter = new AnswerCsvConverter();
    Answer answer = answerCsvConverter.convertToRead(input);
    assertEquals("bbbb", answer.text());
    assertFalse(answer.isCorrect());
  }

  @Test
  @DisplayName("Проверка на неправильный ввод (без разделителя)")
  void convertWrong() {
    String input = "ccc";
    AnswerCsvConverter answerCsvConverter = new AnswerCsvConverter();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> answerCsvConverter.convertToRead(input));
  }

}