package ru.otus.ayakhnev.service;


import ru.otus.ayakhnev.domain.Question;

public class QuizConsoleService {

    private final CsvReaderService csvReaderService;

    private final String questionFileNameConstr;



    public QuizConsoleService(CsvReaderServiceImpl csvReaderServiceConstr, String questionFileNameConstr) {
        this.csvReaderService = csvReaderServiceConstr;
        this.questionFileNameConstr = questionFileNameConstr;
    }

    public void runQuiz() {
        printStart();
        this.csvReaderService.readQuiz(questionFileNameConstr);
        printWelcome();
        for (Question question : csvReaderService.getQuestions()) {
            question.printQuestion();
            question.printAnswers();
        }
    }

    public void clearQuiz() {
        this.csvReaderService.clearQuestions();
    }

    private void printWelcome() {
        System.out.println("Hi! You have launched a testing system. System issues:");
    }

    private void printStart() {
        System.out.println(" ********************************** QUIZ ********************************* ");
        System.out.println("Start Quiz, pleas wait");
    }


}
