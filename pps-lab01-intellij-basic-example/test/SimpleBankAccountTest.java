import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BaseBankAccountTest {

    @BeforeEach
    void beforeEach(){
        super.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        super.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    public void testInitialBalance() {
        super.testInitialBalance();
    }

    @Test
    public void testDeposit() {
        super.testDeposit();
    }

    @Test
    public void testWrongDeposit() {
        super.testWrongDeposit();
    }

    @Test
    public void testWithdraw() {
        super.testWithdraw();
    }

    @Test
    public void testWrongWithdraw() {
        super.testWrongWithdraw();
    }
}
