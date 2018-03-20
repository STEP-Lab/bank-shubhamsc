package com.thoughtworks.bank;

public class InvalidAccountNumberException extends Throwable {
  public InvalidAccountNumberException() {
    super("Invalid Account Number");
  }
}
