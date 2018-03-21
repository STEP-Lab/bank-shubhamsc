package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
  public AccountNumber(String accountNumber) throws InvalidAccountNumberException {
    checkForValidAccountNumber(accountNumber);
  }

  private void checkForValidAccountNumber(String accountNumber) throws InvalidAccountNumberException {
    String pattern = "\\b\\d{4}-\\d{4}\\b";
    Pattern regEx = Pattern.compile(pattern);
    Matcher matcher = regEx.matcher(accountNumber);
    if (!matcher.matches()){
      throw new InvalidAccountNumberException();
    }
  }
}
