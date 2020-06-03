package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void transfer(Account from, Account to, int amount){
        if (from.withdraw(amount))
            to.deposit(amount);
    }

    public void addAccount(Account acc){
        accounts.add(acc);
    }
    public long getTotalBalance(){
        long totalBalance = 0;
        for (Account acc : accounts)
            totalBalance += acc.getBalance();
        return totalBalance;
    }
    public Account getRandomAccount(){
        return accounts.get(new Random().nextInt(accounts.size()-1));
    }

}
