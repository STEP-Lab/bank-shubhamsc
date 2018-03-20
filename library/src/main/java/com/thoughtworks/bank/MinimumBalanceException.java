package com.thoughtworks.bank;

public class MinimumBalanceException extends Throwable {
  MinimumBalanceException() {
    super("Amount is less than 1000");
  }
}
