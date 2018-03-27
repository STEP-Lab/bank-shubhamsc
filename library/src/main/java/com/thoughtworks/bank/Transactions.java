package com.thoughtworks.bank;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Transactions {
  protected ArrayList<Transaction> list;

  public Transactions() {
    this.list = new ArrayList<>();
  }

  public void debit(double amount, String account) {
    this.list.add(new DebitTransaction(amount,account));
  }

  public void credit(double amount, String account) {
    this.list.add(new CreditTransaction(amount,account));
  }

  public Transactions filterByAmountGreaterThan(double amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction : list){
      if (transaction.getAmount()>amount)
        transactions.list.add(transaction);
    }
    return transactions;
  }

  public void print(PrintWriter writer) {
    for (Transaction transaction : list){
      writer.println(transaction.toString());
    }
  }

  public Transactions filterByAmountLesserThan(double amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction : list){
      if (transaction.getAmount()<amount)
        transactions.list.add(transaction);
    }
    return transactions;
  }

  public Transactions filterAllCreditTransactions() {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list){
      if(transaction instanceof CreditTransaction ){
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }

  public Transactions filterAllDebitTransactions() {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list){
      if(transaction instanceof DebitTransaction ){
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }
}
