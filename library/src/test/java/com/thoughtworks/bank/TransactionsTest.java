package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() {
    transactions = new Transactions();
  }

  @Test
  public void mustRecordDebitTransaction() {
    transactions.debit(1000,"1234-1234");
    assertThat(transactions.list,hasItem(new DebitTransaction(new Date(),1000,"1234-1234")));
  }

  @Test
  public void mustRecordCreditTransaction() {
    transactions.credit(1000,"1234-1234");
    assertThat(transactions.list,hasItem(new CreditTransaction(new Date(),1000,"1234-1234")));
  }

  @Test
  public void mustRecordBothTransactions() {
    transactions.debit(1000,"1234-1234");
    transactions.credit(1000,"1234-1234");
    assertThat(transactions.list,hasItems(new DebitTransaction(new Date(),1000,"1234-1234"),
            new CreditTransaction(new Date(),1000,"1234-1234")));
  }
}
