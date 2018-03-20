package com.thoughtworks.bank;

public class Account {
  private String accountNumber;
  private double balance;

  public Account(String accountNumber, double balance) {

    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

}
