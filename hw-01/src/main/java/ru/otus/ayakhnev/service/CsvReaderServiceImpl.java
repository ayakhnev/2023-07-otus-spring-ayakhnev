package ru.otus.ayakhnev.service;

import lombok.Getter;
import lombok.Setter;
import ru.otus.ayakhnev.domain.Question;
import ru.otus.ayakhnev.domain.QuestionDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Setter
@Getter
public class CsvReaderServiceImpl implements CsvReaderService {

    private List<Question> questions;

    @Override
    public void readQuiz(String questionFileName) {
        if (questions != null && !questions.isEmpty()) {
            return;
        }
        String line = null;
        List<String> fileNameList = new ArrayList<>();
        fileNameList.add(questionFileName);
        for (String fileName : fileNameList) {
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
                while ((line = reader.readLine()) != null) {
                    addQuestion(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void clearQuestions() {
        this.questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(String questionLine) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        try (Scanner scanner = new Scanner(questionLine)) {
            scanner.useDelimiter(";");
            int indexInLine = 0;
            Question question = new QuestionDto();
            while (scanner.hasNext()) {
                String data = scanner.next().trim();
                parseDataToQuestion(data, question, indexInLine++);
            }
            questions.add(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataToQuestion(String data, Question question, int index) {
        switch (index) {
            case 0 -> {
                if (data.isEmpty()) {
                    data = "-1";
                }
                question.setNumber(Integer.parseInt(data));
            }
            case 1 -> {
                question.setQuestion(data);
            }
            case 2 -> {
                question.setAnswers(new ArrayList<>());
                if (!data.isEmpty()) {
                    String[] answersArr = data.split(",");
                    question.setAnswers(Arrays.asList(answersArr));
                }
            }
            case 3 -> {
                question.setRightAnswer(data);
            }
            default -> {
            }
        }
    }
}
