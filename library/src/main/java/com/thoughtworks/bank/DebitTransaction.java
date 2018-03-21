package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(Date date, double amount, String account) {
    super(account, amount, date);
  }

  public DebitTransaction(double amount, String account) {
    super(account,amount,new Date());
  }
}
