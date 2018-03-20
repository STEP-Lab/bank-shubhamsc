package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
  private String accountNumber;
  private double balance;
  private final double minimumBalance = 1000.00;

  public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
    checkForMinimumBalance(balance);
    checkForValidAccountNumber(accountNumber);
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  private void checkForValidAccountNumber(String accountNumber) throws InvalidAccountNumberException {
    String pattern = "\\b\\d{4}-\\d{4}\\b";
    Pattern regEx = Pattern.compile(pattern);
    Matcher matcher = regEx.matcher(accountNumber);
    if (!matcher.matches()){
      throw new InvalidAccountNumberException();
    }
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
    checkForMinimumBalance(this.balance-amount);
    this.balance -= amount;
  }

  private void checkForMinimumBalance(double amount) throws MinimumBalanceException {
    if(amount<minimumBalance){
      throw new MinimumBalanceException();
    }
  }
}
