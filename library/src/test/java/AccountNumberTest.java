import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Test;

public class AccountNumberTest {
  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithoutHyphen() throws MinimumBalanceException, InvalidAccountNumberException {
    new AccountNumber("12345678");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithLessNumber() throws MinimumBalanceException, InvalidAccountNumberException {
    new AccountNumber("1234-567");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberWithAlphabets() throws MinimumBalanceException, InvalidAccountNumberException {
    new AccountNumber("123b-a567");
  }
}
