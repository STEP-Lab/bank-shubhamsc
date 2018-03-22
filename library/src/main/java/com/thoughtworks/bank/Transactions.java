package com.thoughtworks.bank;

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
}
