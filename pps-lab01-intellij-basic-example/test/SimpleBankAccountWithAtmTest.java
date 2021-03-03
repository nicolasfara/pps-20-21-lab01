import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleBankAccountWithAtmTest extends BaseBankAccountTest {

    @BeforeEach
    void beforeEach(){
        super.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        super.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
        super.fee = 1.0f;
    }

    @Test
    @Override
    public void testInitialBalance() {
        super.testInitialBalance();
    }

    @Test
    @Override
    public void testDeposit() {
        super.testDeposit();
    }

    @Test
    @Override
    public void testWithdraw() {
        super.testWithdraw();
    }

    @Test
    @Override
    public void testWrongWithdraw() {
        super.testWrongWithdraw();
    }

    @Test
    @Override
    public void testWrongDeposit() {
        super.testWrongDeposit();
    }
}