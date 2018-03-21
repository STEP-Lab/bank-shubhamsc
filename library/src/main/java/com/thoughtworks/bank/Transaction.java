package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
  protected final double amount;
  protected final String account;
  protected Date date;

  public Transaction(String account, double amount, Date date) {
    this.account = account;
    this.amount = amount;
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Double.compare(that.amount, amount) == 0 &&
            Objects.equals(account, that.account);
  }

  @Override
  public int hashCode() {

    return Objects.hash(amount, account);
  }
}
