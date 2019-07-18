package com.example.yangyang_final.model;

public class Account {
    private long accountNumber;
    private double balance;
    private String opendate;

    public Account(long accountNumber, double balance, String opendate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.opendate = opendate;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
