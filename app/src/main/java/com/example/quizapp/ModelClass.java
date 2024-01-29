package com.example.quizapp;

public class ModelClass {

    String Question;
    String optiA;
    String optiB;
    String optiC;
    String optiD;
    String ans;

    public ModelClass(String question, String optiA, String optiB, String optiC, String optiD, String answer) {
        Question = question;
        this.optiA = optiA;
        this.optiB = optiB;
        this.optiC = optiC;
        this.optiD = optiD;
        this.ans = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOptiA() {
        return optiA;
    }

    public void setOptiA(String optiA) {
        this.optiA = optiA;
    }

    public String getOptiB() {
        return optiB;
    }

    public void setOptiB(String optiB) {
        this.optiB = optiB;
    }

    public String getOptiC() {
        return optiC;
    }

    public void setOptiC(String optiC) {
        this.optiC = optiC;
    }

    public String getOptiD() {
        return optiD;
    }

    public void setOptiD(String optiD) {
        this.optiD = optiD;
    }

    public String getAnswer() {
        return ans;
    }

    public void setAnswer(String answer) {
        this.ans = answer;
    }
}
