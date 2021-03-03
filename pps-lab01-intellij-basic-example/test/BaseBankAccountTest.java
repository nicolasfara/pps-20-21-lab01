import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBankAccountTest {
    protected BankAccount bankAccount;
    protected AccountHolder accountHolder;
    protected double fee = 0.0f;

    public void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    public void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 50);
        assertEquals(50 - fee, bankAccount.getBalance());
    }

    public void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - fee, bankAccount.getBalance());
    }

    public void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - 2*fee, bankAccount.getBalance());
    }

    public void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - 2*fee, bankAccount.getBalance());
    }
}
