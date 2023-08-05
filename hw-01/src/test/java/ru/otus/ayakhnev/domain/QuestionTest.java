package ru.otus.ayakhnev.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class QuestionTest {

    private Question question;

    @Before
    public void setUp() {
        this.question = new QuestionDto();
    }

    private void read4Params(){
        String dataLine = "5;On which tree do acorns grow?;a-Alder,b-Oak,c-Willow;b;";
        this.question.readQuestion(dataLine);
    }

    private void read3Params(){
        String dataLine = "5;On which tree do acorns grow?;a-Alder,b-Oak,c-Willow;;";
        this.question.readQuestion(dataLine);
    }

    private void read2Params(){
        String dataLine = "5;On which tree do acorns grow?;;;";
        this.question.readQuestion(dataLine);
    }

    private void read1Params(){
        String dataLine = "5;;;;";
        this.question.readQuestion(dataLine);
    }

    private void readEmptyParams(){
        String dataLine = ";;;;";
        this.question.readQuestion(dataLine);
    }

    private void readFullEmptyParams(){
        String dataLine = "";
        this.question.readQuestion(dataLine);
    }

    @Test
    public void readQuestion() {
        read4Params();
        Assertions.assertEquals(this.question.getRightAnswer(), "b", "Param value error RightAnswer");
        Assertions.assertEquals(this.question.getNumber(), 5, "Param value error Number");
        read3Params();
        Assertions.assertEquals(this.question.getRightAnswer(), "", "Param value error RightAnswer");
    }

    @Test
    public void printQuestion() {
    }

    @org.junit.jupiter.api.Test
    public void printAnswers() {
    }

    @org.junit.jupiter.api.Test
    public void getNumber() {
    }

    @org.junit.jupiter.api.Test
    public void getQuestion() {
    }

    @org.junit.jupiter.api.Test
    public void getAnswers() {
    }

    @org.junit.jupiter.api.Test
    public void getRightAnswer() {
    }
}