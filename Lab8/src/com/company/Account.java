package com.company;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int balance){
        this.balance = balance;
    }

    public boolean withdraw(int amount){
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;

    }

    public boolean deposit(int amount){
        balance += amount;
        return true;
    }
}
