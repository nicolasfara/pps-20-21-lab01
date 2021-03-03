package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {
    private static final double FEE = 1.0f;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        super.deposit(usrID, amount - FEE);
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        super.withdraw(usrID, amount + FEE);
    }
}
