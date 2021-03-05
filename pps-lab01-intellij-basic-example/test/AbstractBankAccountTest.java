import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    private static final int HOLDER_ID = 1;
    private static final int WRONG_HOLDER_ID = 2;
    private static final double INITIAL_BALANCE = 100;
    private static final double DEPOSIT_AMOUNT = 40;
    private static final double WITHDRAW_AMOUNT = 20;

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    public void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", HOLDER_ID);
        this.bankAccount = getBankAccount(this.accountHolder, INITIAL_BALANCE);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(getExpectedBalanceAfterOperation(INITIAL_BALANCE, DEPOSIT_AMOUNT), this.bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        this.bankAccount.withdraw(this.accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(getExpectedBalanceAfterOperation(INITIAL_BALANCE, -WITHDRAW_AMOUNT), this.bankAccount.getBalance());
    }

    @Test
    public void testDepositWrongUser() {
        this.bankAccount.deposit(WRONG_HOLDER_ID, DEPOSIT_AMOUNT);
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    public void testWithdrawWrongUser() {
        this.bankAccount.withdraw(WRONG_HOLDER_ID, WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    protected abstract BankAccount getBankAccount(final AccountHolder accountHolder, final double initialBalance);
    protected abstract double getExpectedBalanceAfterOperation(final double initialBalance, final double amount);
}
