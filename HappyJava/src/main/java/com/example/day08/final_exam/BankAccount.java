package com.example.day08.final_exam;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final String getAccountInfo() {
        return "계좌 번호: " + accountNumber + ",\n잔액: " + balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, 10000.0);
        System.out.println(account.getAccountInfo());

        account.deposit(500);
        System.out.println(account.getAccountInfo());

        account.withdraw(200);
        System.out.println(account.getAccountInfo());
    }
}
