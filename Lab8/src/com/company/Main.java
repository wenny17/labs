package com.company;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account tempAcc;
        Random r = new Random();
        for (int i = 0; i < 1000; i++){
            int a = Math.abs(r.nextInt());
            tempAcc = new Account(a);
            bank.addAccount(tempAcc);
            //System.out.println(a);
        }
        long correctBalance = bank.getTotalBalance();
        System.out.println(bank.getTotalBalance());
        ExecutorService exServ = Executors.newFixedThreadPool(30000);
        for(int i = 0;i<10000; i++){
            exServ.submit(() -> {
                Account acc1 = bank.getRandomAccount();
                Account acc2 = bank.getRandomAccount();
                int change = new Random().nextInt(10000);
                bank.transfer(acc1, acc2, change);
            });
        }
        exServ.shutdown();
        exServ.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        System.out.println(bank.getTotalBalance() == correctBalance);
    }
}
