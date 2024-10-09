package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

  private final IOService ioService;

  private final QuestionDao questionDao;

  @SneakyThrows
  @Override
  public void executeTest() {
    ioService.printLine("");
    ioService.printFormattedLine("Please answer the questions below");
    questionDao.findAll().forEach(this::outQuestion);
    ioService.printFormattedLine("ok");
  }

  private void outQuestion(Question question) {
    ioService.printFormattedLine("Question: %s", question.text());
    AtomicInteger index=new AtomicInteger(1);
    question.answers().forEach(x -> outAnswer(index.getAndIncrement(), x));
  }

  private void outAnswer(int index, Answer answer) {
    ioService.printFormattedLine("\t %d:Answer %s \t[%s]",index, answer.text(),
        answer.isCorrect() ? "Good" : "wrong");
  }
}
