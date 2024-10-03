package ru.otus.hw.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;


class StreamsIOServiceTest {

  @Test
  void testService() {
    PrintStream printStream = Mockito.mock(PrintStream.class);
    StreamsIOService ioService = new StreamsIOService(printStream);
    ioService.printFormattedLine("aaa ", "bbb");
    Mockito.verify(printStream).printf("aaa %n", "bbb");
  }

}