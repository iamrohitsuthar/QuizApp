package com.rohit.suthar.quizapp.models;

public class QuestionHolder {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionCorrect;


    public QuestionHolder(String question, String optionA, String optionB, String optionC, String optionD, String optionCorrect) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionCorrect = optionCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getOptionCorrect() {
        return optionCorrect;
    }

}
