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
    public void readQuestion(String questionLine) {
        try (Scanner scanner = new Scanner(questionLine)) {
            scanner.useDelimiter(";");
            int indexInLine = 0;
            while (scanner.hasNext()) {
                String data = scanner.next().trim();
                parseDataToQuestion(data, indexInLine++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataToQuestion(String data, int index) {
        switch (index) {
            case 0 -> {
                if (data.isEmpty()) {
                    data = "-1";
                }
                this.setNumber(Integer.parseInt(data));
            }
            case 1 -> {
                this.setQuestion(data);
            }
            case 2 -> {
                this.setAnswers(new ArrayList<>());
                if (!data.isEmpty()) {
                    String[] answersArr = data.split(",");
                    this.setAnswers(Arrays.asList(answersArr));
                }
            }
            case 3 -> {
                this.setRightAnswer(data);
            }
            default -> {
            }
        }
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
