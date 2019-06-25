package com.example.math.Model;

public class QuestionAndAnswer {
    private String question;
    private int answer;
    private boolean judge;

    public QuestionAndAnswer(String question, int answer, boolean judge) {
        this.question = question;
        this.answer = answer;
        this.judge = judge;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isJudge() {
        return judge;
    }

    @Override
    public String toString() {
        return  "question: " + question +
                ", answer: " + answer +
                ", judge: " + judge
                ;
    }
}
