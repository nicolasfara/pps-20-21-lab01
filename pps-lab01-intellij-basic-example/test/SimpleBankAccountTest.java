import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {
    @Override
    protected BankAccount getBankAccount(final AccountHolder accountHolder, final double initialBalance) {
        return new SimpleBankAccount(accountHolder, initialBalance);
    }

    @Override
    protected double getExpectedBalanceAfterOperation(final double initialBalance, final double amount) {
        return initialBalance + amount;
    }
}
