package ru.otus.ayakhnev.service;

import ru.otus.ayakhnev.domain.Question;

import java.util.List;

public interface CsvReaderService {
    void readQuiz(String questionFileName);

    List<Question> getQuestions();

    void setQuestions(List<Question> questionList);

    void clearQuestions();
}
