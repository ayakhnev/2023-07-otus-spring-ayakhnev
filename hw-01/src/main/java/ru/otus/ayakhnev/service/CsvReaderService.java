package ru.otus.ayakhnev.service;

import ru.otus.ayakhnev.domain.QuestionDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvReaderService {

    public List<QuestionDao> readQuiz(String questionFileName) {
        String line = null;
        List<String> fileNameList = new ArrayList<>();
        fileNameList.add(questionFileName);
        List<QuestionDao> questionList = new ArrayList<>();

        for (String fileName : fileNameList) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
                while ((line = reader.readLine()) != null) {
                    try (Scanner scanner = new Scanner(line)) {
                        scanner.useDelimiter(";");
                        int indexInLine = 0;

                        QuestionDao item = new QuestionDao();
                        questionList.add(item);
                        while (scanner.hasNext()) {
                            String data = scanner.next();
                            setQuestionParams(item, indexInLine, data);
                            indexInLine++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }

    private void setQuestionParams(QuestionDao item, int indexInLine, String data){
        switch (indexInLine) {
            case 0 -> {
                item.setNumber(Integer.parseInt(data));
            }
            case 1 -> {
                item.setQuestion(data);
            }
            case 2 -> {
                String[] answersArr = data.trim().split(",");
                if (answersArr.length > 0) {
                    item.setAnswers(Arrays.asList(answersArr));
                } else {
                    item.setAnswers(new ArrayList<>());
                }
            }
            case 3 -> {
                item.setRightAnswer(data);
            }
            default -> {
                //А тут вроде ничего и нет
            }
        }
    }
}