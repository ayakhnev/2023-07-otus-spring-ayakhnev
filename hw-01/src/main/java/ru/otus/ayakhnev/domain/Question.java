package ru.otus.ayakhnev.domain;

import java.util.List;

public interface Question {

    void readQuestion(String questionLine);

    void printQuestion();

    void printAnswers();

    int getNumber();

    String getQuestion();

    List<String> getAnswers();

    String getRightAnswer();
}
