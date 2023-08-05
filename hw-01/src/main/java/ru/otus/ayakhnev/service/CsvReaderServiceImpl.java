package ru.otus.ayakhnev.service;

import lombok.Getter;
import lombok.Setter;
import ru.otus.ayakhnev.domain.Question;
import ru.otus.ayakhnev.domain.QuestionDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        List<Question> questionList = new ArrayList<>();
        for (String fileName : fileNameList) {
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
                while ((line = reader.readLine()) != null) {
                    Question question = new QuestionDto();
                    question.readQuestion(line);
                    questionList.add(question);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        questions = questionList;
    }

    @Override
    public void clearQuestions() {
        this.questions = new ArrayList<>();
    }
}
