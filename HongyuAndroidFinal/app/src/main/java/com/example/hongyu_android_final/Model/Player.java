package com.example.hongyu_android_final.Model;

import androidx.annotation.Nullable;

public class Player implements Comparable<Player>{

    @Nullable
    private String Name;
    private String Question;
    private String userAnswer;
    private String realAnswer;
    private boolean isCorret;

    /*  Constructors */
    public Player() {}

    public Player(String name, String question, String userAnswer, String realAnswer, boolean isCorret) {
        Name = name;
        Question = question;
        this.userAnswer = userAnswer;
        this.realAnswer = realAnswer;
        this.isCorret = isCorret;
    }

    /*Setter and Getter*/
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public boolean isCorret() {
        return isCorret;
    }

    public void setCorret(boolean corret) {
        isCorret = corret;
    }


    /* toString */
    @Override
    public String toString() {
//        return "Player{" +
//                "Name='" + Name + '\'' +
//                ", Question='" + Question + '\'' +
//                ", userAnswer='" + userAnswer + '\'' +
//                ", realAnswer='" + realAnswer + '\'' +
//                ", isCorret=" + isCorret +
//                '}';

        String result;

        if (isCorret)
        {
            result = "Correct";
        }else{

            result = "Wrong";
        }

        return "[Player]:\t" + Name +
                "\n[Question]:\t" + Question+
                "\n[Player Answer]:\t" + userAnswer +
                "\n[Correct Answer]:\t" + realAnswer +
                "\n[Result]:\t" + result;
    }

    @Override
    public int compareTo(Player player) {
        return player.getUserAnswer().compareTo(userAnswer);
    }
}
