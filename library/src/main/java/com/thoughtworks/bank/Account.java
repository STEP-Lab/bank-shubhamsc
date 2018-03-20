package com.thoughtworks.bank;

public class Account {
  private String accountNumber;
  private double balance;
  private final double minimumBalance = 1000;

  public Account(String accountNumber, double balance) throws MinimumBalanceException {
    if(balance<minimumBalance){
      throw new MinimumBalanceException();
    }
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void credit(double amount) {
    this.balance += amount;
  }

  public void debit(double amount) throws MinimumBalanceException {
    checkForMinimumBalance(amount);
    this.balance -= amount;
  }

  private void checkForMinimumBalance(double amount) throws MinimumBalanceException {
    if(this.balance-amount<minimumBalance){
      throw new MinimumBalanceException();
    }
  }
}
