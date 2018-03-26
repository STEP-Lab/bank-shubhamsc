package com.thoughtworks.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
  protected CreditTransaction(Date date, double amount, String account) {
    super(account,amount,date);

  }

  public CreditTransaction(double amount, String account) {
    super(account,amount,new Date());
  }
}
