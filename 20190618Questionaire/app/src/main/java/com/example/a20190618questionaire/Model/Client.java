package com.example.a20190618questionaire.Model;

import java.io.Serializable;

public class Client implements Serializable {
    private int clientNum;
    private String email;
    private String movie;

    public int getClientNum() {
        return clientNum;
    }

    public String getEmail() {
        return email;
    }

    public String getMovie() {
        return movie;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Client(int clientNum, String email, String movie) {
        this.clientNum = clientNum;
        this.email = email;
        this.movie = movie;
    }
}
