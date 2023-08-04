package ru.otus.ayakhnev;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.ayakhnev.service.QuizConsoleService;


public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuizConsoleService service = context.getBean(QuizConsoleService.class);

        service.runQuiz();
    }

}
