package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdraw is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractBankAccount {

    private static final double FEE = 0;

    public SimpleBankAccount(AccountHolder accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public double getFeesAmount() {
        return FEE;
    }

    @Override
    public boolean isWithdrawAllowed(double amount) {
        return this.getBalance() >= amount;
    }
}
