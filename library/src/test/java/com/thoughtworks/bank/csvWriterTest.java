package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class csvWriterTest {
  private PrintWriter printWriter;
  private CSVWriter csvWriter;
  private String[] headers;

  @Before
  public void setUp() throws FileNotFoundException, UnsupportedEncodingException {
    printWriter = new PrintWriter("transactions.csv","utf-8");
    headers = new String[]{"Date","Amount","Account"};
    csvWriter = new CSVWriter(printWriter, headers);
  }

  @Test
  public void shouldWriteInCSVFormat() {
    ArrayList<Transaction> transactions = new ArrayList<>();
    transactions.add(new CreditTransaction( 1000,"1234-1234"));
    transactions.add(new DebitTransaction(1000,"1234-1234"));
    transactions.add(new CreditTransaction( 500,"1234-1234"));
    csvWriter.write(headers);
    csvWriter.write(transactions);
    csvWriter.close();
    assertThat(transactions,hasItems(new CreditTransaction( 1000,"1234-1234"),
            new DebitTransaction(1000,"1234-1234"),
            new CreditTransaction( 500,"1234-1234")));
  }
}
