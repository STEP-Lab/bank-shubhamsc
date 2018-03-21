package com.thoughtworks.bank;


public class Account {
  private AccountNumber accountNumber;
  private double balance;
  private final double minimumBalance = 1000.00;

  public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
    checkForMinimumBalance(balance);
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public void credit(double amount) {
    this.balance += amount;
  }

  public void debit(double amount) throws MinimumBalanceException {
    checkForMinimumBalance(this.balance-amount);
    this.balance -= amount;
  }

  private void checkForMinimumBalance(double amount) throws MinimumBalanceException {
    if(amount<minimumBalance){
      throw new MinimumBalanceException();
    }
  }
}
