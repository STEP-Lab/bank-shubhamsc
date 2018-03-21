package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction {
  private Date date;
  private final double amount;
  private final String account;

  protected DebitTransaction(Date date, double amount, String account) {
    this.date = date;
    this.amount = amount;
    this.account = account;
  }

  public Date getDate() {
    return date;
  }
}
