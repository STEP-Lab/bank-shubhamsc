package com.thoughtworks.bank;

import org.junit.Test;

public class AccountNumberTest {
  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithoutHyphen() throws InvalidAccountNumberException {
    new AccountNumber("12345678");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithLessNumber() throws InvalidAccountNumberException {
    new AccountNumber("1234-567");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithAlphabets() throws InvalidAccountNumberException {
    new AccountNumber("123b-a567");
  }
}
