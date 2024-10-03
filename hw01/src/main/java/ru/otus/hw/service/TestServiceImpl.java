package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.otus.hw.dao.QuestionDao;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

  private final IOService ioService;

  private final QuestionDao questionDao;

  @SneakyThrows
  @Override
  public void executeTest() {
    ioService.printLine("");
    ioService.printFormattedLine("Please answer the questions below");
    questionDao.findAll().forEach(System.out::println);
    // Получить вопросы из дао и вывести их с вариантами ответов
    ioService.printFormattedLine("ok");
  }
}
