package com.thoughtworks.bank;

import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter {
  private final PrintWriter writer;
  private final String[] header;

  public CSVWriter(PrintWriter writer, String[] header) {

    this.writer = writer;
    this.header = header;
  }

  public void write(ArrayList<Transaction> transactions) {
    for (Transaction transaction:transactions){
      writer.println(transaction.toCSV());
    }
  }

  public void close() {
    this.writer.close();
  }

  public void write(String[] headers) {
    writer.println(String.join(",", headers));
  }
}
