package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

  @Test
  public void printTransactions() throws FileNotFoundException, UnsupportedEncodingException {
    ArrayList<String> result = new ArrayList<>();
    transactions.debit(1000,"1234-1234");
    transactions.credit(1000,"1234-1234");
    PrintWriter writer = new PrintWriter("transactions.txt","utf-8"){
      @Override
      public void println(String x) {
        result.add(x);
      }
    };
    transactions.print(writer);
    writer.close();
    assertThat(result,hasItems(new DebitTransaction(new Date(),1000.0,"1234-1234").toString(),
            new CreditTransaction(new Date(),1000.0,"1234-1234").toString()));
  }

  @Test
  public void filterTransactionsByAmountGreaterThan() {
    transactions.credit(1200,"1234-1234");
    transactions.credit(1500,"1234-1234");
    transactions.credit(500,"1234-1234");
    Transactions filteredTransactions = this.transactions.filterByAmountGreaterThan(1000);
    assertThat(filteredTransactions.list,hasItems(new CreditTransaction(1200,"1234-1234"),new CreditTransaction(1500,"1234-1234")));
  }

  @Test
  public void filterTransactionsByAmountLesserThan() {
    transactions.credit(800,"1234-1234");
    transactions.credit(1500,"1234-1234");
    transactions.credit(500,"1234-1234");
    Transactions filteredTransactions = this.transactions.filterByAmountLesserThan(1000);
    assertThat(filteredTransactions.list,hasItems(new CreditTransaction(800,"1234-1234"),new CreditTransaction(500,"1234-1234")));
  }

  @Test
  public void filterAllCreditTransactions() {
    transactions.credit(2000,"1234-1234");
    transactions.debit(1500,"1234-1234");
    transactions.credit(500,"1234-1234");
    Transactions creditTransactions = transactions.filterAllCreditTransactions();
    assertThat(creditTransactions.list,hasItems(new CreditTransaction(2000,"1234-1234"),new CreditTransaction(500,"1234-1234")));
  }

  @Test
  public void filterAllDebitTransactions() {
    transactions.credit(2000,"1234-1234");
    transactions.debit(1000,"1234-1234");
    transactions.debit(500,"1234-1234");
    Transactions creditTransactions = transactions.filterAllDebitTransactions();
    assertThat(creditTransactions.list,hasItems(new DebitTransaction(1000,"1234-1234"),new DebitTransaction(500,"1234-1234")));
  }
}
