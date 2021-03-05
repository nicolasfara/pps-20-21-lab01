import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {
    private final static double FEE = 1;
    private static final double MAX_WITHDRAW_ALLOWED = 100;

    @Test
    public void testWithdrawFeeOutOfBalance() {
        this.bankAccount.withdraw(this.accountHolder.getId(), MAX_WITHDRAW_ALLOWED);
        // No withdraw should be done (no available money)
        assertEquals(MAX_WITHDRAW_ALLOWED, this.bankAccount.getBalance());
    }

    @Override
    protected BankAccount getBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithAtm(accountHolder, initialBalance);
    }

    @Override
    protected double getExpectedBalanceAfterOperation(double initialBalance, double amount) {
        return initialBalance + amount - FEE;
    }
}