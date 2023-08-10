package ru.otus.ayakhnev.domain;

import java.util.List;

public interface Question {


    void printQuestion();

    void printAnswers();

    int getNumber();

    void setNumber(int number);

    String getQuestion();

    void  setQuestion(String question);

    List<String> getAnswers();

    void setAnswers(List<String> answers);

    String getRightAnswer();

    void setRightAnswer(String rightAnswer);
}
