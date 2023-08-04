package ru.otus.ayakhnev.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDao {

    private int number;

    private String question;

    private List<String> answers;

    private String rightAnswer;

    public QuestionDao() {
    }

}
