package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {

    private final AccountHolder accountHolder;
    private double balance;

    public AbstractBankAccount(final AccountHolder accountHolder, final double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int usrID, double amount) {
        if (isRightUser(usrID)) {
            this.balance = this.balance + amount - getFeesAmount();
        }
    }

    @Override
    public void withdraw(int usrID, double amount) {
        if (isRightUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - getFeesAmount();
        }
    }

    public abstract double getFeesAmount();
    public abstract boolean isWithdrawAllowed(final double amount);

    private boolean isRightUser(final int userId) {
        return this.accountHolder.getId() == userId;
    }
}
