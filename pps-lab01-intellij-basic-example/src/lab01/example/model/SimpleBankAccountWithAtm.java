package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {
    private static final double FEE = 1.0f;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public double getFeesAmount() {
        return FEE;
    }

    @Override
    public boolean isWithdrawAllowed(double amount) {
        return this.getBalance() >= amount + FEE;
    }
}
