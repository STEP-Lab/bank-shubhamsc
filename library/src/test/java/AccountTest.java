import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException {
    account = new Account("1234-1234", 1000.00);
  }

  @Test
  public void getBalance() {
    assertThat(account.getBalance(),is(1000.00));
  }

  @Test
  public void getAccountNumber() {
    assertThat(account.getAccountNumber(),is("1234-1234"));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException {
    new Account("1234-1234", 800.00);
  }

  @Test
  public void creditAmount() {
    account.credit(1000.00);
    assertThat(account.getBalance(),is(2000.00));
  }

  @Test
  public void debitAmount() throws MinimumBalanceException {
    account.credit(2000.00);
    account.debit(1000.00);
    assertThat(account.getBalance(),is(2000.00));
  }

  @Test(expected = MinimumBalanceException.class)
  public void debitWhenInsufficientBalance() throws MinimumBalanceException {
    account.debit(500.00);
  }
}
