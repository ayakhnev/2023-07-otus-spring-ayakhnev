package ru.otus.ayakhnev.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDto implements Question {

    private int number;

    private String question;

    private List<String> answers = new ArrayList<>();

    private String rightAnswer;

    public QuestionDto() {
    }

    @Override
    public void printQuestion() {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("\n").append("Question №").append(this.getNumber()).append(" \"").append(this.getQuestion())
                .append("\"");
        System.out.println(queryStr);
    }

    @Override
    public void printAnswers() {
        StringBuilder queryAnswerStr = new StringBuilder();
        if (!this.getAnswers().isEmpty()) {
            queryAnswerStr.append("Response options: ");
            boolean isFirst = true;
            for (String answer : this.getAnswers()) {
                if (!isFirst) {
                    queryAnswerStr.append(", ");
                }
                queryAnswerStr.append(answer);
                isFirst = false;
            }
            System.out.println(queryAnswerStr);
        }
    }
}
