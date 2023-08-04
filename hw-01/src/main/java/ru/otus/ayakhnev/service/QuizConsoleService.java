package ru.otus.ayakhnev.service;


import ru.otus.ayakhnev.domain.QuestionDao;

import java.util.List;

public class QuizConsoleService {

    private boolean isStop = true;

    private final CsvReaderService csvReaderService;


    /**
     * Сформированный список вопросов
     */
    private final List<QuestionDao> questList;



    public QuizConsoleService(CsvReaderService csvReaderServiceConstr, String questionFileNameConstr) {
        this.csvReaderService = csvReaderServiceConstr;
        this.questList = this.csvReaderService.readQuiz(questionFileNameConstr);
    }

    public void runQuiz() {
        printWelcome();
        for (QuestionDao question : questList) {
            this.printQuestion(question);
        }
    }

    private void printWelcome() {
        System.out.println(" ********************************** QUIZ ********************************* ");
        System.out.println("Hi! You have launched a testing system. System issues:");
    }

    private void printQuestion(QuestionDao question) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("Question №").append(question.getNumber()).append(" \"").append(question.getQuestion()).append("\"").append("\n");
        queryStr.append("Response options: ");
        boolean isFirst = true;
        for (String answer : question.getAnswers()) {
            if (!isFirst){
                queryStr.append(", ");
            }
            queryStr.append(answer);
            isFirst = false;
        }
        System.out.println(queryStr);
    }

    private void printContinue() {
        System.out.println("Continue? If yes, enter \"y\". If not, enter \"n\".");
    }

    private void printBye() {
        System.out.println("You have answered all the questions. The result will be reported to you.");
    }

    private void printExit() {
        System.out.println("Bye!");
    }
}
