import com.thoughtworks.bank.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() {
    account = new Account("1234-1234", 1000.0);
  }

  @Test
  public void getBalance() {
    assertThat(account.getBalance(),is(1000.0));
  }
}
