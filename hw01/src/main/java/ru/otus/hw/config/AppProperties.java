package ru.otus.hw.config;

public class AppProperties implements TestFileNameProvider {

    @Override
    public String getTestFileName() {
        return "src/main/resources/questions.csv";
    }
}
