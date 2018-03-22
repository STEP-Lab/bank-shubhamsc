package com.thoughtworks.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void mustRecordCorrectTransactionDate() {
    Date date = new Date();
    DebitTransaction debitTransaction = new DebitTransaction(date,1000, "Another-Account");
    assertThat(debitTransaction.getDate(),is(date));
  }

  @Test
  public void mustRecordCorrectCreditTransactionDate() {
    Date date = new Date();
    CreditTransaction  creditTransaction = new CreditTransaction(date,1000,"1234-1234");
    assertThat(creditTransaction.getDate(),is(date));
  }
}
